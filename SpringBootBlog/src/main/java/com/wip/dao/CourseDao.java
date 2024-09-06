package com.wip.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wip.dto.cond.ContentCond;
import com.wip.model.CourseDomain;

import com.wip.model.RelationShipDomain;


@Mapper
public interface CourseDao {
	 /**
     * 添加教程
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
     * @return
     */
    List<CourseDomain> getCourseyCond(ContentCond contentCond);

    /**
     * 删除教程
     * @param cid
     */
    void deleteCourseById(Integer courseid);

    /**
     * 获取教程总数
     * @return
     */
    Long getCourseCount();

    /**
     * 通过分类名获取教程
     * @param category
     * @return
     */
    List<CourseDomain> getCourseByCategory(@Param("category") String category);

    /**
     * 通过标签获取教程
     * @param cid
     * @return
     */
    List<CourseDomain> getCourseByTags(List<RelationShipDomain> courseid);
}
