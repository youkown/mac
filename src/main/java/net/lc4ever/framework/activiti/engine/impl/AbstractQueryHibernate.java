/*
 * SinoNetFramework: net.lc4ever.framework.activiti.engine.impl.AbstractQueryHibernate.java create by q-wang on Jul 31, 2013 4:34:12 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.activiti.engine.impl;

import java.util.List;

import net.lc4ever.framework.service.GenericCrudService;

import org.activiti.engine.query.Query;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public abstract class AbstractQueryHibernate<T extends Query<?,?>, U> implements Query<T, U> {

	protected transient GenericCrudService crudService;

	public AbstractQueryHibernate(final GenericCrudService crudService) {
		this.crudService = crudService;
	}

	/**
	 * @see org.activiti.engine.query.Query#asc()
	 */
	@Override
	public T asc() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.activiti.engine.query.Query#desc()
	 */
	@Override
	public T desc() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.activiti.engine.query.Query#count()
	 */
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see org.activiti.engine.query.Query#singleResult()
	 */
	@Override
	public U singleResult() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.activiti.engine.query.Query#list()
	 */
	@Override
	public List<U> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.activiti.engine.query.Query#listPage(int, int)
	 */
	@Override
	public List<U> listPage(final int firstResult, final int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

}
