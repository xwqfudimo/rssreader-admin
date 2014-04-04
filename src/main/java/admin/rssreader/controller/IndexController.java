package admin.rssreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/articleManage")
	public String articleManage() {
		return "articleManage";
	}
	
	@RequestMapping("/sourceManage")
	public String sourceManage() {
		return "sourceManage";
	}
}
