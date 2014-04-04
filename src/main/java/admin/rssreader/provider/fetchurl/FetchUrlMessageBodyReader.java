package admin.rssreader.provider.fetchurl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import admin.rssreader.entity.FetchUrl;
import admin.rssreader.util.JsonUtil;

public class FetchUrlMessageBodyReader implements MessageBodyReader<FetchUrl> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return type == FetchUrl.class;
	}

	@Override
	public FetchUrl readFrom(Class<FetchUrl> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		return (FetchUrl) JsonUtil.readFromJson(entityStream, FetchUrl.class);
	}

}
