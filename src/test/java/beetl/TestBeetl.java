package beetl;

import java.io.File;
import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.junit.Test;




public class TestBeetl {
	
	
	
	@Test
	public void test1() throws IOException {
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("hello,${name}");
		t.binding("name", "beetl");
		String str = t.render();
		System.out.println(str);
	}
	
	
	@Test
	public void test2() throws IOException {
		String root = System.getProperty("user.dir")+File.separator+"template";
		FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("/s01/hello.txt");
		String str = t.render();
		System.out.println(str);
	}
	
	
	@Test
	public void test3() throws IOException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("org/beetl/demo1/");
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("/hello.txt");
		String str = t.render();
		System.out.println(str);
	}
	
	
	@Test
	public void test4() throws IOException {
		Configuration cfg = Configuration.defaultConfiguration();
		WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		
		Template t = gt.getTemplate("/pom.xml");
		String str = t.render();
		System.out.println(str);
		
	}
	
	
	
	

}
