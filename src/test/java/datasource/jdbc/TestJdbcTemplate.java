package datasource.jdbc;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   测试TestJdbcTemplate
 * @author root
 *
 */
// 配置上下文件环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:test-load-properties.xml",
		"classpath:spring/datasource/spring-datasource-test.xml",
		"classpath:spring/jdbc/spring-datasource-jdbc-spring.xml"
})
public class TestJdbcTemplate {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Test
	public void testNotNull() {
		assertNotNull(jdbcTemplate);
	}
	
	
	
	@Test
	public void testSelect() {
		
		Date queryForObject = jdbcTemplate.queryForObject("select NOW()", Date.class);
		System.out.println(queryForObject);
		
	}
	
	

}
