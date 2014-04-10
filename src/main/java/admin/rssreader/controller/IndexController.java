package admin.rssreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
	
	@RequestMapping({"/", "/index"})
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
	
	@RequestMapping("/404")
	public String error404() {
		return "404";
	}
}
