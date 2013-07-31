/*
 * Framework: net.lc4ever.framework.service.impl.GenericCrudServiceImpl.java create by q-wang on May 10, 2013 4:51:36 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.service.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import net.lc4ever.framework.dao.GenericDao;
import net.lc4ever.framework.domain.BaseEntity;
import net.lc4ever.framework.service.GenericCrudService;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.HibernateCallback;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public class GenericCrudServiceImpl implements GenericCrudService {

	private GenericDao genericDao;

	/**
	 * @param genericDao the genericDao to set
	 */
	public void setGenericDao(final GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#list(java.lang.Class)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> list(final Class<E> clazz) {
		return genericDao.list(clazz);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#get(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> E get(final Class<E> clazz, final ID id) {
		return genericDao.get(clazz, id);
	}

	/**
	 * @param entity
	 * @see net.lc4ever.framework.dao.GenericDao#delete(net.lc4ever.framework.domain.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> void delete(final E entity) {
		genericDao.delete(entity);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#save(net.lc4ever.framework.domain.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> ID save(final E entity) {
		return genericDao.save(entity);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#update(net.lc4ever.framework.domain.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> void update(final E entity) {
		genericDao.update(entity);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#saveOrUpdate(net.lc4ever.framework.domain.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> void saveOrUpdate(final E entity) {
		genericDao.saveOrUpdate(entity);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#count(java.lang.Class)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> long count(final Class<E> clazz) {
		return genericDao.count(clazz);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#hql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> hql(final String hql, final Object... args) {
		return genericDao.hql(hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#hql(long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> hql(final long firstResult, final long maxResults, final String hql, final Object... args) {
		return genericDao.hql(firstResult, maxResults, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#hql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> hql(final Class<T> expectType, final String hql, final Object... args) {
		return genericDao.hql(expectType, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#hql(java.lang.Class, long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> hql(final Class<T> expectType, final long firstResult, final long maxResults, final String hql, final Object... args) {
		return genericDao.hql(expectType, firstResult, maxResults, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final String sql, final Object... args) {
		return genericDao.sql(sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final long firstResult, final long maxResults, final String sql, final Object... args) {
		return genericDao.sql(firstResult, maxResults, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> sql(final Class<T> expectType, final String sql, final Object... args) {
		return genericDao.sql(expectType, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(java.lang.Class, long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> sql(final Class<T> expectType, final long firstResult, final long maxResults, final String sql, final Object... args) {
		return genericDao.sql(expectType, firstResult, maxResults, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultHql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object uniqueResultHql(final String hql, final Object... args) {
		return genericDao.uniqueResultHql(hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultHql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> T uniqueResultHql(final Class<T> expectType, final String hql, final Object... args) {
		return genericDao.uniqueResultHql(expectType, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object uniqueResultSql(final String sql, final Object... args) {
		return genericDao.uniqueResultSql(sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultSql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> T uniqueResultSql(final Class<T> expectType, final String sql, final Object... args) {
		return genericDao.uniqueResultSql(expectType, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultByProperties(java.lang.Class, java.lang.String[], java.lang.Object[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperties(final Class<E> clazz, final String[] properties, final Object[] args) {
		return genericDao.uniqueResultByProperties(clazz, properties, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultByProperty(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperty(final Class<E> clazz, final String property, final Object arg) {
		return genericDao.uniqueResultByProperty(clazz, property, arg);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#queryByProperties(java.lang.Class, java.lang.String[], java.lang.Object[], org.hibernate.criterion.Order[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final String[] properties, final Object[] args, final Order... orders) {
		return genericDao.queryByProperties(clazz, properties, args, orders);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#queryByProperties(java.lang.Class, long, long, java.lang.String[], java.lang.Object[], org.hibernate.criterion.Order[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final long firstResult, final long maxResults, final String[] properties, final Object[] args, final Order... orders) {
		return genericDao.queryByProperties(clazz, firstResult, maxResults, properties, args, orders);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#queryByProperty(java.lang.Class, java.lang.String, java.lang.Object, org.hibernate.criterion.Order[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final String property, final Object arg, final Order... orders) {
		return genericDao.queryByProperty(clazz, property, arg, orders);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#queryByProperty(java.lang.Class, long, long, java.lang.String, java.lang.Object, org.hibernate.criterion.Order[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final long firstResult, final long maxResults, final String property, final Object arg, final Order... orders) {
		return genericDao.queryByProperty(clazz, firstResult, maxResults, property, arg, orders);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#criteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public List<?> criteria(final DetachedCriteria criteria) {
		return genericDao.criteria(criteria);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#callback(org.springframework.orm.hibernate3.HibernateCallback)
	 */
	@Override
	public <T> T callback(final HibernateCallback<T> callback) {
		return genericDao.callback(callback);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultHql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> T topResultHql(final Class<T> clazz, final String hql, final Object... args) {
		return genericDao.topResultHql(clazz, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultHql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object topResultHql(final String hql, final Object... args) {
		return genericDao.topResultHql(hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object topResultSql(final String sql, final Object... args) {
		return genericDao.topResultSql(sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultSql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> T topResultSql(final Class<T> clazz, final String sql, final Object... args) {
		return genericDao.topResultSql(clazz, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultHql(java.lang.Class, int, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> topResultHql(final Class<T> clazz, final int top, final String hql, final Object... args) {
		return genericDao.topResultHql(clazz, top, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultSql(java.lang.Class, int, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> topResultSql(final Class<T> clazz, final int top, final String sql, final Object... args) {
		return genericDao.topResultSql(clazz, top, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#iterate(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> Iterator<T> iterate(final Class<T> clazz, final String hql, final Object... args) {
		return genericDao.iterate(clazz, hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#closeIterator(java.util.Iterator)
	 */
	@Override
	public void closeIterator(final Iterator<?> iterator) {
		genericDao.closeIterator(iterator);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#bulkUpdateHql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int bulkUpdateHql(final String hql, final Object... args) {
		return genericDao.bulkUpdateHql(hql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#bulkUpdateSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int bulkUpdateSql(final String sql, final Object... args) {
		return genericDao.bulkUpdateSql(sql, args);
	}


	// unimplements methods

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#sql(org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return genericDao.sql(resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#sql(org.hibernate.transform.ResultTransformer, long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final ResultTransformer resultTransformer, final long firstResult, final long maxResults, final String sql, final Object... args) {
		return genericDao.sql(resultTransformer, firstResult, maxResults, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#sql(java.lang.Class, org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> sql(final Class<T> expectType, final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return genericDao.sql(expectType, resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#sql(java.lang.Class, org.hibernate.transform.ResultTransformer, long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> sql(final Class<T> expectType, final ResultTransformer resultTransformer, final long firstResult, final long maxResults, final String sql, final Object... args) {
		return genericDao.sql(expectType, resultTransformer, firstResult, maxResults, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#uniqueResultSql(org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object uniqueResultSql(final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return genericDao.uniqueResultSql(resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#uniqueResultSql(java.lang.Class, org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> T uniqueResultSql(final Class<T> expectType, final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return genericDao.uniqueResultSql(expectType, resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#topResultSql(org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object topResultSql(final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return genericDao.topResultSql(resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#topResultSql(java.lang.Class, org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> T topResultSql(final Class<T> clazz, final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return genericDao.topResultSql(clazz, resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.service.GenericCrudService#topResultSql(java.lang.Class, org.hibernate.transform.ResultTransformer, int, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> topResultSql(final Class<T> clazz, final ResultTransformer resultTransformer, final int top, final String sql, final Object... args) {
		return genericDao.topResultSql(clazz, resultTransformer, top, sql, args);
	}


}
