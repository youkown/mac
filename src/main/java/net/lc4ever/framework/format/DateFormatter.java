/*
 * SinoNetFramework: net.lc4ever.framework.format.DateFormatter.java create by q-wang on Jul 8, 2013 6:06:40 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * DateFormat常用格式封装.
 *
 * @revision $Revision$
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public class DateFormatter {

	private static final Map<String, DateFormat> FORMAT_REGISTER = new ConcurrentHashMap<String, DateFormat>();

	public static final String PATTERN_yyyyMMdd = "yyyyMMdd";
	public static final String PATTERN_HHmmss = "HHmmss";
	public static final String PATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String PATTERN_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

	private DateFormatter() {
	}

	public static String format(final String pattern, final Date date) {
		DateFormat formatter = FORMAT_REGISTER.get(pattern);
		if (formatter==null) {
			formatter = new SimpleDateFormat(pattern);
			FORMAT_REGISTER.put(pattern, formatter);
		}
		return formatter.format(date);
	}

	public static String format(final String format) {
		return format(format, new Date());
	}

	public static void main(final String[] args) {
		System.out.println("abcd"=="abcd");
	}
}
