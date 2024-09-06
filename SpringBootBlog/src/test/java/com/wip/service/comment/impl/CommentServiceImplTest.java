package com.wip.service.comment.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.dto.cond.CommentCond;
import com.wip.model.CommentDomain;
import com.wip.service.comment.CommentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceImplTest {
	@Autowired
	private CommentService commentService;
	
	@Test
	public void addComment() {
		CommentDomain commentDomain=new CommentDomain();
		commentDomain.setCid(36);
		commentDomain.setContent("000123");
		commentDomain.setEmail("1476713020@qq.com");
		commentService.addComment(commentDomain);
	}
	
//	@Test
//	public void getCommentsByCId() {
//		commentService.getCommentById(36);
//	}
//	
//	@Test
//	public void getCommentsByCond() {
//		commentService.getCommentsByCond(new CommentCond(), 1, 15);
//	}
//	
//	@Test
//	public void getCommentById() {
//		commentService.getCommentById(4);
//	}
//	
//	@Test
//	public void updateCommentStatus() {
//		commentService.updateCommentStatus(4, "approved");
//	}
//	
//	@Test
//	public void deleteComment() {
//		commentService.deleteComment(5);
//	}
}
