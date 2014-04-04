package admin.rssreader.resource;

import admin.rssreader.entity.Article;

public interface ArticleResource {
	Article getArticle(String id);

	void addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(String id);

	String getArticlesByPage(String pageIndex, String pageSize, String title);
}