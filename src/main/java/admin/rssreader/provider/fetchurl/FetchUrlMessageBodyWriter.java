package admin.rssreader.provider.fetchurl;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import admin.rssreader.entity.FetchUrl;
import admin.rssreader.util.JsonUtil;

public class FetchUrlMessageBodyWriter implements MessageBodyWriter<FetchUrl> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return type == FetchUrl.class;
	}

	@Override
	public long getSize(FetchUrl t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(FetchUrl t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		
		JsonUtil.writeToJson(entityStream, t);
	}

}
