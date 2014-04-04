package admin.rssreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import admin.rssreader.resource.ArticleResource;
import admin.rssreader.resource.FetchUrlResource;

@Controller
public class BaseController {
	@Autowired
	protected ArticleResource articleResource;
	
	@Autowired
	protected FetchUrlResource fetchUrlResource;
}
