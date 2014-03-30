package admin.rssreader.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.rssreader.entity.Article;

/**
 * 文章管理 
 */
@Controller
public class ArticleController extends BaseController {

	/**
	 * 分页查询文章列表
	 * @param response
	 */
	@RequestMapping("/articles")
	public void getAritcles(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageIndex = request.getParameter("page").toString();
		String pageSize = request.getParameter("rows").toString();
		
		String title = "";
		if(request.getParameter("atitle") != null) {
			title = request.getParameter("atitle").toString();
		}
		
		String articles = this.articleResource.getArticlesByPage(pageIndex, pageSize, title);
		
		response.setCharacterEncoding("utf-8");
		IOUtils.write(articles, response.getWriter());
	}
	
	/**
	 * 查看文章
	 * @param id 文章编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/{id}")
	public String queryArticle(@PathVariable("id") String id, Model model) {
		getArticleById(id, model);
		return "getArticle";
	}
	
	/**
	 * 编辑文章
	 * @param id 文章编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/{id}/edit")
	public String editArticle(@PathVariable("id") String id, Model model) {
		getArticleById(id, model);
		return "editArticle";
	}
	
	@RequestMapping(value="/article/{id}/edit", method=RequestMethod.POST)
	public String editArticleSubmit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
		Article article = new Article();
		
		Map<String,Object> paramMap = request.getParameterMap();
		for(Map.Entry<String, Object> entry : paramMap.entrySet()) {
			BeanUtils.copyProperty(article, entry.getKey(), request.getParameter(entry.getKey()).toString());
		}
		
		this.articleResource.updateArticle(article);
		
		return "redirect:/article/" + id + "/edit";
	}
	
	@RequestMapping("article/{id}/remove")
	public String removeArticle(@PathVariable("id") String id, HttpServletResponse response) {
		this.articleResource.deleteArticle(id);
		
		return "redirect:/articles";
	}
	
	private void getArticleById(String id, Model model) {
		Article article = this.articleResource.getArticle(id);
		model.addAttribute("article", article);
	}
}
