/*
 * Framework: net.lc4ever.framework.domain.meta.ResultSetMeta.java create by q-wang on May 16, 2013 11:08:06 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.meta;

import java.sql.ResultSetMetaData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_META_RESULT_SET")
@SuppressWarnings("unused")
public class ResultSetMeta implements BaseEntity<Long> {

	private Long id;

	@Override
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	private SqlStatement sqlStatement;

	private int index; // start with 1, the result set column position

	/**
	 * @see ResultSetMetaData#isAutoIncrement(int)
	 */
	private boolean isAutoIncrement;
	/**
	 * @see ResultSetMetaData#isCaseSensitive(int)
	 */
	private boolean isCaseSensitive;
	/**
	 * @see ResultSetMetaData#isSearchable(int)
	 */
	private boolean isSearchable;
	/**
	 * @see ResultSetMetaData#isCurrency(int)
	 */
	private boolean isCurrency;
	/**
	 * @see ResultSetMetaData#isNullable(int)
	 */
	private int isNullable;
	/**
	 * @see ResultSetMetaData#isSigned(int)
	 */
	private boolean isSigned;
	/**
	 * @see ResultSetMetaData#getColumnDisplaySize(int)
	 */
	private int columnDisplaySize;
	/**
	 * @see ResultSetMetaData#getColumnLabel(int)
	 */
	private String columnLabel;
	/**
	 * @see ResultSetMetaData#getColumnName(int)
	 */
	private String columnName;
	/**
	 * @see ResultSetMetaData#getSchemaName(int)
	 */
	private String schemaName;
	/**
	 * @see ResultSetMetaData#getPrecision(int)
	 */
	private int precision;
	/**
	 * @see ResultSetMetaData#getScale(int)
	 */
	private int scale;
	/**
	 * @see ResultSetMetaData#getTableName(int)
	 */
	private String tableName;
	/**
	 * @see ResultSetMetaData#getCatalogName(int)
	 */
	private String catalogName;
	/**
	 * @see ResultSetMetaData#getColumnType(int)
	 */
	private int columnType;
	/**
	 * @see ResultSetMetaData#getColumnTypeName(int)
	 */
	private String columnTypeName;
	/**
	 * @see ResultSetMetaData#isReadOnly(int)
	 */
	private boolean isReadOnly;
	/**
	 * @see ResultSetMetaData#isWritable(int)
	 */
	private boolean isWritable;
	/**
	 * @see ResultSetMetaData#isDefinitelyWritable(int)
	 */
	private boolean isDefinitelyWritable;
	/**
	 * @see ResultSetMetaData#getColumnClassName(int)
	 */
	private String columnClassName; // jdbc 2.0, since 1.2

	private long detectedTimestamp;
	private long detectedRevision;
	private String description;
	private String name;
	private Long display;

}
