package admin.rssreader.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.rssreader.resource.AuthResource;
import admin.rssreader.resource.impl.BaseResourceImpl;
import admin.rssreader.util.EncryptUtil;

@Controller
public class LoginController extends BaseController {
	@Autowired
	private AuthResource authResource;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		password = EncryptUtil.md5(username, password);
		
		boolean result = this.authResource.auth(username, password);
		if(result) {
			BaseResourceImpl.setAuthInfo(username, password);
			session.setAttribute("loginUser", username);
			return "index";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(String usename, HttpSession session) {
		if(session.getAttribute("loginUser") != null && !"".equals(session.getAttribute("loginUser"))) {
			session.setAttribute("loginUser", null);
		}
		return "redirect:/login";
	}
}

