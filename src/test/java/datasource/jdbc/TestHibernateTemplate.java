package datasource.jdbc;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




/**
 * Test HibernateTemplate
 * @author root
 *
 */
//配置上下文件环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:test-load-properties.xml",
		"classpath:spring/datasource/spring-datasource-test.xml",
		"classpath:spring/jdbc/spring-datasource-jdbc-hibernate.xml"
})
public class TestHibernateTemplate {
	
	
	/**
	 * session工厂
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * spring hibernate 操作模板
	 */
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Test
	public void testNotNull() {
		assertNotNull(sessionFactory);
		assertNotNull(hibernateTemplate);
	}
	
	
	
	@Test
	public void testSelect() {
		
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		NativeQuery<Date> query = session.createNativeQuery("select now()");
		
		Date singleResult = query.getSingleResult();
		
		System.out.println(singleResult);
		
	}
	
	
	
	

}
