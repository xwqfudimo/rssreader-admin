package admin.rssreader.resource.impl;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import admin.rssreader.entity.FetchUrl;
import admin.rssreader.provider.fetchurl.FetchUrlMessageBodyReader;
import admin.rssreader.provider.fetchurl.FetchUrlMessageBodyWriter;
import admin.rssreader.resource.FetchUrlResource;

@Service
public class FetchUrLResourceImpl extends BaseResourceImpl implements
		FetchUrlResource {

	@Override
	public FetchUrl getFetchUrl(String id) {
		FetchUrl fu = target.path("fetchurl/" + id).register(FetchUrlMessageBodyReader.class)
				.request(MediaType.APPLICATION_JSON).get(FetchUrl.class);
		
		return fu;
	}

	@Override
	public FetchUrl addFetchUrl(FetchUrl fetchUrl) {
		Response response = target.path("fetchurl").register(FetchUrlMessageBodyWriter.class).register(FetchUrlMessageBodyReader.class)
		.request().post(Entity.entity(fetchUrl, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 201) {
			return response.readEntity(FetchUrl.class);
		}
		return null;
	}

	@Override
	public void updateFetchUrl(FetchUrl fetchUrl) {
		target.path("fetchurl").register(FetchUrlMessageBodyWriter.class)
		.request().put(Entity.entity(fetchUrl, MediaType.APPLICATION_JSON)).close();
	}

	@Override
	public void deleteFetchUrl(String id) {
		target.path("fetchurl/" + id).request().delete().close();;
	}

	@Override
	public String getFetchUrlsByPage(String pageIndex, String pageSize,
			String sourceName) {
		return target.path("fetchurl/" + pageSize + "/" + pageIndex).register(FetchUrlMessageBodyReader.class)
				.queryParam("sourceName", sourceName).request(MediaType.APPLICATION_JSON).get(String.class);
	}

}
