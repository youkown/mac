/*
 * Framework: net.lc4ever.framework.dao.generic.ConditionalAccess.java create by q-wang on May 1, 2013 10:29:36 AM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.generic;

import java.io.Serializable;
import java.util.List;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public interface ConditionalAccess {

	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperties(final Class<E> clazz, final String[] properties, final Object[] args);

	public <E extends BaseEntity<ID>, ID extends Serializable> E uniqueResultByProperty(final Class<E> clazz, final String property, final Object arg);

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperties(final Class<E> clazz, final String[] properties, final Object[] args);

	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> queryByProperty(final Class<E> clazz, final String property, final Object arg);

	public <E extends BaseEntity<ID>, ID extends Serializable> void updateProperty(final Class<E> clazz, final ID id, final String property, final Object value);
	public <E extends BaseEntity<ID>, ID extends Serializable> void updateProperty(final E entity, final String property, final Object value);
	public <E extends BaseEntity<ID>, ID extends Serializable> void updateProperties(final Class<E> clazz, final ID id, final String[] properties,final Object[] args);
	public <E extends BaseEntity<ID>, ID extends Serializable> void updateProperties(final E entity, final String[] properties, final Object[] args);

}
