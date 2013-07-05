/*
 * SinoNetFramework: net.lc4ever.framework.exception.NoneStackTraceRuntimeException.java create by q-wang on Jul 5, 2013 9:35:45 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.exception;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public class NoneStackTraceRuntimeException extends RuntimeException implements NoneStackTrace {

	/**
	 * @see java.lang.Throwable#fillInStackTrace()
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}


}