/*
 * SinoNetFramework: net.lc4ever.framework.exception.NoneStackTraceRuntimeException.java create by q-wang on Jul 5, 2013 9:35:45 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public class NoneStackTraceRuntimeException extends RuntimeException implements NoneStackTrace {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @see java.lang.Throwable#fillInStackTrace()
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	/**
	 * @see java.lang.Throwable#printStackTrace()
	 */
	@Override
	public void printStackTrace() {
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		printStackTrace(printWriter);
		logger.error(writer.toString());
	}

	public NoneStackTraceRuntimeException() {
		super();
	}

	public NoneStackTraceRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NoneStackTraceRuntimeException(final String message) {
		super(message);
	}

	public NoneStackTraceRuntimeException(final Throwable cause) {
		super(cause);
	}

}
