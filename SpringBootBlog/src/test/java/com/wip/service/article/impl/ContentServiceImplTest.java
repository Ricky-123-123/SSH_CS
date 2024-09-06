package com.wip.service.article.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.wip.dto.cond.ContentCond;
import com.wip.model.ContentDomain;
import com.wip.model.MetaDomain;
import com.wip.service.article.ContentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContentServiceImplTest {
	@Autowired
	ContentService contentService;
	
//	@Test
//	public void addArticle() {
//		ContentDomain contentDomain = new ContentDomain();
//		contentDomain.setTitle("456");
//		contentDomain.setContent("456");
//		contentService.addArticle(contentDomain);
//	}
//	
//	@Test
//	public void getArticleById() {
//		contentService.getArticleById(34);
//	}
//	
//	@Test
//	public void updateArticleById() {
//		ContentDomain contentDomain = new ContentDomain();
//		contentDomain.setCid(36);
//		contentDomain.setTags("666");
//		contentService.updateArticleById(contentDomain);
//	}
	
	@Test
	public void getArticlesByCond() {
		PageInfo<ContentDomain> articles = contentService.getArticlesByCond(new ContentCond(), 1, 15);
		System.err.println(articles);
	}
	
//	@Test
//	public void deleteArticleById() {
//		contentService.deleteArticleById(35);
//	}
//	
//	@Test
//	public void updateContentByCid() {
//		ContentDomain contentDomain = new ContentDomain();
//		contentDomain.setCid(34);
//		contentDomain.setTitle("333");
//		contentDomain.setContent("333");
//		contentService.updateContentByCid(contentDomain);
//	}
//	
//	@Test
//	public void getArticleByTags() {
//		MetaDomain meyaDomain =new MetaDomain();
//		meyaDomain.setMid(50);
//		contentService.getArticleByTags(meyaDomain);
//	}
}
