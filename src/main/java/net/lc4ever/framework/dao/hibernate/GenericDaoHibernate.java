/*
 * Framework: net.lc4ever.framework.dao.GenericDaoHibernate.java create by q-wang on May 2, 2013 11:02:14 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import net.lc4ever.framework.dao.GenericDao;
import net.lc4ever.framework.domain.BaseEntity;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;


/**
 *
 * @revision $Revision:$
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public class GenericDaoHibernate implements GenericDao {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#list(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> list(final Class<E> clazz) {
		logger.trace("Listing All Entries for Class:{}.", clazz.getName());
		return getSession().createCriteria(clazz).list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#get(java.lang.Class, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> E get(final Class<E> clazz, final ID id) {
		logger.trace("Getting Entry for Class:{}, using Id:{}.", clazz.getName(), id);
		return (E) getSession().get(clazz, id);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#delete(sinonet.framework.bean.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> void delete(final E entity) {
		logger.trace("Deleting Entry for Class:{}, using Id:{}.", entity.getClass().getName(), entity.getId());
		getSession().delete(entity);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#save(sinonet.framework.bean.BaseEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> ID save(final E entity) {
		logger.trace("Saving Entry for Class:{}, Id:{}.", entity.getClass().getName(), entity.getId());
		return (ID) getSession().save(entity);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#update(sinonet.framework.bean.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> void update(final E entity) {
		logger.trace("Updating Entry for Class:{}, Id:{}.", entity.getClass().getName(), entity.getId());
		getSession().update(entity);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#saveOrUpdate(sinonet.framework.bean.BaseEntity)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> void saveOrUpdate(final E entity) {
		logger.trace("Saving Or Updating for Class:{}, Id:{}.", entity.getClass().getName(), entity.getId());
		getSession().saveOrUpdate(entity);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#count(java.lang.Class)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> long count(final Class<E> clazz) {
		logger.trace("Counting Entries for Class:{}.", clazz.getName());
		return ((Number) getSession().createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult()).longValue();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#page(sinonet.framework.dao.Pager)
	 */
	/*
	@Override
	public <T extends Serializable> Pager<T> page(final Pager<T> pager) {
		logger.trace("Paging: pager={}", pager);
		final QueryBuilder queryBuilder = pager.getQuery();
		if (HqlQueryBuilder.class.isAssignableFrom(queryBuilder.getClass())) {
			HqlQuery query = ((HqlQueryBuilder) queryBuilder).buildHqlQuery();
			String hql = query.getHql();
			String hqlCount = query.getHqlCount();
			Object[] parameters = query.getQueryParameter();

			long count = uniqueResultHql(Number.class, hqlCount, pager).longValue();

			Query hibernateQuery = getSession().createQuery(hql);
			hibernateQuery.setFirstResult(pager.getFirstResult());
			hibernateQuery.setMaxResults(pager.getMaxResults());
			for (int i = 0; i < parameters.length; i++) {
				hibernateQuery.setParameter(i, parameters[i]);
			}
			@SuppressWarnings("unchecked")
			List<T> results = hibernateQuery.list();

			pager.setResults(results);
			pager.setCount(count);
			return pager;
		} else if (CriteriaQueryBuilder.class.isAssignableFrom(queryBuilder.getClass())) {
			return getSession().execute(new HibernateCallback<Pager<T>>() {
				@Override
				public Pager<T> doInHibernate(Session session) throws HibernateException, SQLException {
					Criteria criteria = ((CriteriaQueryBuilder) queryBuilder).buildCriteria(session);
					Criteria criteria2 = ((CriteriaQueryBuilder) queryBuilder).buildCriteria(session);
					criteria.setFirstResult(pager.getFirstResult());
					criteria.setMaxResults(pager.getMaxResults());
					@SuppressWarnings("unchecked")
					List<T> results = criteria.list();

					criteria2.setProjection(Projections.rowCount());
					long count = (Long) criteria2.uniqueResult();

					pager.setResults(results);
					pager.setCount(count);
					return pager;
				}
			});
		} else if (SqlQueryBuilder.class.isAssignableFrom(queryBuilder.getClass())) {
			final SqlQuery query = ((SqlQueryBuilder) queryBuilder).buildSqlQuery();
			return getSession().execute(new HibernateCallback<Pager<T>>() {
				@Override
				public Pager<T> doInHibernate(Session session) throws HibernateException, SQLException {
					SQLQuery sql = session.createSQLQuery(query.getSql());
					SQLQuery sqlCount = session.createSQLQuery(query.getSqlCount());
					Object[] parameters = query.getQueryParameter();
					for (int i = 0; i < parameters.length; i++) {
						sql.setParameter(i, parameters[i]);
						sqlCount.setParameter(i, parameters[i]);
					}
					long count = ((Number) sqlCount.uniqueResult()).longValue();
					sql.setMaxResults(pager.getMaxResults());
					sql.setFirstResult(pager.getFirstResult());
					@SuppressWarnings("unchecked")
					List<T> results = sql.list();
					pager.setCount(count);
					pager.setResults(results);
					return pager;
				}
			});
		} else {
			throw new IllegalArgumentException("Query Class not supported, Pager.getQuery.getClass():" + queryBuilder.getClass());
		}
	}
	 */

	/**
	 * Support {@link Limition}.
	 * @see sinonet.framework.dao.GenericDAO#hql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> hql(final String hql, final Object... args) {
		logger.trace("HQL query, hql:[{}], args count:{}.", hql, args==null?0:args.length);
		Query query = getSession().createQuery(hql);
		for (int i=0;args!=null&&i<args.length;i++) {
			query.setParameter(i, args[i]);
		}
		return query.list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#hql(long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> hql(final long firstResult, final long maxResults, final String hql, final Object... args) {
		logger.trace("HQL query, hql:[{}], args count:{}.", hql, args==null?0:args.length);
		Query query = getSession().createQuery(hql);
		query.setFirstResult((int) firstResult);
		query.setMaxResults((int)maxResults);
		return query.list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#hql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> hql(final Class<T> expectType, final String hql, final Object... args) {
		return (List<T>) hql(hql, args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#hql(java.lang.Class, long, long, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> hql(final Class<T> expectType, final long firstResult, final long maxResults, final String hql, final Object... args) {
		return (List<T>) hql(firstResult,maxResults,hql,args);
	}

	/**
	 * Support {@link Limition}
	 * @see sinonet.framework.dao.GenericDAO#sql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final String sql, final Object... args) {
		return sql((ResultTransformer)null,sql,args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#sql(long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final long firstResult, final long maxResults, final String sql, final Object... args) {
		return sql((ResultTransformer)null,firstResult,maxResults,sql,args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#sql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> sql(final Class<T> expectType, final String sql, final Object... args) {
		return (List<T>) sql(sql, args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#sql(java.lang.Class, long, long, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> sql(final Class<T> expectType, final long firstResult, final long maxResults, final String sql, final Object... args) {
		return (List<T>) sql(firstResult,maxResults,sql,args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#uniqueResultHql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object uniqueResultHql(final String hql, final Object... args) {
		logger.trace("HQL unique query, hql:[{}], args count:{}.", hql, args==null?0:args.length);
		Query query = getSession().createQuery(hql);
		for (int i=0;args!=null&&i<args.length;i++) {
			query.setParameter(i, args[i]);
		}
		return query.uniqueResult();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#uniqueResultHql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T uniqueResultHql(final Class<T> expectType, final String hql, final Object... args) {
		return (T) uniqueResultHql(hql, args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#uniqueResultByProperties(java.lang.Class, java.lang.String[], java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperties(final Class<E> clazz, final String[] properties, final Object[] args) {
		if (properties==null||args==null) {
			throw new NullPointerException("argument properties and args must not be null.");
		}
		if (properties.length!=args.length) {
			throw new IllegalArgumentException("argument properties.length must equals args.length.");
		}
		logger.trace("UniqueResultByProperties: properties:{}", new Object[]{properties});
		Criteria criteria = getSession().createCriteria(clazz);
		for (int i=0;i<properties.length;i++) {
			String property = properties[i];
			if (property==null) {
				throw new NullPointerException("properties["+i+"] must not be null.");
			}
			Object arg = args[i];
			criteria.add(arg==null?Restrictions.isNull(property):Restrictions.eq(property, arg));
		}
		return (E) criteria.uniqueResult();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#uniqueResultByProperty(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperty(final Class<E> clazz, final String property, final Object arg) {
		return uniqueResultByProperties(clazz, new String[]{property}, new Object[]{arg});
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#queryByProperties(java.lang.Class, java.lang.String[], java.lang.Object[], org.hibernate.criterion.Order[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final String[] properties, final Object[] args, final Order... orders) {
		if (properties==null||args==null) {
			throw new NullPointerException("argument properties and args must not be null.");
		}
		if (properties.length!=args.length) {
			throw new IllegalArgumentException("argument properties.length must equals args.length.");
		}
		Criteria criteria = getSession().createCriteria(clazz);
		for (int i=0;i<properties.length;i++) {
			String property = properties[i];
			if (property==null) {
				throw new NullPointerException("property name must not be null, properties position:"+i);
			}
			Object arg = args[i];
			criteria.add(arg==null?Restrictions.isNull(property):Restrictions.eq(property, arg));
			if (orders!=null) {
				for (Order order:orders) {
					criteria.addOrder(order);
				}
			}
		}
		return criteria.list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#queryByProperty(java.lang.Class, java.lang.String, java.lang.Object, org.hibernate.criterion.Order[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final String property, final Object arg, final Order... orders) {
		return queryByProperties(clazz, new String[]{property}, new Object[]{arg}, orders);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#queryByProperties(java.lang.Class, long, long, java.lang.String[], java.lang.Object[], org.hibernate.criterion.Order[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final long firstResult, final long maxResults, final String[] properties, final Object[] args, final Order... orders) {
		if (properties==null||args==null) {
			throw new NullPointerException("argument properties and args must not be null.");
		}
		if (properties.length!=args.length) {
			throw new IllegalArgumentException("argument properties.length must equals args.length.");
		}
		Criteria criteria = getSession().createCriteria(clazz);
		for (int i=0;i<properties.length;i++) {
			String property = properties[i];
			if (property==null) {
				throw new NullPointerException("property name must not be null, properties position:"+i);
			}
			Object arg = args[i];
			criteria.add(arg==null?Restrictions.isNull(property):Restrictions.eq(property, arg));
			if (orders!=null) {
				for (Order order:orders) {
					criteria.addOrder(order);
				}
			}
			criteria.setMaxResults((int)maxResults);
			criteria.setFirstResult((int)firstResult);
		}
		return criteria.list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#queryByProperty(java.lang.Class, long, long, java.lang.String, java.lang.Object, org.hibernate.criterion.Order[])
	 */
	@Override
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final long firstResult, final long maxResults, final String property, final Object arg, final Order... orders) {
		return queryByProperties(clazz, firstResult, maxResults, new String[]{property}, new Object[]{arg}, orders);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#uniqueResultSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object uniqueResultSql(final String sql, final Object... args) {
		return uniqueResultSql((ResultTransformer)null, sql, args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#uniqueResultSql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T uniqueResultSql(final Class<T> expectType, final String sql, final Object... args) {
		logger.debug("SQL unique query, expectType:{}, sql:[{}], args count:{}.", new Object[] { expectType.getName(), sql, args.length });
		SQLQuery query = getSession().createSQLQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		return (T) query.uniqueResult();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#criteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public List<?> criteria(final DetachedCriteria criteria) {
		logger.debug("DetachedCriteria query:{}.", criteria);
		return criteria.getExecutableCriteria(getSession()).list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#callback(org.springframework.orm.hibernate3.HibernateCallback)
	 */
	@Override
	public <T> T callback(final HibernateCallback<T> callback) {
		logger.debug("Callback Execute:{}.", callback);
		try {
			return callback.doInHibernate(getSession());
		} catch (SQLException e) {
			// never happend?
			throw new HibernateException(e);
		}
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#topResultHql(java.lang.Class, int, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> topResultHql(final Class<T> clazz, final int top, final String hql, final Object... args) {
		Query query = getSession().createQuery(hql);
		query.setMaxResults(top);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		return query.list();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#topResultSql(java.lang.Class, int, java.lang.String, java.lang.Object[])
	 */
	@Override
	public <T> List<T> topResultSql(final Class<T> clazz, final int top, final String sql, final Object... args) {
		return topResultSql(clazz, null, top, sql, args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#topResultHql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T topResultHql(final Class<T> clazz, final String hql, final Object... args) {
		Query query = getSession().createQuery(hql);
		query.setMaxResults(1);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#topResultHql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object topResultHql(final String hql, final Object... args) {
		Query query = getSession().createQuery(hql);
		query.setMaxResults(1);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		return query.uniqueResult();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#topResultSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object topResultSql(final String sql, final Object... args) {
		return topResultSql((ResultTransformer)null, sql, args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#topResultSql(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T topResultSql(final Class<T> clazz, final String sql, final Object... args) {
		return (T) topResultSql(sql,args);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#iterate(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> Iterator<T> iterate(final Class<T> clazz, final String hql, final Object... args) {
		Query query = getSession().createQuery(hql);
		for (int i=0;args!=null&&args.length<0;i++) {
			query.setParameter(i, args);
		}
		return query.iterate();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#closeIterator(java.util.Iterator)
	 */
	@Override
	public void closeIterator(final Iterator<?> iterator) {
		Hibernate.close(iterator);
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#bulkUpdateHql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int bulkUpdateHql(final String hql, final Object... args) {
		Query query = getSession().createQuery(hql);
		for (int i=0;args!=null&&i<args.length;i++) {
			query.setParameter(i, args[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * @see sinonet.framework.dao.GenericDAO#bulkUpdateSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int bulkUpdateSql(final String sql, final Object... args) {
		SQLQuery query = getSession().createSQLQuery(sql);
		for (int i = 0; args != null && i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final ResultTransformer resultTransformer, final String sql, final Object... args) {
		logger.trace("SQL query, sql:[{}], args count:{}.", sql, args==null?0:args.length);
		SQLQuery query = getSession().createSQLQuery(sql);
		for (int i = 0; args!=null&&i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		if (resultTransformer!=null) {
			query.setResultTransformer(resultTransformer);
		}
		return query.list();
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(org.hibernate.transform.ResultTransformer, long, long, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> sql(final ResultTransformer resultTransformer, final long firstResult, final long maxResults, final String sql, final Object... args) {
		logger.trace("SQL query with page, sql:[{}], args count:{}, firstResult:{}, maxResults:{}", sql, args==null?0:args.length, firstResult, maxResults);
		SQLQuery query = getSession().createSQLQuery(sql);
		for (int i = 0; args!=null&&i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		query.setFirstResult((int)firstResult);
		query.setMaxResults((int)maxResults);
		if (resultTransformer!=null) {
			query.setResultTransformer(resultTransformer);
		}
		return query.list();
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(java.lang.Class, org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> sql(final Class<T> expectType, final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return (List<T>) sql(resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#sql(java.lang.Class, org.hibernate.transform.ResultTransformer, long, long, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> sql(final Class<T> expectType, final ResultTransformer resultTransformer, final long firstResult, final long maxResults, final String sql, final Object... args) {
		return (List<T>) sql(resultTransformer, firstResult, maxResults, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultSql(org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object uniqueResultSql(final ResultTransformer resultTransformer, final String sql, final Object... args) {
		logger.debug("SQL unique query, sql:[{}], args count:{}.", sql, args.length);
		SQLQuery query = getSession().createSQLQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		if (resultTransformer!=null) {
			query.setResultTransformer(resultTransformer);
		}
		return query.uniqueResult();
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#uniqueResultSql(java.lang.Class, org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T uniqueResultSql(final Class<T> expectType, final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return (T) uniqueResultSql(resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultSql(org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object topResultSql(final ResultTransformer resultTransformer, final String sql, final Object... args) {
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.setMaxResults(1);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				sqlQuery.setParameter(0, args[i]);
			}
		}
		if (resultTransformer!=null) {
			sqlQuery.setResultTransformer(resultTransformer);
		}
		return sqlQuery.uniqueResult();
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultSql(java.lang.Class, org.hibernate.transform.ResultTransformer, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T topResultSql(final Class<T> clazz, final ResultTransformer resultTransformer, final String sql, final Object... args) {
		return (T) topResultSql(resultTransformer, sql, args);
	}

	/**
	 * @see net.lc4ever.framework.dao.GenericDao#topResultSql(java.lang.Class, org.hibernate.transform.ResultTransformer, int, java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> topResultSql(final Class<T> clazz, final ResultTransformer resultTransformer, final int top, final String sql, final Object... args) {
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.setMaxResults(top);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				sqlQuery.setParameter(i, args[i]);
			}
		}
		if (resultTransformer!=null) {
			sqlQuery.setResultTransformer(resultTransformer);
		}
		return sqlQuery.list();
	}

}
