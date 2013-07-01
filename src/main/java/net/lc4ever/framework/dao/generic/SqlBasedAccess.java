/*
 * Framework: net.lc4ever.framework.dao.generic.SqlBasedAccess.java create by q-wang on Mar 31, 2013 10:52:57 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.generic;

import java.util.List;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public interface SqlBasedAccess {

	public List<?> sql(final String sql, final Object... args);

	public <T> List<T> sql(Class<T> expectType, final String sql, final Object... args);

	public Object uniqueResultSql(final String sql, final Object... args);

	public <T> T uniqueResultSql(Class<T> expectType, final String sql, final Object... args);

	public Object topResultSql(final String sql, final Object... args);

	public <T> T topResultSql(Class<T> clazz, final String sql, final Object... args);

	public <T> List<T> topResultSql(Class<T> clazz, final int top, final String sql, final Object... args);

	public int bulkUpdateSql(final String sql, final Object... args);
}
