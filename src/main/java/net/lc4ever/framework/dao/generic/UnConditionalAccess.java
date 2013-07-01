/*
 * Framework: net.lc4ever.framework.dao.generic.UnConditionalAccess.java create by q-wang on Mar 31, 2013 10:48:55 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.generic;

import java.io.Serializable;
import java.util.List;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public interface UnConditionalAccess {

	// 无条件全表语句
	/**
	 * 取得指定类的所有数据库记录.
	 * 
	 * @param clazz
	 * @return
	 */
	public <E extends BaseEntity<ID>, ID extends Serializable> List<E> list(Class<E> clazz);

	/**
	 * 取得指定类的所有数据库记录数.
	 * 
	 * @param clazz
	 * @return
	 */
	public <E extends BaseEntity<ID>, ID extends Serializable> long count(Class<E> clazz);

}
