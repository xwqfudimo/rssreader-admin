package admin.rssreader.resource.impl;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import admin.rssreader.entity.Article;
import admin.rssreader.provider.article.ArticleDtoMessageBodyReader;
import admin.rssreader.provider.article.ArticleMessageBodyReader;
import admin.rssreader.provider.article.ArticleMessageBodyWriter;
import admin.rssreader.resource.ArticleResource;

@Service
public class ArticleResourceImpl extends BaseResourceImpl implements ArticleResource {
	
	@Override
	public Article getArticle(String id) {
		Article article = target.path("article/" + id).register(ArticleMessageBodyReader.class)
				.request(MediaType.APPLICATION_JSON).get(Article.class);
		
		return article;
	}
	
	@Override
	public void addArticle(Article article) {
		target.path("article").register(ArticleMessageBodyWriter.class)
				.request().post(Entity.entity(article, MediaType.APPLICATION_JSON)).close();
	}
	
	@Override
	public void updateArticle(Article article) {
		target.path("article").register(ArticleMessageBodyWriter.class)
				.request().put(Entity.entity(article, MediaType.APPLICATION_JSON)).close();
	}
	
	@Override
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
	
	@Override
	public String getArticlesByPage(String pageIndex, String pageSize, String title) {
		return target.path("article/" + pageSize + "/" + pageIndex).register(ArticleDtoMessageBodyReader.class)
		.queryParam("title", title).request(MediaType.APPLICATION_JSON).get(String.class);
	}
}
