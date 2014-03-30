package admin.rssreader.resource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import admin.rssreader.entity.Article;
import admin.rssreader.provider.ArticleDtoMessageBodyReader;
import admin.rssreader.provider.ArticleMessageBodyReader;
import admin.rssreader.provider.ArticleMessageBodyWriter;

@Service
public class ArticleResource extends BaseResource {
	
	public Article getArticle(String id) {
		Article article = target.path("article/" + id).register(ArticleMessageBodyReader.class)
				.request(MediaType.APPLICATION_JSON).get(Article.class);
		
		return article;
	}
	
	public void addArticle(Article article) {
		target.path("article").register(ArticleMessageBodyWriter.class)
				.request().post(Entity.entity(article, MediaType.APPLICATION_JSON)).close();
	}
	
	public void updateArticle(Article article) {
		target.path("article").register(ArticleMessageBodyWriter.class)
				.request().put(Entity.entity(article, MediaType.APPLICATION_JSON)).close();
	}
	
	public void deleteArticle(String id) {
		target.path("article/" + id).request().delete().close();;
	}
	
/*
	public List<ArticleDto> getArticleListByPage(int pageIndex, int pageSize) {
		List<Map<String,String>> list = (List<Map<String,String>>)target.path("article/" + pageSize + "/" + pageIndex).register(ArticleDtoMessageBodyReader.class)
				.request(MediaType.APPLICATION_JSON).get(List.class);
		
		List<ArticleDto> articles = new ArrayList<ArticleDto>();
		for(Map<String,String> map : list) {
			ArticleDto dto = new ArticleDto();
			try {
				BeanUtils.copyProperties(dto, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			articles.add(dto);
		}
		
		return articles;
	}
*/
	
	public String getArticlesByPage(String pageIndex, String pageSize, String title) {
		return target.path("article/" + pageSize + "/" + pageIndex).register(ArticleDtoMessageBodyReader.class)
		.queryParam("title", title).request(MediaType.APPLICATION_JSON).get(String.class);
	}
}
