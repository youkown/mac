/*
 * SinoNetFramework: net.lc4ever.framework.exception.NoneStackTraceException.java create by q-wang on Jul 5, 2013 9:35:26 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.exception;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public class NoneStackTraceException extends Exception implements NoneStackTrace {

	/**
	 * @see java.lang.Throwable#fillInStackTrace()
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}


}
