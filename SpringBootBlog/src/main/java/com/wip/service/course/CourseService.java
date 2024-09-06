package com.wip.service.course;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wip.dto.cond.ContentCond;
import com.wip.model.CourseDomain;
import com.wip.model.MetaDomain;
/**
 * 教程相关Service接口
 * @author Administrator
 *
 */
public interface CourseService {
	
	/***
	添加教程
    * @param contentDomain
    */
   void addCourse(CourseDomain course);

   /**
    * 根据编号获取教程
    * @param cid
    * @return
    */
   CourseDomain getCourseById(Integer courseid);

   /**
    * 更新教程
    * @param contentDomain
    */
   void updateCourseById(CourseDomain course);

   /**
    * 根据条件获取教程列表
    * @param contentCond
    * @param page
    * @param limit
    * @return
    */
   PageInfo<CourseDomain> getCourseyCond(ContentCond contentCond, int page, int limit);

   /**
    * 删除教程
    * @param cid
    */
   void deleteCourseById(Integer courseid);

   /**
    * 添加教程点击量
    * @param content
    */
   void updateCourseByCourseid(CourseDomain course);

   /**
    * 通过分类获取教程
    * @param category
    * @return
    */
   List<CourseDomain> getCourseByCategory(String category);

   /**
    * 通过标签获取教程
    * @param tags
    * @return
    */
   List<CourseDomain> getCourseByTags(MetaDomain tags);
}
