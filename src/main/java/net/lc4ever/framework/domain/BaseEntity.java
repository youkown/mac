/*
 * Framework: net.lc4ever.framework.domain.BaseEntity.java create by q-wang on Mar 17, 2013 4:28:11 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain;

import java.io.Serializable;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public interface BaseEntity<K extends Serializable> extends Serializable {

	public K getId();

	public void setId(K id);

	@Override
	public String toString();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object target);

}
