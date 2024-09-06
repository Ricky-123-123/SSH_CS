package com.wip.service.meta.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.dto.cond.MetaCond;
import com.wip.model.MetaDomain;
import com.wip.service.meta.MetaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaServiceImplTest {

	@Autowired
	private MetaService metaService;
	
	@Test
	public void saveMeta() {
		metaService.saveMeta("tag", "234", null);
	}
	
	@Test
	public void saveMeta2() {
		metaService.saveMeta("tag", "209", 53);
	}
	
	@Test
	public void getMetaList() {
		metaService.getMetaList("tag", null, 5);
	}
	
	@Test
	public void addMetas() {
		metaService.addMetas(35, "333", "tag");
	}
	
	@Test
	public void saveOrUpdate() {
		metaService.saveOrUpdate(35, "333", "tag");
	}
	
	@Test
	public void addMea() {
		MetaDomain meta = new MetaDomain();
		meta.setName("88667");
		meta.setType("tag");
		metaService.addMea(meta);
	}
	
	@Test
	public void getMetasCountByType() {
		metaService.getMetasCountByType("tag");
	}
	
	@Test
	public void getMetaByName() {
		metaService.getMetaByName("tag", "222");
	}
	
	@Test
	public void deleteMetaById() {
		metaService.deleteMetaById(53);
	}
	
	@Test
	public void getMetas() {
		metaService.getMetas(new MetaCond());
	}
}
