/*
 * SinoNetFramework: net.lc4ever.framework.domain.AuditableUUIDObject.java create by q-wang on Aug 6, 2013 10:39:06 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@MappedSuperclass
public abstract class AuditableUUIDObject extends AuditableObject<String> {

	private String id;

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
	@Id
	@Column(name = "ID", length = 36)
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
	public String getId() {
		return id;
	}

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#setId(java.io.Serializable)
	 */
	@Override
	public void setId(final String id) {
		this.id = id;
	}

}
