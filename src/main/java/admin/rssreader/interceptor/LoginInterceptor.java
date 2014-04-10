package admin.rssreader.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if(request.getSession().getAttribute("loginUser") == null || "".equals(request.getSession().getAttribute("loginUser").toString().trim())) {
			response.sendRedirect("login");
		}
		
		return super.preHandle(request, response, handler);
	}

}
