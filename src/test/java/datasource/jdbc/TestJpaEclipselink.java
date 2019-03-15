package datasource.jdbc;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test  Test  Jpa  Eclipselink
 * @author root
 *
 */
//配置上下文件环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:test-load-properties.xml",
		"classpath:spring/datasource/spring-datasource-test.xml",
		"classpath:spring/jdbc/spring-datasource-jdbc-jpa-eclipselink.xml"
})
public class TestJpaEclipselink {
	
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	

	@Autowired
	private EntityManager  entityManager;
	
	@Test
	public void testNotNull() {
		assertNotNull(entityManagerFactory);
		
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		assertNotNull(createEntityManager);
		
		assertNotNull(entityManager);
		
	}
	
	
	
	
	
	

}
