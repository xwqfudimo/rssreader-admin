package admin.rssreader.entity;


public class ArticleDto {
	private String id;
	private String title;
	private String link;
	private String publishedDate;
	private String sourceName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", link=" + link
				+ ", publishedDate=" + publishedDate
				+ ", sourceName=" + sourceName + "]";
	}
}
