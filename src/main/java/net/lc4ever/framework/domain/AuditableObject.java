/*
 * Framework: net.lc4ever.framework.domain.AuditableObject.java create by q-wang on Apr 19, 2013 4:45:43 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain;

import java.io.Serializable;

import javax.persistence.Column;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
//@MappedSuperclass
public abstract class AuditableObject<K extends Serializable> extends TimestampObject<K> {

	/**
	 * 修改人ID.
	 * 
	 * MODIFIERS_ID
	 */
	protected String modifiersId;

	/**
	 * 创建人ID.
	 * 
	 * CREATORS_ID
	 */
	protected String creatorsId;


	/**
	 * 修改人ID.
	 * 
	 * MODIFIERS_ID
	 * @return the modifiersId
	 */
	@Column(name="MODIFIERS_ID",length=32,insertable=false)
	public String getModifiersId() {
		return modifiersId;
	}


	/**
	 * 修改人ID.
	 * 
	 * MODIFIERS_ID
	 * @param modifiersId the modifiersId to set
	 */
	public void setModifiersId(final String modifiersId) {
		this.modifiersId = modifiersId;
	}


	/**
	 * 创建人ID.
	 * 
	 * CREATORS_ID
	 * @return the creatorsId
	 */
	@Column(name="CREATORS_ID",length=32,updatable=false)
	public String getCreatorsId() {
		return creatorsId;
	}


	/**
	 * 创建人ID.
	 * 
	 * CREATORS_ID
	 * @param creatorsId the creatorsId to set
	 */
	public void setCreatorsId(final String creatorsId) {
		this.creatorsId = creatorsId;
	}

}
