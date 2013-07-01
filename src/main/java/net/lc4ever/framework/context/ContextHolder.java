/*
 * Framework: net.lc4ever.framework.context.ContextHolder.java create by q-wang on May 22, 2013 2:41:38 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.context;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public final class ContextHolder {

	private static final ContextHolder instance = new ContextHolder();

	private ContextHolder() {}

	private ServletContext servletContext;

	private ApplicationContext applicationContext;

	protected static ContextHolder getInstance() {
		return instance;
	}

	/**
	 * @param servletContext the servletContext to set
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static ServletContext getServletContext() {
		return getInstance().servletContext;
	}
	public static ApplicationContext getApplicationContext() {
		return getInstance().applicationContext;
	}

}
