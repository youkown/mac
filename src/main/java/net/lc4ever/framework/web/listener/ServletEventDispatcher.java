/*
 * SinoNetFramework: net.lc4ever.framework.web.listener.ServletEventDispatcher.java create by q-wang on Aug 29, 2013 1:35:01 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.web.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public abstract class ServletEventDispatcher implements AsyncListener,ServletContextAttributeListener,  ServletContextListener, ServletRequestAttributeListener, ServletRequestListener {

	/**
	 * @see javax.servlet.ServletRequestListener#requestDestroyed(javax.servlet.ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(final ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletRequestListener#requestInitialized(javax.servlet.ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(final ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletRequestAttributeListener#attributeAdded(javax.servlet.ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeAdded(final ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletRequestAttributeListener#attributeRemoved(javax.servlet.ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeRemoved(final ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletRequestAttributeListener#attributeReplaced(javax.servlet.ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeReplaced(final ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(final ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletContextAttributeListener#attributeAdded(javax.servlet.ServletContextAttributeEvent)
	 */
	@Override
	public void attributeAdded(final ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletContextAttributeListener#attributeRemoved(javax.servlet.ServletContextAttributeEvent)
	 */
	@Override
	public void attributeRemoved(final ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletContextAttributeListener#attributeReplaced(javax.servlet.ServletContextAttributeEvent)
	 */
	@Override
	public void attributeReplaced(final ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onComplete(final AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.AsyncListener#onTimeout(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onTimeout(final AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onError(final AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.AsyncListener#onStartAsync(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onStartAsync(final AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub

	}



}
