/*
 * SinoNetFramework: net.lc4ever.framework.web.listener.HttpServletEventDispatcher.java create by q-wang on Aug 29, 2013 1:38:06 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.web.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public abstract class HttpServletEventDispatcher extends ServletEventDispatcher implements HttpSessionActivationListener, HttpSessionAttributeListener, HttpSessionBindingListener, HttpSessionListener {

	/**
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(final HttpSessionEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(final HttpSessionEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionBindingListener#valueBound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void valueBound(final HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionBindingListener#valueUnbound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void valueUnbound(final HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(final HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeRemoved(final HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(final HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionActivationListener#sessionWillPassivate(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionWillPassivate(final HttpSessionEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.http.HttpSessionActivationListener#sessionDidActivate(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDidActivate(final HttpSessionEvent event) {
		// TODO Auto-generated method stub

	}
}
