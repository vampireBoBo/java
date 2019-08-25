package com.lhb.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 用户登录成功后  successUrl跳转  ==== 这个过滤器没有生效 原因未明：好后期进行排查 LHB TODO
 * @author Administrator
 *
 */
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {
	private final Logger log = LogManager.getLogger();
	
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		log.error("进入表单过滤");
		return super.onLoginSuccess(token, subject, request, response);
	}
	
	/**
	 * 重写父类的issueSuccessRedirect方法  否则  该方法会根据request
	 */
	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		log.error("进入表单过滤");
		issueSuccessRedirect(request, response);
	}
}
