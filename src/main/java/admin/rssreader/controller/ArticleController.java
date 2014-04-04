package admin.rssreader.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.rssreader.entity.Article;

/**
 * 文章管理 
 */
@Controller
public class ArticleController extends BaseController {
	private Logger log = Logger.getLogger(ArticleController.class);
	
	/**
	 * 分页查询文章列表
	 * @param response
	 */
	@RequestMapping("/articles")
	public void getAritcles(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageIndex = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		
		String title = "";
		if(request.getParameter("atitle") != null) {
			title = request.getParameter("atitle").toString();
			log.debug("搜索标题为" + title + "的文章");
		}
		
		String articles = this.articleResource.getArticlesByPage(pageIndex, pageSize, title);
		
		log.debug("文章管理");
		
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
		log.debug("查看文章 " + id);
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
		log.debug("编辑文章 " + id);
		return "editArticle";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/article/{id}/edit", method=RequestMethod.POST)
	public String editArticleSubmit(HttpServletRequest request) throws Exception {
		Article article = new Article();
		
		Map<String, Object> paramsMap = request.getParameterMap();
		for(Map.Entry<String, Object> entry : paramsMap.entrySet()) {
			BeanUtils.copyProperty(article, entry.getKey(), request.getParameter(entry.getKey()));
		}
		
		this.articleResource.updateArticle(article);
		
		log.debug("文章编辑提交 " + article.getId());
		
//		Map<String, Object> result = new HashMap<String, Object>(1);
//		result.put("success", true);
		
		//TODO springmvc3.2 jquery ajax post提交无法成功回到jquery success()函数

		return "redirect:/article/" + article.getId() + "/edit";
	}
	
	@RequestMapping("/article/{id}/remove")
	@ResponseBody
	public Map<String, Object> removeArticle(@PathVariable("id") String id, HttpServletResponse response) {
		this.articleResource.deleteArticle(id);
		
		Map<String, Object> result = new HashMap<String, Object>(1);
		result.put("success", true);
		
		log.debug("删除文章 " + id);
		
		return result;
	}
	
	private void getArticleById(String id, Model model) {
		Article article = this.articleResource.getArticle(id);
		model.addAttribute("article", article);
	}
}
