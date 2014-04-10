package resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import admin.rssreader.resource.ArticleResource;
import admin.rssreader.resource.impl.BaseResourceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class HeaderTest {
	
	@Autowired
	ArticleResource articleResource;
	
	@Test
	public void test() {
		BaseResourceImpl.setAuthInfo("zhangsan", "123456");
		String result = articleResource.getArticlesByPage("1", "10", "");
		
		System.out.println(result);
	}
}
