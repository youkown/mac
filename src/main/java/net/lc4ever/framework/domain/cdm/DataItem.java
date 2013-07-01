/*
 * Framework: net.lc4ever.framework.domain.cdm.DataItem.java create by q-wang on Apr 1, 2013 10:26:03 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.cdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.lc4ever.framework.domain.TimestampObject;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T3_CDM_DATA_ITEM")
public class DataItem extends TimestampObject<Long> {

	private Long id;

	@Override
	@Id
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
