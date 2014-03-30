package admin.rssreader.provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import admin.rssreader.util.JsonUtil;

@SuppressWarnings("rawtypes")
public class ArticleDtoMessageBodyReader implements
		MessageBodyReader<List> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return List.class.isAssignableFrom(type);
	}

	@Override
	public List readFrom(Class<List> type,
			Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		return (List)JsonUtil.readFromJson(entityStream, List.class);
	}

}
