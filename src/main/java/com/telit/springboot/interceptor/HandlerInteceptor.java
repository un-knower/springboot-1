package com.telit.springboot.interceptor;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.NameUtil;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.EduPosition;
import com.telit.springboot.web.model.TelitUser;
import com.telit.springboot.web.service.EduPositionService;
import com.telit.springboot.web.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class HandlerInteceptor implements HandlerInterceptor {

	@Resource(name="eduPositionServiceImpl")
	private EduPositionService eduPositionService;
	@Resource(name="userServiceImpl")
	private UserService userService;

	private static org.slf4j.Logger  logger = LoggerFactory.getLogger(HandlerInteceptor.class);

	public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
		logger.info("********Start interceptor********");
//    	String userId =request.getParameter("userId");
//		String userPassword =request.getParameter("userPassword");
		String userId ="137";
		String userPassword ="000000";
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		HttpSession session = request.getSession();
		TelitUser userModel = (TelitUser)session.getAttribute(NameUtil.CURRENT_USER);
		if(userModel==null){
			if(StringUtil.isNotEmpty(userId)){
				if(null==userService){//解决拦截器注入service失败
					BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
					userService = (UserService) factory.getBean("userServiceImpl");
				}
				userModel=userService.findOne(Long.parseLong(userId));
				String md5Password=md5.encodePassword(userPassword , userModel.getSalt());
				if(null != userModel && (userPassword.equals(userModel.getPassword()) || md5Password.equals(userModel.getPassword()) )){
					session.setAttribute(NameUtil.CURRENT_USER,userModel);
					List<Filter> filters = new ArrayList<Filter>();
					filters.add(Filter.eq("positionType","3"));
					filters.add(Filter.eq("positionUser",userId));
					if(null==eduPositionService){
						BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
						eduPositionService = (EduPositionService) factory.getBean("eduPositionServiceImpl");
					}
					List<EduPosition> list = eduPositionService.findList(filters);
					if(null !=list && list.size() >0){
						session.setAttribute(NameUtil.CLASS_ID,String.valueOf(list.get(0).getRelationId()));
					}
					session.setAttribute(NameUtil.SCHOOL_ID,userModel.getSchoolId());
					return true;
				}else {
					response.sendRedirect("/noAuth");
					return false;
				}
			}else{
				response.sendRedirect("/noAuth");
				return false;
			}
		}
		return true;
	}
}
