package com.lw.mvc.minidao.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lw.mvc.domain.po.DemoMiniDaoPO;




//配置上下文件环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:test-load-properties.xml",
		"classpath:spring/datasource/spring-datasource-test.xml",
		"classpath:spring/jdbc/spring-datasource-jdbc-minidao.xml"
})
public class DemoMiniDaoTest {
	
	
	@Autowired
	private DemoMiniDao demoMiniDao;
	

	@Test
	public void testNotNull() {
		assertNotNull(demoMiniDao);
	}
	
	
	
	
	@Test
	public void testInsert() {
		
		DemoMiniDaoPO demoMiniDaoPO = new DemoMiniDaoPO();
		demoMiniDaoPO.setId(1);
		demoMiniDaoPO.setName("name");
		demoMiniDao.insert(demoMiniDaoPO);
		
	}
	
	
	
	@Test
	public void testGet() {
		
		DemoMiniDaoPO demoMiniDaoPO = demoMiniDao.get(1);
		System.out.println(demoMiniDaoPO);
		
	}
	

}
