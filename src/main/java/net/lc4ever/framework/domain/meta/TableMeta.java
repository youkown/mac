/*
 * Framework: net.lc4ever.framework.domain.meta.TableMeta.java create by q-wang on May 16, 2013 11:09:59 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.meta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_META_TABLE")
public class TableMeta implements BaseEntity<Long> {

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
	 * 表类型.
	 * 
	 * Typical types are "TABLE","VIEW","SYSTEM TABLE","GLOBAL TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM"
	 * TABLE:1; VIEW:2; SYSTEM TABLE:3; GLOBAL TEMPORARY:4; LOCAL TEMPORARY:5; ALIAS:6; SYNONYM:7
	 * TABLE_TYPE default:1
	 */
	private int type; // Typical types are "TABLE","VIEW","SYSTEM TABLE","GLOBAL TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM"

	/**
	 * 最后检测时间戳.
	 * DETECTED_TIMESTAMP
	 */
	private long detectedTimestamp;
	/**
	 * 检测版本号.
	 * DETECTED_REVISION
	 */
	private long detectedRevision;

	// 
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
	 * 4.TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
	 */
	//	private String tableType;
	/**
	 * 5.REMARKS String => explanatory comment on the table
	 * length:256
	 */
	private String remarks;
	/**
	 * 6.TYPE_CAT String => the types catalog (may be null)
	 * length: 64
	 */
	private String typeCatalog;
	/** 
	 * 7.TYPE_SCHEM String => the types schema (may be null)
	 * length: 64
	 */
	private String typeSchema;
	/**
	 * 8.TYPE_NAME String => type name (may be null)
	 * length: 64
	 */
	private String typeName;
	/**
	 * 9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
	 * length: 64
	 */
	private String selfReferencingColName;
	/**
	 * 10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)
	 * length: 64
	 */
	private String refGeneration;

	/**
	 * 显示设置.
	 * 
	 * CFG_DISPLAY.
	 */
	private Long display;

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
	private String description;


	/**
	 * 表类型.
	 * 
	 * Typical types are "TABLE","VIEW","SYSTEM TABLE","GLOBAL TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM"
	 * TABLE:1; VIEW:2; SYSTEM TABLE:3; GLOBAL TEMPORARY:4; LOCAL TEMPORARY:5; ALIAS:6; SYNONYM:7
	 * TABLE_TYPE default:1
	 * @return the type
	 */
	@Column(name="TABLE_TYPE")
	public int getType() {
		return type;
	}


	/**
	 * 表类型.
	 * 
	 * Typical types are "TABLE","VIEW","SYSTEM TABLE","GLOBAL TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM"
	 * TABLE:1; VIEW:2; SYSTEM TABLE:3; GLOBAL TEMPORARY:4; LOCAL TEMPORARY:5; ALIAS:6; SYNONYM:7
	 * TABLE_TYPE default:1
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}


	/**
	 * 最后检测时间戳.
	 * DETECTED_TIMESTAMP
	 * @return the detectedTimestamp
	 */
	@Column(name="DETECTED_TIMESTAMP")
	public long getDetectedTimestamp() {
		return detectedTimestamp;
	}


	/**
	 * 最后检测时间戳.
	 * DETECTED_TIMESTAMP
	 * @param detectedTimestamp the detectedTimestamp to set
	 */
	public void setDetectedTimestamp(long detectedTimestamp) {
		this.detectedTimestamp = detectedTimestamp;
	}


	/**
	 * 检测版本号.
	 * DETECTED_REVISION
	 * @return the detectedRevision
	 */
	@Column(name="DETECTED_REVISION")
	public long getDetectedRevision() {
		return detectedRevision;
	}


	/**
	 * 检测版本号.
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

	public static final String[] TABLE_TYPES = new String[]{"","TABLE","VIEW","SYSTEM TABLE","GLOBAL TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM"};

	/**
	 * @return the tableType
	 */
	@Transient
	public String getTableType() {
		return TABLE_TYPES[type];
	}


	/**
	 * @param tableType the tableType to set
	 */
	public void setTableType(String tableType) {
		for (int i=0;i<TABLE_TYPES.length;i++) {
			if (TABLE_TYPES[i].equals(tableType)) {
				type = i;
			}
		}
	}


	/**
	 * 5.REMARKS String => explanatory comment on the table
	 * length:256
	 * @return the remarks
	 */
	@Column(name="REMARKS",length=256,nullable=true)
	public String getRemarks() {
		return remarks;
	}


	/**
	 * 5.REMARKS String => explanatory comment on the table
	 * length:256
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 * 6.TYPE_CAT String => the types catalog (may be null)
	 * length: 64
	 * @return the typeCatalog
	 */
	@Column(name="TYPE_CAT",length=64,nullable=true)
	public String getTypeCatalog() {
		return typeCatalog;
	}


	/**
	 * 6.TYPE_CAT String => the types catalog (may be null)
	 * length: 64
	 * @param typeCatalog the typeCatalog to set
	 */
	public void setTypeCatalog(String typeCatalog) {
		this.typeCatalog = typeCatalog;
	}


	/**
	 * 7.TYPE_SCHEM String => the types schema (may be null)
	 * length: 64
	 * @return the typeSchema
	 */
	@Column(name="TYPE_SCHEMA",length=64,nullable=true)
	public String getTypeSchema() {
		return typeSchema;
	}


	/**
	 * 7.TYPE_SCHEM String => the types schema (may be null)
	 * length: 64
	 * @param typeSchema the typeSchema to set
	 */
	public void setTypeSchema(String typeSchema) {
		this.typeSchema = typeSchema;
	}


	/**
	 * 8.TYPE_NAME String => type name (may be null)
	 * length: 64
	 * @return the typeName
	 */
	@Column(name="TYPE_NAME",length=64,nullable=true)
	public String getTypeName() {
		return typeName;
	}


	/**
	 * 8.TYPE_NAME String => type name (may be null)
	 * length: 64
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	/**
	 * 9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
	 * length: 64
	 * @return the selfReferencingColName
	 */
	@Column(name="SELF_REFERENCING_COL_NAME",length=64,nullable=true)
	public String getSelfReferencingColName() {
		return selfReferencingColName;
	}


	/**
	 * 9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
	 * length: 64
	 * @param selfReferencingColName the selfReferencingColName to set
	 */
	public void setSelfReferencingColName(String selfReferencingColName) {
		this.selfReferencingColName = selfReferencingColName;
	}


	/**
	 * 10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)
	 * length: 64
	 * @return the refGeneration
	 */
	@Column(name="REF_GENERATION",length=64,nullable=true)
	public String getRefGeneration() {
		return refGeneration;
	}


	/**
	 * 10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)
	 * length: 64
	 * @param refGeneration the refGeneration to set
	 */
	public void setRefGeneration(String refGeneration) {
		this.refGeneration = refGeneration;
	}


	/**
	 * 显示设置.
	 * 
	 * CFG_DISPLAY.
	 * @return the display
	 */
	@Column(name="CFG_DISPLAY")
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
	 * @return the name
	 */
	@Column(name="NAME",length=64)
	public String getName() {
		return name;
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
	 * @return the description
	 */
	@Column(name="DESCRIPTION",length=512)
	public String getDescription() {
		return description;
	}


	/**
	 * 描述.
	 * 
	 * DESCRIPTION length:512
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
