/*
 * Framework: net.lc4ever.framework.context.ContextLoaderListener.java create by q-wang on May 22, 2013 11:18:20 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@WebListener
public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @see org.springframework.web.context.ContextLoaderListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		logger.info("");
		ContextHolder.getInstance().setServletContext(event.getServletContext());
		ContextHolder.getInstance().setApplicationContext(getCurrentWebApplicationContext());
	}

	/**
	 * @see org.springframework.web.context.ContextLoaderListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

}
