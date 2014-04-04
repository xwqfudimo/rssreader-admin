package admin.rssreader.resource.impl;

import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class BaseResourceImpl {
	private static String serverAddr;
	protected static WebTarget target;
	
	static {
		Properties prop = new Properties();
		try {
			prop.load(BaseResourceImpl.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		serverAddr = prop.getProperty("server.address");
		
		target = ClientBuilder.newClient().target(serverAddr);
	}
}
