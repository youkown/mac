/*
 * Framework: net.lc4ever.framework.dao.generic.IdBasedAccess.java create by q-wang on Mar 31, 2013 10:49:46 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.generic;

import java.io.Serializable;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public interface IdBasedAccess {

	/**
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <E extends BaseEntity<ID>, ID extends Serializable> E get(Class<E> clazz, ID id);

	public <E extends BaseEntity<ID>, ID extends Serializable> void delete(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> ID save(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> void update(E entity);

	public <E extends BaseEntity<ID>, ID extends Serializable> void saveOrUpdate(E entity);

}
