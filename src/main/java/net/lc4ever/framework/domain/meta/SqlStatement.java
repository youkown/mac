/*
 * Framework: net.lc4ever.framework.domain.meta.SqlStatement.java create by q-wang on May 16, 2013 11:07:08 PM
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

import org.hibernate.annotations.Index;


/**
 * 数据库查询语句描述.
 * 
 * TODO producer support
 * TODO add setters java doc, by copy getters
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_META_SQL_STATEMENT")
//@SequenceGenerator(name="SQL_STATEMENT",sequenceName="S5_META_SQL_STATEMENT")
public class SqlStatement implements BaseEntity<Long> {

	private Long id;

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQL_STATEMENT")
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
	 * <p>数据库查询语句.</p>
	 * 
	 * SQL_STATEMENT,length:4000, nullable:false
	 */
	private String sql; // sql statement (unique constraint)

	// language
	/**
	 * 是否支持PreparedStatement.
	 * 
	 * PREPARED_SUPPORT default:false
	 */
	private boolean prepared; // is prepared statement

	/**
	 * <p>是否为DDL语句.</p>
	 * 
	 * IS_DDL default:false
	 */
	private boolean ddl; // is ddl statement

	/**
	 * <p>操作类型.</p>
	 * 
	 * OPERATION_TYPE 1:SELECT; 2:INSERT; 4:UPDATE; 8:DELETE; 512:CREATE; 1024:DROP; 2048:ALTER
	 */
	private int operation; // create,drop,alter, insert,update,delete,select

	/**
	 * <p>相关表数量.</p>
	 * 
	 * TABLE_COUNT default:1
	 */
	private short tableCount; // default 1
	// transactional
	/**
	 * <p>默认事务支持.</p>
	 * 
	 * DEFAULT_PROPAGATION
	 */
	private int defaultPropagation; // default propagation

	/**
	 * <p>默认事务隔离等级.</p>
	 * 
	 * DEFAULT_ISOLATION
	 */
	private int defaultIsolation; // default isolation

	/**
	 * <p>支持的事务类型.</p>
	 * 
	 * SUPPORT_PROPAGATIONS
	 */
	private int supportPropagations;

	/**
	 * <p>支持的隔离等级.</p>
	 * 
	 * SUPPORT_ISOLATIONS
	 */
	private int supportIsolations;

	/**
	 * <p>是否为只读语句.</p>
	 * 
	 * IS_READONLY default:true
	 */
	private boolean readOnly;

	/**
	 * <p>超时时间.</p>
	 * 
	 * EXECUTE_TIMEOUT default:-1
	 */
	private int timeout; // no limition if 0 or -1,

	/**
	 * <p>事务名称.</p>
	 * 
	 * DEFAULT_TRANSACTION_NAME
	 */
	private String defaultTransactionName;
	// resultSet
	/**
	 * <p>是否为单一结果.</p>
	 * 
	 * IS_UNIQUE_RESULT default:false
	 */
	private boolean uniqueResult; // true only 1 result(select) or insert,delete,update only for 1 row.

	/**
	 * <p>结果是否可能为空.</p>
	 * 
	 * MAYBE_EMPTY_RESULT default:true
	 */
	private boolean emptyResult; // no result

	/**
	 * <p>结果集列数.</p>
	 * 
	 * RESULT_SET_COLUMN_COUNT default:0(not support or auto detected)
	 */
	private int resultSetColumnCount; // 0:not support or auto detected

	/**
	 * <p>最大结果数.</p>
	 * 
	 * DEFAULT_MAX_RESULTS
	 */
	private int defaultMaxResults; // -1: inherit, 0: no limition
	// paramter: only prepared is true

	/**
	 * <p>是否带有参数.</p>
	 * 
	 * only used on prepared = true
	 * HAS_PARAMETER default:false
	 */
	private boolean hasParameter;

	/**
	 * <p>参数个数.</p>
	 * 
	 * only used on hasParameter = true
	 * PARAMETER_COUNT default:0 autodected
	 */
	private int parameterCount; // 0: not support(prepared=false) or none(hasParameter=false) or auto detected(hasParameter=true)
	// exception
	/**
	 * <p>是否检查返回结果.</p>
	 * 
	 * 注意只检查结果条目数.
	 * CHECK_REQUIRED
	 */
	private boolean checkRequired; // unqiueResult,nonResult

	/**
	 * <p>检查失败时，返回的错误类型.</p>
	 * 
	 * only used on checkRequired = true
	 * KEY_EXCEPTION length:256
	 */
	private String exception; // on checkResult is true
	// view

	/**
	 * <p>显示配置.</p>
	 * 
	 * CFG_DISPLAY
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
	 * <p>数据库查询语句.</p>
	 * 
	 * SQL,length:4000, nullable:false
	 * @return the sql
	 */
	@Column(name="SQL_STATEMENT",length=4000,nullable=false)
	@Index(name="IDX_SQL_STATEMENT")
	public String getSql() {
		return sql;
	}


	/**
	 * 是否支持PreparedStatement.
	 * 
	 * PREPARED_SUPPORT default:false
	 * @return the prepared
	 */
	@Column(name="PREPARED_SUPPORT")
	public boolean isPrepared() {
		return prepared;
	}


	/**
	 * <p>是否为DDL语句.</p>
	 * 
	 * IS_DDL default:false
	 * @return the ddl
	 */
	@Column(name="IS_DDL")
	public boolean isDdl() {
		return ddl;
	}


	/**
	 * <p>操作类型.</p>
	 * 
	 * OPERATION_TYPE 1:SELECT; 2:INSERT; 4:UPDATE; 8:DELETE; 512:CREATE; 1024:DROP; 2048:ALTER
	 * @return the operation
	 */
	@Column(name="OPERATION_TYPE")
	public int getOperation() {
		return operation;
	}


	/**
	 * <p>相关表数量.</p>
	 * 
	 * TABLE_COUNT default:1
	 * @return the tableCount
	 */
	@Column(name="TABLE_COUNT")
	public short getTableCount() {
		return tableCount;
	}


	/**
	 * <p>默认事务支持.</p>
	 * 
	 * DEFAULT_PROPAGATION
	 * @return the defaultPropagation
	 */
	@Column(name="DEFAULT_PROPAGATION")
	public int getDefaultPropagation() {
		return defaultPropagation;
	}


	/**
	 * <p>默认事务隔离等级.</p>
	 * 
	 * DEFAULT_ISOLATION
	 * @return the defaultIsolation
	 */
	@Column(name="DEFAULT_ISOLATION")
	public int getDefaultIsolation() {
		return defaultIsolation;
	}


	/**
	 * <p>支持的事务类型.</p>
	 * 
	 * SUPPORT_PROPAGATIONS
	 * @return the supportPropagations
	 */
	@Column(name="SUPPORT_PROPAGATIONS")
	public int getSupportPropagations() {
		return supportPropagations;
	}


	/**
	 * <p>支持的隔离等级.</p>
	 * 
	 * SUPPORT_ISOLATIONS
	 * @return the supportIsolations
	 */
	@Column(name="SUPPORT_ISOLATIONS")
	public int getSupportIsolations() {
		return supportIsolations;
	}


	/**
	 * <p>是否为只读语句.</p>
	 * 
	 * IS_READONLY default:true
	 * @return the readOnly
	 */
	@Column(name="IS_READONLY")
	public boolean isReadOnly() {
		return readOnly;
	}


	/**
	 * <p>超时时间.</p>
	 * 
	 * EXECUTE_TIMEOUT default:-1
	 * @return the timeout
	 */
	@Column(name="EXECUTE_TIMEOUT")
	public int getTimeout() {
		return timeout;
	}


	/**
	 * <p>事务名称.</p>
	 * 
	 * DEFAULT_TRANSACTION_NAME
	 * @return the defaultTransactionName
	 */
	@Column(name="DEFAULT_TRANSACTION_NAME")
	public String getDefaultTransactionName() {
		return defaultTransactionName;
	}


	/**
	 * <p>是否为单一结果.</p>
	 * 
	 * IS_UNIQUE_RESULT default:false
	 * @return the uniqueResult
	 */
	@Column(name="IS_UNIQUE_RESULT")
	public boolean isUniqueResult() {
		return uniqueResult;
	}


	/**
	 * <p>结果是否可能为空.</p>
	 * 
	 * MAYBE_EMPTY_RESULT default:true
	 * @return the emptyResult
	 */
	@Column(name="MAYBE_EMPTY_RESULT")
	public boolean isEmptyResult() {
		return emptyResult;
	}


	/**
	 * <p>结果集列数.</p>
	 * 
	 * RESULT_SET_COLUMN_COUNT default:0(not support or auto detected)
	 * @return the resultSetColumnCount
	 */
	@Column(name="RESULT_SET_COLUMN_COUNT")
	public int getResultSetColumnCount() {
		return resultSetColumnCount;
	}


	/**
	 * <p>最大结果数.</p>
	 * 
	 * DEFAULT_MAX_RESULTS
	 * @return the defaultMaxResults
	 */
	@Column(name="DEFAULT_MAX_RESULTS")
	public int getDefaultMaxResults() {
		return defaultMaxResults;
	}


	/**
	 * <p>是否带有参数.</p>
	 * 
	 * only used on prepared = true
	 * HAS_PARAMETER default:false
	 * @return the hasParameter
	 */
	@Column(name="HAS_PARAMETER")
	public boolean isHasParameter() {
		return hasParameter;
	}


	/**
	 * <p>参数个数.</p>
	 * 
	 * only used on hasParameter = true
	 * PARAMETER_COUNT default:0 autodected
	 * @return the parameterCount
	 */
	@Column(name="PARAMETER_COUNT")
	public int getParameterCount() {
		return parameterCount;
	}


	/**
	 * <p>是否检查返回结果.</p>
	 * 
	 * 注意只检查结果条目数.
	 * CHECK_REQUIRED
	 * @return the checkRequired
	 */
	@Column(name="CHECK_REQUIRED")
	public boolean isCheckRequired() {
		return checkRequired;
	}


	/**
	 * <p>检查失败时，返回的错误类型.</p>
	 * 
	 * only used on checkRequired = true
	 * KEY_EXCEPTION length:256
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}


	/**
	 * <p>显示配置.</p>
	 * 
	 * CFG_DISPLAY
	 * @return the display
	 */
	public Long getDisplay() {
		return display;
	}


	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}


	/**
	 * @param prepared the prepared to set
	 */
	public void setPrepared(boolean prepared) {
		this.prepared = prepared;
	}


	/**
	 * @param ddl the ddl to set
	 */
	public void setDdl(boolean ddl) {
		this.ddl = ddl;
	}


	/**
	 * @param operation the operation to set
	 */
	public void setOperation(int operation) {
		this.operation = operation;
	}


	/**
	 * @param tableCount the tableCount to set
	 */
	public void setTableCount(short tableCount) {
		this.tableCount = tableCount;
	}


	/**
	 * @param defaultPropagation the defaultPropagation to set
	 */
	public void setDefaultPropagation(int defaultPropagation) {
		this.defaultPropagation = defaultPropagation;
	}


	/**
	 * @param defaultIsolation the defaultIsolation to set
	 */
	public void setDefaultIsolation(int defaultIsolation) {
		this.defaultIsolation = defaultIsolation;
	}


	/**
	 * @param supportPropagations the supportPropagations to set
	 */
	public void setSupportPropagations(int supportPropagations) {
		this.supportPropagations = supportPropagations;
	}


	/**
	 * @param supportIsolations the supportIsolations to set
	 */
	public void setSupportIsolations(int supportIsolations) {
		this.supportIsolations = supportIsolations;
	}


	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}


	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}


	/**
	 * @param defaultTransactionName the defaultTransactionName to set
	 */
	public void setDefaultTransactionName(String defaultTransactionName) {
		this.defaultTransactionName = defaultTransactionName;
	}


	/**
	 * @param uniqueResult the uniqueResult to set
	 */
	public void setUniqueResult(boolean uniqueResult) {
		this.uniqueResult = uniqueResult;
	}


	/**
	 * @param emptyResult the emptyResult to set
	 */
	public void setEmptyResult(boolean emptyResult) {
		this.emptyResult = emptyResult;
	}


	/**
	 * @param resultSetColumnCount the resultSetColumnCount to set
	 */
	public void setResultSetColumnCount(int resultSetColumnCount) {
		this.resultSetColumnCount = resultSetColumnCount;
	}


	/**
	 * @param defaultMaxResults the defaultMaxResults to set
	 */
	public void setDefaultMaxResults(int defaultMaxResults) {
		this.defaultMaxResults = defaultMaxResults;
	}


	/**
	 * @param hasParameter the hasParameter to set
	 */
	public void setHasParameter(boolean hasParameter) {
		this.hasParameter = hasParameter;
	}


	/**
	 * @param parameterCount the parameterCount to set
	 */
	public void setParameterCount(int parameterCount) {
		this.parameterCount = parameterCount;
	}


	/**
	 * @param checkRequired the checkRequired to set
	 */
	public void setCheckRequired(boolean checkRequired) {
		this.checkRequired = checkRequired;
	}


	/**
	 * @param exception the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
	}


	/**
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
	public String getName() {
		return name;
	}


	/**
	 * 名称.
	 * 
	 * NAME length:64
	 * @param name the name to set
	 */
	@Column(name="NAME",length=64)
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
