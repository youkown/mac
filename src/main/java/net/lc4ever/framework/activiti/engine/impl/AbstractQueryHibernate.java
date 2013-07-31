/*
 * SinoNetFramework: net.lc4ever.framework.activiti.engine.impl.AbstractQueryHibernate.java create by q-wang on Jul 31, 2013 4:34:12 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.activiti.engine.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.lc4ever.framework.service.GenericCrudService;

import org.activiti.engine.query.Query;
import org.apache.commons.lang.NotImplementedException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public abstract class AbstractQueryHibernate<T extends Query<?,?>, U, W> implements Query<T, U> {

	protected transient GenericCrudService crudService;

	protected Class<W> persistenceClass;

	protected boolean needWrap;

	public AbstractQueryHibernate(final GenericCrudService crudService, final Class<W> persistenceClass) {
		this.crudService = crudService;
		this.persistenceClass = persistenceClass;
	}

	public AbstractQueryHibernate(final GenericCrudService crudService, final Class<W> persistenceClass, final boolean needWrap) {
		this(crudService,persistenceClass);
		this.needWrap = needWrap;
	}

	protected List<Criterion> criterions;

	protected List<Order> orders;

	protected String orderField;

	protected void addOrder(final Order order) {
		if (orders==null) {
			orders = new ArrayList<Order>();
		}
		orders.add(order);
	}

	@SuppressWarnings("unchecked")
	protected T addCriterion(final Criterion criterion) {
		if (criterions==null) criterions = new ArrayList<Criterion>();
		criterions.add(criterion);
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.Query#asc()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T asc() {
		if (orderField==null) throw new IllegalStateException("No Order Field Defined.");
		addOrder(Order.asc(orderField));
		orderField = null;
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.Query#desc()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T desc() {
		if (orderField==null) throw new IllegalStateException("No Order Field Defined.");
		addOrder(Order.desc(orderField));
		orderField = null;
		return (T) this;
	}

	/**
	 * @see org.activiti.engine.query.Query#count()
	 */
	@Override
	public long count() {
		return crudService.callback(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(final Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistenceClass);
				if (criterions!=null) {
					for (Criterion criterion:criterions) {
						criteria.add(criterion);
					}
				}
				criteria.setProjection(Projections.rowCount());
				return ((Number)criteria.uniqueResult()).longValue();
			}
		}).longValue();
	}

	/**
	 * @see org.activiti.engine.query.Query#singleResult()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public U singleResult() {
		W result = crudService.callback(new HibernateCallback<W>() {
			@Override
			public W doInHibernate(final Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistenceClass);
				if (criterions!=null) {
					for (Criterion criterion:criterions) {
						criteria.add(criterion);
					}
				}
				return (W) criteria.uniqueResult();
			}
		});
		if (needWrap) return wrap(result);
		return (U) result;
	}

	/**
	 * @see org.activiti.engine.query.Query#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<U> list() {
		if (orderField!=null) throw new IllegalStateException("OrderField:" + orderField + " not define asc or desc.");
		List<W> results = crudService.callback(new HibernateCallback<List<W>>() {
			@Override
			public List<W> doInHibernate(final Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistenceClass);
				if (criterions!=null) {
					for (Criterion criterion:criterions) {
						criteria.add(criterion);
					}
				}
				if (orders!=null) {
					for (Order order:orders) {
						criteria.addOrder(order);
					}
				}
				return criteria.list();
			}
		});
		if (needWrap) {
			List<U> wraps = new ArrayList<U>(results.size());
			for (W w:results) {
				wraps.add(wrap(w));
			}
			return wraps;
		}
		return (List<U>) results;
	}

	/**
	 * @see org.activiti.engine.query.Query#listPage(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<U> listPage(final int firstResult, final int maxResults) {
		if (orderField!=null) throw new IllegalStateException("OrderField:" + orderField + " not define asc or desc.");
		List<W> results = crudService.callback(new HibernateCallback<List<W>>() {
			@Override
			public List<W> doInHibernate(final Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistenceClass);
				if (criterions!=null) {
					for (Criterion criterion:criterions) {
						criteria.add(criterion);
					}
				}
				if (orders!=null) {
					for (Order order:orders) {
						criteria.addOrder(order);
					}
				}
				criteria.setFirstResult(firstResult);
				criteria.setMaxResults(maxResults);
				return criteria.list();
			}
		});
		if (needWrap) {
			List<U> wraps = new ArrayList<U>(results.size());
			for (W w:results) {
				wraps.add(wrap(w));
			}
			return wraps;
		}
		return (List<U>) results;
	}

	protected U wrap(final W tobeWrap) {
		throw new NotImplementedException("wrap() method must implemented when needWrap is true.");
	};

}
