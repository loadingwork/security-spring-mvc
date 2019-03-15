package datasource.jdbc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   测试Test  SqlSessionTemplate
 * @author root
 *
 */
// 配置上下文件环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:test-load-properties.xml",
		"classpath:spring/datasource/spring-datasource-test.xml",
		"classpath:spring/jdbc/spring-datasource-jdbc-mybatis.xml"
})
public class TestMybatisSqlSessionTemplate {
	
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Test
	public void testNotNull() {
		assertNotNull(sqlSessionTemplate);
	}

}
