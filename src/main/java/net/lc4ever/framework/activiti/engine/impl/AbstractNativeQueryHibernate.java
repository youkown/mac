/*
 * SinoNetFramework: net.lc4ever.framework.activiti.engine.impl.AbstractNativeQueryHibernate.java create by q-wang on Jul 31, 2013 4:36:53 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.activiti.engine.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.lc4ever.framework.service.GenericCrudService;

import org.activiti.engine.query.NativeQuery;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.HibernateCallback;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public abstract class AbstractNativeQueryHibernate<T extends NativeQuery< ? , ? >, U> implements NativeQuery<T, U> {

	private static final String COUNT_PREFIX = "select count(*) from (";
	private static final String COUNT_SUFFIX = ")";

	private transient GenericCrudService crudService;
	private ResultTransformer resultTransformer;

	private String selectClause;
	private Map<String, Object> parameters;

	protected AbstractNativeQueryHibernate(final GenericCrudService crudService, final ResultTransformer resultTransformer) {
		if (crudService==null) throw new IllegalArgumentException("CrudService must not be null for query.");
		if (resultTransformer==null) throw new IllegalArgumentException("ResultTransformer must not be null for query.");
		this.crudService = crudService;
		this.resultTransformer = resultTransformer;
	}

	/**
	 * @see org.activiti.engine.query.NativeQuery#sql(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T sql(final String selectClause) {
		this.selectClause = selectClause;
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.NativeQuery#parameter(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T parameter(final String name, final Object value) {
		if (parameters==null) parameters = new HashMap<String, Object>();
		parameters.put(name, value);
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.NativeQuery#count()
	 */
	@Override
	public long count() {
		// TODO Any cute idea for count sql?
		return crudService.callback(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(final Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(COUNT_PREFIX + selectClause + COUNT_SUFFIX);
				if (parameters!=null) {
					for (Map.Entry<String, Object> entry:parameters.entrySet()) {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				if (resultTransformer!=null) query.setResultTransformer(resultTransformer);
				return ((Number) query.uniqueResult()).longValue();
			}
		});
	}

	/**
	 * @see org.activiti.engine.query.NativeQuery#singleResult()
	 */
	@Override
	public U singleResult() {
		return crudService.callback(new HibernateCallback<U>() {
			@SuppressWarnings("unchecked")
			@Override
			public U doInHibernate(final Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(selectClause);
				if (parameters!=null) {
					for (Map.Entry<String, Object> entry:parameters.entrySet()) {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				if (resultTransformer!=null) query.setResultTransformer(resultTransformer);
				return (U) query.uniqueResult();
			}
		});
	}

	/**
	 * @see org.activiti.engine.query.NativeQuery#list()
	 */
	@Override
	public List<U> list() {
		return crudService.callback(new HibernateCallback<List<U>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<U> doInHibernate(final Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(selectClause);
				if (parameters!=null) {
					for (Map.Entry<String, Object> entry:parameters.entrySet()) {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				if (resultTransformer!=null) query.setResultTransformer(resultTransformer);
				return query.list();
			}
		});
	}

	/**
	 * @see org.activiti.engine.query.NativeQuery#listPage(int, int)
	 */
	@Override
	public List<U> listPage(final int firstResult, final int maxResults) {
		return crudService.callback(new HibernateCallback<List<U>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<U> doInHibernate(final Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(selectClause);
				if (parameters!=null) {
					for (Map.Entry<String, Object> entry:parameters.entrySet()) {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				if (resultTransformer!=null) query.setResultTransformer(resultTransformer);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				return query.list();
			}
		});
	}
}
