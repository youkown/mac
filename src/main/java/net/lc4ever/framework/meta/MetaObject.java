/*
 * SinoNetFramework: net.lc4ever.framework.meta.MetaObject.java create by q-wang on Sep 10, 2013 3:25:27 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.meta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name = "T5_META_OBJECT")
public class MetaObject implements BaseEntity<String> {

	private String id;

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
	@Id
	@Column(name = "ID", length = 36)
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
	public String getId() {
		return id;
	}

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#setId(java.io.Serializable)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	private String objectClass;

	private String objectName;

	private String parent;

	/**
	 * @return the objectClass
	 */
	@Column(name = "OBJECT_CLASS", length = 512, nullable = false)
	public String getObjectClass() {
		return objectClass;
	}

	/**
	 * @return the objectName
	 */
	@Column(name = "OBJECT_NAME", length = 255, nullable = false)
	public String getObjectName() {
		return objectName;
	}

	/**
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}

	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * @return the parent
	 */
	@Column(name = "PARENT", length = 36)
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}
}
