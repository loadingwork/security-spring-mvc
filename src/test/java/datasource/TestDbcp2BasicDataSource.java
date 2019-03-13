package datasource;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试Dbcp1数据源
 * @author root
 *
 */
// 配置上下文件环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:spring/datasource/spring-datasource-dbcp2.xml",
		"classpath:test-load-properties.xml"
})
public class TestDbcp2BasicDataSource {
	
	@Autowired
	private DataSource dataSource;
	
	
	/**
	 * 测试数据源是否为空
	 */
	@Test
	public void testDataSource() {
		assertNotNull(dataSource);
	}
	
	
	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		assertNotNull(connection);
		
		if (connection != null) {
			connection.close();
		}
		
	}
	
	

}
