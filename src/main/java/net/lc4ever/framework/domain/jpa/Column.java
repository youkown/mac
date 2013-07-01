/*
 * Framework: net.lc4ever.framework.domain.jpa.Column.java create by q-wang on Apr 1, 2013 10:32:54 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
@Entity
@Table(name="T2_JPA_COLUMN")
public class Column implements BaseEntity<Long>{

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
