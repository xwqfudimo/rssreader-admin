package admin.rssreader.entity;


public class FetchUrl {
	private String id;
	private String fetchUrl;
	private String sourceName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFetchUrl() {
		return fetchUrl;
	}
	public void setFetchUrl(String fetchUrl) {
		this.fetchUrl = fetchUrl;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
}
