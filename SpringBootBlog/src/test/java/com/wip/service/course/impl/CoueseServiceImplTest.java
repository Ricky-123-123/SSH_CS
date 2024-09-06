package com.wip.service.course.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.wip.dto.cond.ContentCond;
import com.wip.model.CourseDomain;
import com.wip.model.MetaDomain;
import com.wip.service.course.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoueseServiceImplTest {
	@Autowired
	private CourseService courseService;
	
	@Test
	public void addCourse() {
		CourseDomain course = new CourseDomain();
		course.setTitle("123");
		course.setContent("123");
		courseService.addCourse(course);
	}
	
	@Test
	public void getCourseById() {
		courseService.getCourseById(34);
	}
	
	@Test
	public void updateCourseById() {
		CourseDomain course = new CourseDomain();
		course.setCourseid(34);
		course.setTitle("123");
		course.setContent("123");
		courseService.updateCourseById(course);
	}
	
	@Test
	public void getCourseyCond() {
		PageInfo<CourseDomain> courses = courseService.getCourseyCond(new ContentCond(), 1, 1);
		System.out.println(courses);
	}
	
	@Test
	public void deleteCourseById() {
		courseService.deleteCourseById(35);
	}
	
	@Test
	public void getCourseByCategory() {
		courseService.getCourseByCategory("默认分类");
	}
	
	@Test
	public void getCourseByTags() {
		MetaDomain tags =new MetaDomain();
		tags.setMid(123);
		courseService.getCourseByTags(tags);
	}
}
