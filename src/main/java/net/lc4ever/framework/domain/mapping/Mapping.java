/*
 * Framework: net.lc4ever.framework.domain.mapping.Mapping.java create by q-wang on May 22, 2013 1:12:59 AM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.mapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_MAPPING")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="MAPPING_TYPE")
public abstract class Mapping implements BaseEntity<Long> {

	private Long id;

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#setId(java.io.Serializable)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 映射类型.
	 * 
	 * MAPPING_TYPE length:8
	 */
	private String mappingType;

	/**
	 * 映射类型.
	 * 
	 * MAPPING_TYPE length:8
	 * @return the mappingType
	 */
	@Column(name="MAPPING_TYPE",length=8)
	public String getMappingType() {
		return mappingType;
	}


	/**
	 * 映射类型.
	 * 
	 * MAPPING_TYPE length:8
	 * @param mappingType the mappingType to set
	 */
	public void setMappingType(String mappingType) {
		this.mappingType = mappingType;
	}

}
