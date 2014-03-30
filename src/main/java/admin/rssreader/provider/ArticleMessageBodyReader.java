package admin.rssreader.provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import admin.rssreader.entity.Article;
import admin.rssreader.util.JsonUtil;

public class ArticleMessageBodyReader implements MessageBodyReader<Article> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return type == Article.class;
	}

	@Override
	public Article readFrom(Class<Article> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		Article article = (Article)JsonUtil.readFromJson(entityStream, Article.class);
		
		return article;
	}

}
