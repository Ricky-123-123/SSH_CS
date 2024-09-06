package com.wip.service.course.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wip.constant.ErrorConstant;
import com.wip.constant.Types;
import com.wip.constant.WebConst;
import com.wip.dao.CommentDao;
import com.wip.dao.CourseDao;
import com.wip.dao.RelationShipDao;
import com.wip.dto.cond.ContentCond;
import com.wip.exception.BusinessException;
import com.wip.model.CommentDomain;
import com.wip.model.CourseDomain;
import com.wip.model.MetaDomain;
import com.wip.model.RelationShipDomain;
import com.wip.service.course.CourseService;
import com.wip.service.meta.MetaService;

@Service
public class CourseServiceImp implements CourseService{	
	@Autowired
    private CourseDao courseDao;
	
	@Autowired
    private MetaService metaService;

    @Autowired
    private RelationShipDao relationShipDao;

    @Autowired
    private CommentDao commentDao;
	
    @Transactional
    @Override
	public void addCourse(CourseDomain course) {
    	 if (null == course)
             throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);

         if (StringUtils.isBlank(course.getTitle()))
             throw BusinessException.withErrorCode(ErrorConstant.Course.TITLE_CAN_NOT_EMPTY);

         if (course.getTitle().length() > WebConst.MAX_TITLE_COUNT)
             throw BusinessException.withErrorCode(ErrorConstant.Course.TITLE_IS_TOO_LONG);

         if (StringUtils.isBlank(course.getContent()))
             throw BusinessException.withErrorCode(ErrorConstant.Course.COURSE_CAN_NOT_EMPTY);

         if (course.getContent().length() > WebConst.MAX_CONTENT_COUNT)
             throw BusinessException.withErrorCode(ErrorConstant.Course.COURSE_IS_TOO_LONG);
         
         // 取到标签和分类
         String tags = course.getTags();
         String categories = course.getCategories();
         
         // 添加教程
         courseDao.addCourse(course);
         
     // 添加分类和标签
     int courseid = course.getCourseid();
     metaService.addMetas(courseid, tags, Types.TAG.getType());
     metaService.addMetas(courseid, categories, Types.CATEGORY.getType());
	
	}

	@Override
	public CourseDomain getCourseById(Integer courseid) {
		 if (null == courseid)
	            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
	        return courseDao.getCourseById(courseid);
	}

	@Override
	public void updateCourseById(CourseDomain course) {
		// 取到标签和分类
        String tags = course.getTags();
        String categories = course.getCategories();
        
        // 更新文章
        courseDao.updateCourseById(course);
        int courseid = course.getCourseid();
        relationShipDao.deleteRelationShipByCid(courseid);
        metaService.addMetas(courseid,tags,Types.TAG.getType());
        metaService.addMetas(courseid,categories,Types.CATEGORY.getType());

		
	}

	@Override
	public PageInfo<CourseDomain> getCourseyCond(ContentCond contentCond, int pageNum, int pageSize) {
		if (null == contentCond)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        PageHelper.startPage(pageNum,pageSize);
        List<CourseDomain> courses = courseDao.getCourseyCond(contentCond);
        PageInfo<CourseDomain> pageInfo = new PageInfo<>(courses);
        return pageInfo;
	}

	@Override
	public void deleteCourseById(Integer courseid) {
		if (null == courseid)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
		//删除教程
		courseDao.deleteCourseById(courseid);
		// 同时要删除该 文章下的所有评论
        List<CommentDomain> comments = commentDao.getCommentByCId(courseid);
        if (null != comments && comments.size() > 0) {
            comments.forEach(comment -> {
                commentDao.deleteComment(comment.getCoid());
            });
        }
        
        // 删除标签和分类关联
        List<RelationShipDomain> relationShips = relationShipDao.getRelationShipByCid(courseid);
        if (null != relationShips && relationShips.size() > 0) {
            relationShipDao.deleteRelationShipByCid(courseid);
        }
		
	}

	@Override
	public void updateCourseByCourseid(CourseDomain course) {
		if (null != course && null != course.getCourseid()) {
            courseDao.updateCourseById(course);
        }
	}

	@Override
	public List<CourseDomain> getCourseByCategory(String category) {
		 if (null == category)
	            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
	        return courseDao.getCourseByCategory(category);
	}

	@Override
	public List<CourseDomain> getCourseByTags(MetaDomain tags) {
		if (null == tags)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        List<RelationShipDomain> relationShip = relationShipDao.getRelationShipByMid(tags.getMid());
        if (null != relationShip && relationShip.size() > 0) {
            return courseDao.getCourseByTags(relationShip);
        }
        return null;
	}

}
