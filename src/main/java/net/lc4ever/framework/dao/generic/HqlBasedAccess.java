/*
 * Framework: net.lc4ever.framework.dao.generic.HqlBasedAccess.java create by q-wang on Mar 31, 2013 10:51:02 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.generic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public interface HqlBasedAccess {

	public List<?> hql(String hql, Object... args);

	public <T> List<T> hql(Class<T> expectType, String hql, Object... args);

	public Object uniqueResultHql(String hql, Object... args);

	public <T> T uniqueResultHql(Class<T> expectType, String hql, Object... args);

	public <T> T topResultHql(Class<T> clazz, final String hql, final Object... args);

	public Object topResultHql(final String hql, final Object... args);

	public <T> List<T> topResultHql(Class<T> clazz, final int top, final String hql, final Object... args);

	public int bulkUpdateHql(String hql, Object... args);


	public Query namedQuery(String queryName);
	public SQLQuery namedSQLQuery(String queryName);

}
