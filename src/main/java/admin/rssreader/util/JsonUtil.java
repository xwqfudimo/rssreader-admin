package admin.rssreader.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static void writeToJson(OutputStream out, Object obj) {
		try {
			objectMapper.writeValue(out, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToJson(Writer out, Object obj) {
		try {
			objectMapper.writeValue(out, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object readFromJson(InputStream input, Class<?> clz) {
		try {
			return objectMapper.readValue(input, clz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
