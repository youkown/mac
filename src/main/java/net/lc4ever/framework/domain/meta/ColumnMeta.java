/*
 * Framework: net.lc4ever.framework.domain.meta.ColumnMeta.java create by q-wang on May 16, 2013 11:10:33 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.meta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;

import org.hibernate.annotations.GenericGenerator;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_META_COLUMN")
public class ColumnMeta implements BaseEntity<String> {

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

	/**
	 * 相关TABLE数据.
	 * TABLE_META_ID
	 */
	private TableMeta tableMeta;

	/**
	 * 检测时间戳.
	 * DETECTED_TIMESTAMP
	 */
	private long detectedTimestamp;

	/**
	 * 检测版本
	 * DETECTED_REVISION
	 */
	private long detectedRevision;

	/** 
	 * 1.TABLE_CAT String => table catalog (may be null)
	 * length:64
	 */
	private String tableCatalog;

	/**
	 * 2.TABLE_SCHEM String => table schema (may be null)
	 * length:64
	 */
	private String tableSchema;

	/**
	 * 3.TABLE_NAME String => table name
	 * length:64
	 */
	private String tableName;

	/**
	 * 4.COLUMN_NAME String => column name
	 * length:64
	 */
	private String columnName;

	/**
	 * 5.DATA_TYPE int => SQL type from java.sql.Types
	 */
	private int dataType;

	/**
	 * 6.TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified
	 * length:64
	 */
	private String typeName;

	/**
	 * 7.COLUMN_SIZE int => column size.
	 */
	private int columnSize;

	/**
	 * 8.BUFFER_LENGTH is not used.
	 */
	private int bufferLength;

	/**
	 * 9.DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable.
	 */
	private int decimalDigits;

	/**
	 * 10.NUM_PREC_RADIX int => Radix (typically either 10 or 2)
	 */
	private int numPrecRadix;

	/**
	 * 11.NULLABLE int => is NULL allowed.
	 * 
	 * <pre>
	 * <ul>
	 *      <li> 0:columnNoNulls - might not allow <code>NULL</code> values</li>
	 *      <li> 1:columnNullable - definitely allows <code>NULL</code> values</li>
	 *      <li> 2:columnNullableUnknown - nullability unknown</li>
	 * </ul>
	 * </pre>
	 */
	private int nullable;

	/**
	 * 12.REMARKS String => comment describing column (may be null)
	 * length:256
	 */
	private String remarks;

	/**
	 * 13.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
	 * length:64
	 */
	private String columnDef;

	/**
	 * 14.SQL_DATA_TYPE int => unused
	 */
	private int sqlDataType;

	/**
	 * 15.SQL_DATETIME_SUB int => unused
	 */
	private int sqlDatetimeSub;

	/**
	 * 16.CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column
	 */
	private int charOctetLength;

	/**
	 * 17.ORDINAL_POSITION int => index of column in table (starting at 1)
	 */
	private int ordinalPosition;

	/**
	 * 18.IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if the column can include NULLs</li>
	 *       <li> NO            --- if the column cannot include NULLs</li>
	 *       <li> empty string  --- if the nullability for the column is unknown</li>
	 * </ul>
	 * length: 4
	 */
	private String isNullable;

	/**
	 * 19.SCOPE_CATALOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF)
	 * length:64
	 */
	private String scopeCatalog;

	/**
	 * 20.SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF)
	 * length:64
	 */
	private String scopeSchema;

	/**
	 * 21.SCOPE_TABLE String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF)
	 * length:64
	 */
	private String scopeTable;

	/**
	 * 22.SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF)
	 */
	private Short sourceDataType;

	/**
	 * 23.IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if the column is auto incremented</li>
	 *       <li> NO            --- if the column is not auto incremented</li>
	 *       <li> empty string  --- if it cannot be determined whether the column is auto incremented</li>
	 * </ul>
	 * </pre>
	 */
	private String isAutoIncrement;

	/**
	 * 24.IS_GENERATEDCOLUMN String => Indicates whether this is a generated column
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if this a generated column</li>
	 *       <li> NO            --- if this not a generated column</li>
	 *       <li> empty string  --- if it cannot be determined whether this is a generated column</li>
	 * </ul>
	 * </pre>
	 */
	private String isGeneratedColumn;

	/**
	 * 显示设置.
	 * 
	 * CFG_DISPLAY.
	 */
	private Long display;


	/**
	 * 相关TABLE数据.
	 * TABLE_META_ID
	 * @return the tableMeta
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	public TableMeta getTableMeta() {
		return tableMeta;
	}


	/**
	 * 相关TABLE数据.
	 * TABLE_META_ID
	 * @param tableMeta the tableMeta to set
	 */
	public void setTableMeta(TableMeta tableMeta) {
		this.tableMeta = tableMeta;
	}


	/**
	 * 检测时间戳.
	 * DETECTED_TIMESTAMP
	 * @return the detectedTimestamp
	 */
	public long getDetectedTimestamp() {
		return detectedTimestamp;
	}


	/**
	 * 检测时间戳.
	 * DETECTED_TIMESTAMP
	 * @param detectedTimestamp the detectedTimestamp to set
	 */
	public void setDetectedTimestamp(long detectedTimestamp) {
		this.detectedTimestamp = detectedTimestamp;
	}


	/**
	 * 检测版本
	 * DETECTED_REVISION
	 * @return the detectedRevision
	 */
	@Column(name="DETECTED_REVISION")
	public long getDetectedRevision() {
		return detectedRevision;
	}


	/**
	 * 检测版本
	 * DETECTED_REVISION
	 * @param detectedRevision the detectedRevision to set
	 */
	public void setDetectedRevision(long detectedRevision) {
		this.detectedRevision = detectedRevision;
	}


	/**
	 * 1.TABLE_CAT String => table catalog (may be null)
	 * length:64
	 * @return the tableCatalog
	 */
	@Column(name="TABLE_CAT",length=64,nullable=true)
	public String getTableCatalog() {
		return tableCatalog;
	}


	/**
	 * 1.TABLE_CAT String => table catalog (may be null)
	 * length:64
	 * @param tableCatalog the tableCatalog to set
	 */
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}


	/**
	 * 2.TABLE_SCHEM String => table schema (may be null)
	 * length:64
	 * @return the tableSchema
	 */
	@Column(name="TABLE_SCHEM",length=64,nullable=true)
	public String getTableSchema() {
		return tableSchema;
	}


	/**
	 * 2.TABLE_SCHEM String => table schema (may be null)
	 * length:64
	 * @param tableSchema the tableSchema to set
	 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}


	/**
	 * 3.TABLE_NAME String => table name
	 * length:64
	 * @return the tableName
	 */
	@Column(name="TABLE_NAME",length=64,nullable=false)
	public String getTableName() {
		return tableName;
	}


	/**
	 * 3.TABLE_NAME String => table name
	 * length:64
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	/**
	 * 4.COLUMN_NAME String => column name
	 * length:64
	 * @return the columnName
	 */
	@Column(name="COLUMN_NAME",length=64,nullable=false)
	public String getColumnName() {
		return columnName;
	}


	/**
	 * 4.COLUMN_NAME String => column name
	 * length:64
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	/**
	 * 5.DATA_TYPE int => SQL type from java.sql.Types
	 * @return the dataType
	 */
	@Column(name="DATA_TYPE")
	public int getDataType() {
		return dataType;
	}


	/**
	 * 5.DATA_TYPE int => SQL type from java.sql.Types
	 * @param dataType the dataType to set
	 */
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}


	/**
	 * 6.TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified
	 * length:64
	 * @return the typeName
	 */
	@Column(name="TYPE_NAME")
	public String getTypeName() {
		return typeName;
	}


	/**
	 * 6.TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified
	 * length:64
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	/**
	 * 7.COLUMN_SIZE int => column size.
	 * @return the columnSize
	 */
	@Column(name="COLUMN_SIZE")
	public int getColumnSize() {
		return columnSize;
	}


	/**
	 * 7.COLUMN_SIZE int => column size.
	 * @param columnSize the columnSize to set
	 */
	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}


	/**
	 * 8.BUFFER_LENGTH is not used.
	 * @return the bufferLength
	 */
	@Column(name="BUFFER_LENGTH")
	public int getBufferLength() {
		return bufferLength;
	}


	/**
	 * 8.BUFFER_LENGTH is not used.
	 * @param bufferLength the bufferLength to set
	 */
	public void setBufferLength(int bufferLength) {
		this.bufferLength = bufferLength;
	}


	/**
	 * 9.DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable.
	 * @return the decimalDigits
	 */
	@Column(name="DECIMAL_DIGITS")
	public int getDecimalDigits() {
		return decimalDigits;
	}


	/**
	 * 9.DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable.
	 * @param decimalDigits the decimalDigits to set
	 */
	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}


	/**
	 * 10.NUM_PREC_RADIX int => Radix (typically either 10 or 2)
	 * @return the numPrecRadix
	 */
	@Column(name="NUM_PREC_RADIX")
	public int getNumPrecRadix() {
		return numPrecRadix;
	}


	/**
	 * 10.NUM_PREC_RADIX int => Radix (typically either 10 or 2)
	 * @param numPrecRadix the numPrecRadix to set
	 */
	public void setNumPrecRadix(int numPrecRadix) {
		this.numPrecRadix = numPrecRadix;
	}


	/**
	 * 11.NULLABLE int => is NULL allowed.
	 * 
	 * <pre>
	 * <ul>
	 *      <li> 0:columnNoNulls - might not allow <code>NULL</code> values</li>
	 *      <li> 1:columnNullable - definitely allows <code>NULL</code> values</li>
	 *      <li> 2:columnNullableUnknown - nullability unknown</li>
	 * </ul>
	 * </pre>
	 * @return the nullable
	 */
	@Column(name="NULLABLE")
	public int getNullable() {
		return nullable;
	}


	/**
	 * 11.NULLABLE int => is NULL allowed.
	 * 
	 * <pre>
	 * <ul>
	 *      <li> 0:columnNoNulls - might not allow <code>NULL</code> values</li>
	 *      <li> 1:columnNullable - definitely allows <code>NULL</code> values</li>
	 *      <li> 2:columnNullableUnknown - nullability unknown</li>
	 * </ul>
	 * </pre>
	 * @param nullable the nullable to set
	 */
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}


	/**
	 * 12.REMARKS String => comment describing column (may be null)
	 * length:256
	 * @return the remarks
	 */
	@Column(name="REMARKS",length=256,nullable=true)
	public String getRemarks() {
		return remarks;
	}


	/**
	 * 12.REMARKS String => comment describing column (may be null)
	 * length:256
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 * 13.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
	 * length:64
	 * @return the columnDef
	 */
	@Column(name="COLUMN_DEF",length=64)
	public String getColumnDef() {
		return columnDef;
	}


	/**
	 * 13.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
	 * length:64
	 * @param columnDef the columnDef to set
	 */
	public void setColumnDef(String columnDef) {
		this.columnDef = columnDef;
	}


	/**
	 * 14.SQL_DATA_TYPE int => unused
	 * @return the sqlDataType
	 */
	@Column(name="SQL_DATA_TYPE")
	public int getSqlDataType() {
		return sqlDataType;
	}


	/**
	 * 14.SQL_DATA_TYPE int => unused
	 * @param sqlDataType the sqlDataType to set
	 */
	public void setSqlDataType(int sqlDataType) {
		this.sqlDataType = sqlDataType;
	}


	/**
	 * 15.SQL_DATETIME_SUB int => unused
	 * @return the sqlDatetimeSub
	 */
	@Column(name="SQL_DATETIME_SUB")
	public int getSqlDatetimeSub() {
		return sqlDatetimeSub;
	}


	/**
	 * 15.SQL_DATETIME_SUB int => unused
	 * @param sqlDatetimeSub the sqlDatetimeSub to set
	 */
	public void setSqlDatetimeSub(int sqlDatetimeSub) {
		this.sqlDatetimeSub = sqlDatetimeSub;
	}


	/**
	 * 16.CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column
	 * @return the charOctetLength
	 */
	@Column(name="CHAR_OCTET_LENGTH")
	public int getCharOctetLength() {
		return charOctetLength;
	}


	/**
	 * 16.CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column
	 * @param charOctetLength the charOctetLength to set
	 */
	public void setCharOctetLength(int charOctetLength) {
		this.charOctetLength = charOctetLength;
	}


	/**
	 * 17.ORDINAL_POSITION int => index of column in table (starting at 1)
	 * @return the ordinalPosition
	 */
	@Column(name="ORDINAL_POSITION")
	public int getOrdinalPosition() {
		return ordinalPosition;
	}


	/**
	 * 17.ORDINAL_POSITION int => index of column in table (starting at 1)
	 * @param ordinalPosition the ordinalPosition to set
	 */
	public void setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}


	/**
	 * 18.IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if the column can include NULLs</li>
	 *       <li> NO            --- if the column cannot include NULLs</li>
	 *       <li> empty string  --- if the nullability for the column is unknown</li>
	 * </ul>
	 * length: 4
	 * @return the isNullable
	 */
	@Column(name="IS_NULLABLE",nullable=true,length=4)
	public String getIsNullable() {
		return isNullable;
	}


	/**
	 * 18.IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if the column can include NULLs</li>
	 *       <li> NO            --- if the column cannot include NULLs</li>
	 *       <li> empty string  --- if the nullability for the column is unknown</li>
	 * </ul>
	 * length: 4
	 * @param isNullable the isNullable to set
	 */
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}


	/**
	 * 19.SCOPE_CATALOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF)
	 * length:64
	 * @return the scopeCatalog
	 */
	@Column(name="SCOPE_CATALOG",length=64, nullable=true)
	public String getScopeCatalog() {
		return scopeCatalog;
	}


	/**
	 * 19.SCOPE_CATALOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF)
	 * length:64
	 * @param scopeCatalog the scopeCatalog to set
	 */
	public void setScopeCatalog(String scopeCatalog) {
		this.scopeCatalog = scopeCatalog;
	}


	/**
	 * 20.SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF)
	 * length:64
	 * @return the scopeSchema
	 */
	@Column(name="SCOPE_SCHEMA",length=64,nullable=true)
	public String getScopeSchema() {
		return scopeSchema;
	}


	/**
	 * 20.SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF)
	 * length:64
	 * @param scopeSchema the scopeSchema to set
	 */
	public void setScopeSchema(String scopeSchema) {
		this.scopeSchema = scopeSchema;
	}


	/**
	 * 21.SCOPE_TABLE String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF)
	 * length:64
	 * @return the scopeTable
	 */
	@Column(name="SCOPE_TABLE",nullable=true,length=64)
	public String getScopeTable() {
		return scopeTable;
	}


	/**
	 * 21.SCOPE_TABLE String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF)
	 * length:64
	 * @param scopeTable the scopeTable to set
	 */
	public void setScopeTable(String scopeTable) {
		this.scopeTable = scopeTable;
	}


	/**
	 * 22.SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF)
	 * @return the sourceDataType
	 */
	@Column(name="SOURCE_DATA_TYPE")
	public Short getSourceDataType() {
		return sourceDataType;
	}


	/**
	 * 22.SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF)
	 * @param sourceDataType the sourceDataType to set
	 */
	public void setSourceDataType(Short sourceDataType) {
		this.sourceDataType = sourceDataType;
	}


	/**
	 * 23.IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if the column is auto incremented</li>
	 *       <li> NO            --- if the column is not auto incremented</li>
	 *       <li> empty string  --- if it cannot be determined whether the column is auto incremented</li>
	 * </ul>
	 * </pre>
	 * @return the isAutoIncrement
	 */
	@Column(name="IS_AUTOINCREMENT",length=4,nullable=true)
	public String getIsAutoIncrement() {
		return isAutoIncrement;
	}


	/**
	 * 23.IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if the column is auto incremented</li>
	 *       <li> NO            --- if the column is not auto incremented</li>
	 *       <li> empty string  --- if it cannot be determined whether the column is auto incremented</li>
	 * </ul>
	 * </pre>
	 * @param isAutoIncrement the isAutoIncrement to set
	 */
	public void setIsAutoIncrement(String isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}


	/**
	 * 24.IS_GENERATEDCOLUMN String => Indicates whether this is a generated column
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if this a generated column</li>
	 *       <li> NO            --- if this not a generated column</li>
	 *       <li> empty string  --- if it cannot be determined whether this is a generated column</li>
	 * </ul>
	 * </pre>
	 * @return the isGeneratedColumn
	 */
	@Column(name="IS_GENERATEDCOLUMN",length=4,nullable=true)
	public String getIsGeneratedColumn() {
		return isGeneratedColumn;
	}


	/**
	 * 24.IS_GENERATEDCOLUMN String => Indicates whether this is a generated column
	 * <pre>
	 * <ul>
	 *       <li> YES           --- if this a generated column</li>
	 *       <li> NO            --- if this not a generated column</li>
	 *       <li> empty string  --- if it cannot be determined whether this is a generated column</li>
	 * </ul>
	 * </pre>
	 * @param isGeneratedColumn the isGeneratedColumn to set
	 */
	public void setIsGeneratedColumn(String isGeneratedColumn) {
		this.isGeneratedColumn = isGeneratedColumn;
	}


	/**
	 * 显示设置.
	 * 
	 * CFG_DISPLAY.
	 * @return the display
	 */
	public Long getDisplay() {
		return display;
	}


	/**
	 * 显示设置.
	 * 
	 * CFG_DISPLAY.
	 * @param display the display to set
	 */
	public void setDisplay(Long display) {
		this.display = display;
	}

	/**
	 * 名称.
	 * 
	 * NAME length:64
	 */
	private String name;

	/**
	 * 描述.
	 * 
	 * DESCRIPTION length:512
	 */
	private String desciption;


	/**
	 * 名称.
	 * 
	 * NAME length:64
	 * @return the name
	 */
	@Column(name="NAME",length=64)
	public String getName() {
		return name;
	}


	/**
	 * 描述.
	 * 
	 * DESCRIPTION length:512
	 * @return the desciption
	 */
	@Column(name="DESCRIPTION",length=512)
	public String getDesciption() {
		return desciption;
	}


	/**
	 * 名称.
	 * 
	 * NAME length:64
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 描述.
	 * 
	 * DESCRIPTION length:512
	 * @param desciption the desciption to set
	 */
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}


}
