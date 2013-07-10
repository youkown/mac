/*
 * Framework: net.lc4ever.framework.domain.meta.ParameterMeta.java create by q-wang on May 16, 2013 11:07:48 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.meta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @see java.sql.ParameterMetaData
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_META_PARAMETER")
public class ParameterMeta implements BaseEntity<Long> {

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
	public void setId(final Long id) {
		this.id = id;
	}

	private boolean nullable;

	private boolean signed;

	private int precision;

	private int scale;

	private int parameterType;

	private String parameterTypeName;

	private String parameterClassName;

	private int parameterMode;

}
