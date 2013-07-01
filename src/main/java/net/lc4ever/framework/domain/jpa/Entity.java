/*
 * Framework: net.lc4ever.framework.domain.jpa.Entity.java create by q-wang on Apr 1, 2013 10:32:46 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.jpa;

import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
@javax.persistence.Entity
@Table(name="T2_JPA_ENTITY")
public class Entity implements BaseEntity<Long>{

	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
