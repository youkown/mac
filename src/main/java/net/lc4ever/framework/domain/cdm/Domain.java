/*
 * Framework: net.lc4ever.framework.domain.cdm.Domain.java create by q-wang on Mar 31, 2013 11:21:44 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.cdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import net.lc4ever.framework.domain.TimestampObject;


/**
 * 数据物理定义.
 * 
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T3_CDM_DOMAIN",uniqueConstraints={@UniqueConstraint(columnNames={"NAMESPACE","CODE"})})
public class Domain extends TimestampObject<Long> {

	/** 逻辑主键 ID */
	private Long id;

	/**
	 * 逻辑主键.
	 * 
	 * ID
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
	@Id
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	/**
	 * 逻辑主键.
	 * 
	 * ID
	 * @see net.lc4ever.framework.domain.BaseEntity#setId(java.io.Serializable)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/** 命名空间 NAMESPACE */
	private String namespace;

	/** 代码 CODE */
	private String code;

	/** 描述 DESCRIPTION */
	private String descripton;

	/** JAVA 数据类型 JAVA_TYPE */
	private String javaType;

	/** 数据库类型 SQL_TYPE */
	private String sqlType;

	/** 数据长度 SIZE */
	private int size;

	/** 数据精度 SCALE */
	private int scale;

	/** 是否可空 NULLABLE */
	private boolean nullable;

	/** 默认值 DEFAULT_VALUE */
	private String defaultValue;


	/**
	 * @return the namespace
	 */
	@Column(name="NAMESPACE",nullable=true,length=512)
	public String getNamespace() {
		return namespace;
	}


	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}


	/**
	 * @return the code
	 */
	@Column(name="CODE",nullable=false,length=32)
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @return the descripton
	 */
	@Column(name="DESCRIPTION",length=512)
	public String getDescripton() {
		return descripton;
	}


	/**
	 * @param descripton the descripton to set
	 */
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}


	/**
	 * @return the javaType
	 */
	@Column(name="JAVA_TYPE",nullable=false,length=32)
	public String getJavaType() {
		return javaType;
	}


	/**
	 * @param javaType the javaType to set
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}


	/**
	 * @return the sqlType
	 */
	@Column(name="SQL_TYPE",nullable=false,length=32)
	public String getSqlType() {
		return sqlType;
	}


	/**
	 * @param sqlType the sqlType to set
	 */
	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}


	/**
	 * @return the size
	 */
	@Column(name="SIZE")
	public int getSize() {
		return size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * @return the scale
	 */
	@Column(name="SCALE")
	public int getScale() {
		return scale;
	}


	/**
	 * @param scale the scale to set
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}


	/**
	 * @return the nullable
	 */
	@Column(name="NULLABLE")
	public boolean isNullable() {
		return nullable;
	}


	/**
	 * @param nullable the nullable to set
	 */
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}


	/**
	 * @return the defaultValue
	 */
	@Column(name="DEFAULT_VALUE",length=512)
	public String getDefaultValue() {
		return defaultValue;
	}


	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
