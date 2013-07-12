/*
 * SinoNetFramework: net.lc4ever.framework.web.listener.SessionCounterListener.java create by q-wang on Jul 3, 2013 10:23:48 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.web.listener;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@WebListener
public class SessionCounterListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {

	public static final String KEY_COUNTER = "__com.nxy.nms.mb.listener.SessionCounterListener.Counter";

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected final boolean isDebugEnabled = logger.isDebugEnabled();

	protected final Counter counter = new Counter();

	private ServletContext servletContext;

	/**
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(final HttpSessionEvent event) {
		synchronized (counter) {
			counter.alive++;
		}
	}

	/**
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(final HttpSessionEvent event) {
		synchronized (counter) {
			counter.alive--;
			//			if (event.getSession().getAttribute(SecurityContext.SESSION_KEY) != null) {
			//				counter.online--;
			//			}
		}
	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(final HttpSessionBindingEvent event) {
		//		if (SecurityContext.SESSION_KEY.equals(event.getName())) {
		//			synchronized (counter) {
		//				counter.online++;
		//			}
		//		}
	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeRemoved(final HttpSessionBindingEvent event) {
	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(final HttpSessionBindingEvent event) {

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent event) {

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(final ServletContextEvent event) {
		servletContext = event.getServletContext();
		servletContext.setAttribute(KEY_COUNTER, counter);
	}

	public class Counter implements Serializable {
		public long alive;
		public long online;
	}

}
