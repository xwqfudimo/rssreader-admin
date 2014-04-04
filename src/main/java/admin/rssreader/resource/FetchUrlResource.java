package admin.rssreader.resource;

import admin.rssreader.entity.FetchUrl;

public interface FetchUrlResource {
	FetchUrl getFetchUrl(String id);

	FetchUrl addFetchUrl(FetchUrl fetchUrl);

	void updateFetchUrl(FetchUrl fetchUrl);

	void deleteFetchUrl(String id);

	String getFetchUrlsByPage(String pageIndex, String pageSize, String sourceName);
}
