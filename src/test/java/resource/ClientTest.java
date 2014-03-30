package resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import admin.rssreader.entity.Article;
import admin.rssreader.resource.ArticleResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class ClientTest {

	@Autowired
	ArticleResource articleResource;
	
	@Test
	public void testGet() {
		Article ar = this.articleResource.getArticle("532d5d1385c16311cb2d6ce2");
		
		System.out.println(ar);
	}

	@Test
	public void testPost() {
		Article article = new Article();
		
		article.setContent("today is sunny");
		article.setLink("www.ifeve.com");
		article.setPublishedDate("2014-04-05 12:23:11");
		article.setSourceName("ifeve");
		article.setTitle("并发编程网");
		
		this.articleResource.addArticle(article);
	}
	
	@Test
	public void testPut() {
		Article ar = this.articleResource.getArticle("532d5d1385c16311cb2d6ce2");
		ar.setContent("tomorrow is sunday");
		
		this.articleResource.updateArticle(ar);
	}
	
	@Test
	public void testDelete() {
		this.articleResource.deleteArticle("532d5d1385c16311cb2d6ce2");
	}
}
