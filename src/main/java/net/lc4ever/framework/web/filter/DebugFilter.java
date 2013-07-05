/*
 * SinoNetFramework: net.lc4ever.framework.web.filter.DebugFilter.java create by q-wang on Jul 5, 2013 4:10:08 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@WebFilter(urlPatterns="/*",dispatcherTypes={DispatcherType.ERROR,DispatcherType.FORWARD,DispatcherType.INCLUDE,DispatcherType.REQUEST,DispatcherType.ASYNC})
public class DebugFilter implements Filter {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected final boolean isDebugEnabled = logger.isDebugEnabled();

	protected ServletContext servletContext;

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		servletContext = null;
	}

	/**
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		if (isDebugEnabled) {
			HttpServletRequest req = (HttpServletRequest)request;
			logger.debug("RequestURL:{}\t{}",req.getDispatcherType(),req.getRequestURL());
		}
	}

	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig config) throws ServletException {
		servletContext = config.getServletContext();
		logger.info("Debugging filter enabled:{}",isDebugEnabled);
	}

}
