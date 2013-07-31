/*
 * Framework: net.lc4ever.framework.dao.GenericDao.java create by q-wang on Mar 17, 2013 10:35:58 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import net.lc4ever.framework.domain.BaseEntity;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * 通用Data Access Object.
 * 
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public interface GenericDao {

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> list(Class<E> clazz);

	public <E extends BaseEntity<ID>, ID extends Serializable> E get(Class<E> clazz, ID id);

	public <E extends BaseEntity<ID>, ID extends Serializable> void delete(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> ID save(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> void update(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> void saveOrUpdate(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> long count(Class<E> clazz);

	//	public <T extends Serializable> Pager<T> page(Pager<T> pager);


	public List<?> hql(String hql, Object... args);

	public List<?> hql(long firstResult, long maxResults, String hql, Object... args);

	public <T> List<T> hql(Class<T> expectType, String hql, Object... args);

	public <T> List<T> hql(Class<T> expectType, long firstResult, long maxResults, String hql, Object... args);

	public List<?> sql(final String sql, final Object... args);

	public List<?> sql(long firstResult, long maxResults, String sql, Object... args);

	public <T> List<T> sql(Class<T> expectType, final String sql, final Object... args);

	public <T> List<T> sql(Class<T> expectType, long firstResult, long maxResults, String sql, Object... args);

	public Object uniqueResultHql(String hql, Object... args);

	public <T> T uniqueResultHql(Class<T> expectType, String hql, Object... args);

	public Object uniqueResultSql(final String sql, final Object... args);

	public <T> T uniqueResultSql(Class<T> expectType, final String sql, final Object... args);


	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperties(final Class<E> clazz, final String[] properties, final Object[] args);

	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperty(final Class<E> clazz, final String property, final Object arg);

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final String[] properties, final Object[] args, final Order... orders);

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final long firstResult, final long maxResults, final String[] properties, final Object[] args, final Order... orders);

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final String property, final Object arg, final Order... orders);

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final long firstResult, final long maxResults, final String property, final Object arg, final Order... orders);


	public List<?> criteria(DetachedCriteria criteria);

	public <T> T callback(HibernateCallback<T> callback);


	public <T> T topResultHql(Class<T> clazz, final String hql, final Object... args);

	public Object topResultHql(final String hql, final Object... args);

	public Object topResultSql(final String sql, final Object... args);

	public <T> T topResultSql(Class<T> clazz, final String sql, final Object... args);

	public <T> List<T> topResultHql(Class<T> clazz, final int top, final String hql, final Object... args);

	public <T> List<T> topResultSql(Class<T> clazz, final int top, final String sql, final Object... args);

	public <T> Iterator<T> iterate(Class<T> clazz, final String hql, final Object... args);

	public void closeIterator(Iterator<?> iterator);

	public int bulkUpdateHql(String hql, Object... args);

	public int bulkUpdateSql(final String sql, final Object... args);



	public List<?> sql(final ResultTransformer resultTransformer, final String sql, final Object... args);

	public List<?> sql(final ResultTransformer resultTransformer, final long firstResult, final long maxResults, final String sql, final Object... args);

	public <T> List<T> sql(final Class<T> expectType, final ResultTransformer resultTransformer, final String sql, final Object... args);

	public <T> List<T> sql(final Class<T> expectType, final ResultTransformer resultTransformer, final long firstResult, final long maxResults, final String sql, final Object... args);

	public Object uniqueResultSql(final ResultTransformer resultTransformer, final String sql, final Object... args);

	public <T> T uniqueResultSql(final Class<T> expectType, final ResultTransformer resultTransformer, final String sql, final Object... args);

	public Object topResultSql(final ResultTransformer resultTransformer, final String sql, final Object... args);

	public <T> T topResultSql(final Class<T> clazz, final ResultTransformer resultTransformer, final String sql, final Object... args);

	public <T> List<T> topResultSql(final Class<T> clazz, final ResultTransformer resultTransformer, final int top, final String sql, final Object... args);

}
