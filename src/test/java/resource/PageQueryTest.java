package resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import admin.rssreader.resource.ArticleResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class PageQueryTest {

	@Autowired
	ArticleResource articleResource;
	
	@Test
	public void test() {
		String result = articleResource.getArticlesByPage("1", "15", "");
		System.out.println(result);
	}

}
