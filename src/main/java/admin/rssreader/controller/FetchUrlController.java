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

import admin.rssreader.entity.FetchUrl;

/**
 * 来源管理 
 */
@Controller
public class FetchUrlController extends BaseController {
	private Logger log = Logger.getLogger(FetchUrlController.class);
	/**
	 * 分页查询来源列表
	 * @param response
	 */
	@RequestMapping("/fetchurls")
	public void getFetchUrls(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageIndex = request.getParameter("page").toString();
		String pageSize = request.getParameter("rows").toString();
		
		String srcName = "";
		if(request.getParameter("srcName") != null) {
			srcName = request.getParameter("srcName");
			log.debug("搜索名为\"" + srcName + "\"的来源");
		}
		
		String FetchUrls = this.fetchUrlResource.getFetchUrlsByPage(pageIndex, pageSize, srcName);
		
		log.debug("来源管理");
		
		response.setCharacterEncoding("utf-8");
		IOUtils.write(FetchUrls, response.getWriter());
	}
	
	/**
	 * 查看来源
	 * @param id 来源编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/fetchurl/{id}")
	public String queryFetchUrl(@PathVariable("id") String id, Model model) {
		getFetchUrlById(id, model);
		log.debug("查看来源 " + id);
		return "getFetchUrl";
	}
	
	/**
	 * 编辑来源
	 * @param id 文章来源
	 * @param model
	 * @return
	 */
	@RequestMapping("/fetchurl/{id}/edit")
	public String editFetchUrl(@PathVariable("id") String id, Model model) {
		getFetchUrlById(id, model);
		log.debug("编辑来源 " + id);
		return "editFetchUrl";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fetchurl/{id}/edit", method=RequestMethod.POST)
	public String editFetchUrlSubmit(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
		FetchUrl fetchUrl = new FetchUrl();
		
		Map<String,Object> paramMap = request.getParameterMap();
		for(Map.Entry<String, Object> entry : paramMap.entrySet()) {
			BeanUtils.copyProperty(fetchUrl, entry.getKey(), request.getParameter(entry.getKey()).toString());
		}
		
		this.fetchUrlResource.updateFetchUrl(fetchUrl);
		
		log.debug("来源编辑提交");
		
		return "redirect:/fetchurl/" + id + "/edit";
	}
	
	@RequestMapping("/fetchurl/{id}/remove")
	@ResponseBody
	public Map<String, Object> removeFetchUrl(@PathVariable("id") String id, HttpServletResponse response) {
		this.fetchUrlResource.deleteFetchUrl(id);
	
		Map<String, Object> result = new HashMap<String, Object>(1);
		result.put("success", true);
		
		log.debug("删除来源 " + id);
		
		return result;
	}
	
	@RequestMapping(value="/fetchurl/add", method=RequestMethod.GET)
	public String addFetchUrl() {
		log.debug("新增来源");
		return "addFetchUrl";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fetchurl/add", method=RequestMethod.POST)
	public String addFetchUrlSubmit(HttpServletRequest request) throws Exception {
		FetchUrl fetchUrl = new FetchUrl();
		
		Map<String,Object> paramMap = request.getParameterMap();
		for(Map.Entry<String, Object> entry : paramMap.entrySet()) {
			BeanUtils.copyProperty(fetchUrl, entry.getKey(), request.getParameter(entry.getKey()).toString());
		}
		
		fetchUrl = this.fetchUrlResource.addFetchUrl(fetchUrl);
		
		log.debug("来源新增提交 " + fetchUrl.getId());
		
		return "redirect:/fetchurl/" + fetchUrl.getId();
	}
	
	private void getFetchUrlById(String id, Model model) {
		FetchUrl fetchUrl = this.fetchUrlResource.getFetchUrl(id);
		model.addAttribute("fetchUrl", fetchUrl);
	}
}
