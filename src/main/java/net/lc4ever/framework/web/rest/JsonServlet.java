/*
 * Framework: net.lc4ever.framework.web.rest.JsonServlet.java create by q-wang on May 20, 2013 12:01:51 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.web.rest;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lc4ever.framework.service.GenericCrudService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
// @WebServlet(urlPatterns={"/rest/json"})
public class JsonServlet extends HttpServlet {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected String contextPath;

	protected GenericCrudService crudService;

	/**
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		contextPath = config.getServletContext().getContextPath();
		logger.info("/rest/json servlet mapping starting..., contextPath:{}", contextPath);
	}

	/**
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO config servlet url-pattern
		String uri = request.getRequestURI().substring(contextPath.length() + 11);
		String[] uris = uri.split("/");
		logger.debug("uris:{}", new Object[] { uris });

//		switch (uris[0]) {
//			case "data":
//				switch (uris[1]) {
//					case "table":
//
//					case "entity":
//					case "alias":
//					case "xtype":
//					case "dto":
//					case "ns":
//					default: // TODO not support
//				}
//				break;
//			case "query":
//				switch (uris[1]) {
//
//				}
//				break;
//			default: // TODO not support
//		}
	}
}
