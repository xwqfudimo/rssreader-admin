package admin.rssreader.resource.impl;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import admin.rssreader.resource.AuthResource;

@Service
public class AuthResourceImpl extends BaseResourceImpl implements AuthResource {

	@Override
	public boolean auth(String username, String password) {
		return target.path("auth/" + username + "/" + password).request(MediaType.TEXT_PLAIN).get(boolean.class);
	}

}
