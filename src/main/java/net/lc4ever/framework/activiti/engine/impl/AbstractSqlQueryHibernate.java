/*
 * SinoNetFramework: net.lc4ever.framework.activiti.engine.impl.AbstractSqlQueryHibernate.java create by q-wang on Jul 31, 2013 10:10:53 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.activiti.engine.impl;

import java.util.ArrayList;
import java.util.List;

import net.lc4ever.framework.service.GenericCrudService;

import org.activiti.engine.query.Query;
import org.hibernate.transform.ResultTransformer;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public abstract class AbstractSqlQueryHibernate<T extends Query<?,?>, U> implements Query<T, U> {

	protected transient GenericCrudService crudService;

	protected ResultTransformer resultTransformer;

	protected AbstractSqlQueryHibernate(final GenericCrudService crudService, final ResultTransformer resultTransformer) {
		this.crudService = crudService;
		this.resultTransformer = resultTransformer;
	}

	public static final String SQL_COUNT_PREFIX = "select count(*) from ( ";
	public static final String SQL_COUNT_SUFFIX = " )";

	private String orderField;

	private List<Object> parameters = new ArrayList<Object>();

	private StringBuilder orders = new StringBuilder();

	private StringBuilder sqlWhere = new StringBuilder("where 1=1 ");

	protected abstract String getSelectCause();

	@SuppressWarnings("unchecked")
	protected T addOrder(final String orderColumn) {
		if (orderField!=null) throw new IllegalStateException("Previous Order Field not define asc or desc:" + orderField);
		orderField = orderColumn;
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	protected T addCondition(final String where, final Object parameter) {
		sqlWhere.append(where);
		parameters.add(parameter);
		return (T) this;
	}

	private StringBuilder getSql() {
		StringBuilder sql = new StringBuilder(getSelectCause());
		sql.append(sqlWhere);
		if (orders.length()>0) {
			sql.append("order by ").append(orders);
		}
		return sql;
	}

	private String getCountSql() {
		StringBuilder sql = new StringBuilder(SQL_COUNT_PREFIX);
		sql.append(getSelectCause());
		sql.append(sqlWhere);
		sql.append(SQL_COUNT_SUFFIX);
		return sql.toString();
	}

	/**
	 * @see org.activiti.engine.query.Query#asc()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T asc() {
		if (orderField==null) throw new IllegalStateException("No order column defined.");
		orders.append(orderField).append(" asc ");
		orderField = null;
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.Query#desc()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T desc() {
		if (orderField==null) throw new IllegalStateException("No order column defined.");
		orders.append(orderField).append(" desc ");
		orderField = null;
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.Query#count()
	 */
	@Override
	public long count() {
		return crudService.uniqueResultSql(Number.class, getCountSql(), parameters.toArray()).longValue();
	}

	/**
	 * @see org.activiti.engine.query.Query#singleResult()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public U singleResult() {
		return (U) crudService.uniqueResultSql(resultTransformer, getSql().toString(), parameters.toArray());
	}

	/**
	 * @see org.activiti.engine.query.Query#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<U> list() {
		return (List<U>) crudService.sql(resultTransformer, getSql().toString(), parameters.toArray());
	}

	/**
	 * @see org.activiti.engine.query.Query#listPage(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<U> listPage(final int firstResult, final int maxResults) {
		return (List<U>) crudService.sql(resultTransformer, firstResult, maxResults, getSql().toString(), parameters.toArray());
	}

}
