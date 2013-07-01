/*
 * Framework: net.lc4ever.framework.database.meta.DatabaseMetadata.java create by q-wang on May 16, 2013 3:26:56 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.database.meta;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public class DatabaseMetadata {

	private boolean autoCommit;
	private String catalog;
	private Properties clientInfo;
	private int holdability;
	private int networkTimeout;
	private String schema;
	private int transactionIsolation;
	private Map<String, Class<?>> typeMap;

	public DatabaseMetadata(Connection connection) throws SQLException {
		extra(connection);
	}

	private void extra(Connection connection) throws SQLException {
		connection.getCatalog();

		autoCommit = connection.getAutoCommit();
		catalog = connection.getCatalog();
		clientInfo = connection.getClientInfo(); // since 1.6
		holdability = connection.getHoldability(); // since 1.4
		//		networkTimeout = connection.getNetworkTimeout(); // since 1.7
		//		schema = connection.getSchema(); // since 1.7
		transactionIsolation = connection.getTransactionIsolation();
		typeMap = connection.getTypeMap(); // since 1.2

		extraDatabaseMetadata(connection.getMetaData());
	}

	private List<String> catalogs = new ArrayList<String>();
	private String catalogSeparator;
	private String catalogTerm;

	public class ClientInfoProperty implements Serializable {
		private String name;
		private int maxLength;
		private String defaultValue;
		private String description;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the maxLength
		 */
		public int getMaxLength() {
			return maxLength;
		}

		/**
		 * @return the defaultValue
		 */
		public String getDefaultValue() {
			return defaultValue;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ClientInfoProperty [name=").append(name).append(", maxLength=").append(maxLength).append(", defaultValue=").append(defaultValue).append(", description=").append(description).append("]");
			return builder.toString();
		}
	}
	private List<ClientInfoProperty> clientInfoProperties = new ArrayList<ClientInfoProperty>();

	private int databaseMajorVersion;
	private int databaseMinorVersion;
	private String databaseProductName;
	private String databaseProductVersion;
	private int defaultTransactionIsolation;

	private int driverMajorVersion;
	private int driverMinorVersion;
	private String driverName;
	private String driverVersion;

	private String extraNameCharacters;
	private String identifierQuoteString;

	private int jdbcMajorVersion;
	private int jdbcMinorVersion;

	public class Maximum implements Serializable {
		private int maxBinaryLiteralLength;
		private int maxCatalogNameLength;
		private int maxColumnNameLength;
		private int maxColumnsInGroupBy;
		private int maxColumnsInIndex;
		private int maxColumnsInOrderBy;
		private int maxColumnsInSelect;
		private int maxColumnsInTable;
		private int maxConnections;
		private int maxCursorNameLength;
		private int maxIndexLength;
		private int maxProcedureNameLength;
		private int maxRowSize;
		private int maxSchemaNameLength;
		private int maxStatementLength;
		private int maxStatements;
		private int maxTableNameLength;
		private int maxTablesInSelect;
		private int maxUserNameLength;

		/**
		 * @return the maxBinaryLiteralLength
		 */
		public int getMaxBinaryLiteralLength() {
			return maxBinaryLiteralLength;
		}

		/**
		 * @return the maxCatalogNameLength
		 */
		public int getMaxCatalogNameLength() {
			return maxCatalogNameLength;
		}

		/**
		 * @return the maxColumnNameLength
		 */
		public int getMaxColumnNameLength() {
			return maxColumnNameLength;
		}

		/**
		 * @return the maxColumnsInGroupBy
		 */
		public int getMaxColumnsInGroupBy() {
			return maxColumnsInGroupBy;
		}

		/**
		 * @return the maxColumnsInIndex
		 */
		public int getMaxColumnsInIndex() {
			return maxColumnsInIndex;
		}

		/**
		 * @return the maxColumnsInOrderBy
		 */
		public int getMaxColumnsInOrderBy() {
			return maxColumnsInOrderBy;
		}

		/**
		 * @return the maxColumnsInSelect
		 */
		public int getMaxColumnsInSelect() {
			return maxColumnsInSelect;
		}

		/**
		 * @return the maxColumnsInTable
		 */
		public int getMaxColumnsInTable() {
			return maxColumnsInTable;
		}

		/**
		 * @return the maxConnections
		 */
		public int getMaxConnections() {
			return maxConnections;
		}

		/**
		 * @return the maxCursorNameLength
		 */
		public int getMaxCursorNameLength() {
			return maxCursorNameLength;
		}

		/**
		 * @return the maxIndexLength
		 */
		public int getMaxIndexLength() {
			return maxIndexLength;
		}

		/**
		 * @return the maxProcedureNameLength
		 */
		public int getMaxProcedureNameLength() {
			return maxProcedureNameLength;
		}

		/**
		 * @return the maxRowSize
		 */
		public int getMaxRowSize() {
			return maxRowSize;
		}

		/**
		 * @return the maxSchemaNameLength
		 */
		public int getMaxSchemaNameLength() {
			return maxSchemaNameLength;
		}

		/**
		 * @return the maxStatementLength
		 */
		public int getMaxStatementLength() {
			return maxStatementLength;
		}

		/**
		 * @return the maxStatements
		 */
		public int getMaxStatements() {
			return maxStatements;
		}

		/**
		 * @return the maxTableNameLength
		 */
		public int getMaxTableNameLength() {
			return maxTableNameLength;
		}

		/**
		 * @return the maxTablesInSelect
		 */
		public int getMaxTablesInSelect() {
			return maxTablesInSelect;
		}

		/**
		 * @return the maxUserNameLength
		 */
		public int getMaxUserNameLength() {
			return maxUserNameLength;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Maximum [maxBinaryLiteralLength=").append(maxBinaryLiteralLength).append(", maxCatalogNameLength=").append(maxCatalogNameLength).append(", maxColumnNameLength=").append(maxColumnNameLength)
			.append(", maxColumnsInGroupBy=").append(maxColumnsInGroupBy).append(", maxColumnsInIndex=").append(maxColumnsInIndex).append(", maxColumnsInOrderBy=").append(maxColumnsInOrderBy)
			.append(", maxColumnsInSelect=").append(maxColumnsInSelect).append(", maxColumnsInTable=").append(maxColumnsInTable).append(", maxConnections=").append(maxConnections).append(", maxCursorNameLength=")
			.append(maxCursorNameLength).append(", maxIndexLength=").append(maxIndexLength).append(", maxProcedureNameLength=").append(maxProcedureNameLength).append(", maxRowSize=").append(maxRowSize)
			.append(", maxSchemaNameLength=").append(maxSchemaNameLength).append(", maxStatementLength=").append(maxStatementLength).append(", maxStatements=").append(maxStatements).append(", maxTableNameLength=")
			.append(maxTableNameLength).append(", maxTablesInSelect=").append(maxTablesInSelect).append(", maxUserNameLength=").append(maxUserNameLength).append("]");
			return builder.toString();
		}
	}
	private Maximum maximum = new Maximum();
	private String numericFunctions;
	private String procedureTerm;
	private int resultSetHoldability;
	private String schemaTerm;
	private String searchStringEscape;
	private String sqlKeywords;
	private int sqlStateType;
	private String stringFunctions;
	private String systemFunctions;
	private String timeDataFunctions;
	private String url;
	private String username;
	private RowIdLifetime rowIdLifetime;

	private void extraMaximum(DatabaseMetaData metaData) throws SQLException {
		maximum.maxBinaryLiteralLength = metaData.getMaxBinaryLiteralLength();
		maximum.maxCatalogNameLength = metaData.getMaxCatalogNameLength();
		maximum.maxColumnNameLength = metaData.getMaxColumnNameLength();
		maximum.maxColumnsInGroupBy = metaData.getMaxColumnsInGroupBy();
		maximum.maxColumnsInIndex = metaData.getMaxColumnsInIndex();
		maximum.maxColumnsInOrderBy = metaData.getMaxColumnsInOrderBy();
		maximum.maxColumnsInSelect = metaData.getMaxColumnsInSelect();
		maximum.maxColumnsInTable = metaData.getMaxColumnsInTable();
		maximum.maxConnections = metaData.getMaxConnections();
		maximum.maxCursorNameLength = metaData.getMaxCursorNameLength();
		maximum.maxIndexLength = metaData.getMaxIndexLength();
		maximum.maxProcedureNameLength = metaData.getMaxProcedureNameLength();
		maximum.maxRowSize = metaData.getMaxRowSize();
		maximum.maxSchemaNameLength = metaData.getMaxSchemaNameLength();
		maximum.maxStatementLength = metaData.getMaxStatementLength();
		maximum.maxStatements = metaData.getMaxStatements();
		maximum.maxTableNameLength = metaData.getMaxTableNameLength();
		maximum.maxTablesInSelect = metaData.getMaxTablesInSelect();
		maximum.maxUserNameLength = metaData.getMaxUserNameLength();
	}

	private void extraDatabaseMetadata(DatabaseMetaData metaData) throws SQLException {
		ResultSet catalogs = null;
		try {
			catalogs = metaData.getCatalogs();
			while (catalogs.next()) {
				this.catalogs.add(catalogs.getString("TABLE_CAT"));
			}
		} finally {
			if (catalogs!=null&&!catalogs.isClosed()) {
				try {
					catalogs.close();
				} catch (SQLException sqle) {}
			}
		}
		catalogSeparator = metaData.getCatalogSeparator();
		catalogTerm = metaData.getCatalogTerm();

		ResultSet clientInfoProperties = null;
		try { // 1.6
			clientInfoProperties = metaData.getClientInfoProperties();
			while (clientInfoProperties.next()) {
				ClientInfoProperty property = new ClientInfoProperty();
				property.name = clientInfoProperties.getString("NAME");
				property.maxLength = clientInfoProperties.getInt("MAX_LEN");
				property.defaultValue = clientInfoProperties.getString("DEFAULT_VALUE");
				property.description = clientInfoProperties.getString("DESCRIPTION");
			}
		} finally {
			if (clientInfoProperties!=null&&!clientInfoProperties.isClosed()) {
				try {
					clientInfoProperties.close();
				} catch (SQLException sqle) {}
			}
		}
		databaseMajorVersion = metaData.getDatabaseMajorVersion(); // 1.4
		databaseMinorVersion = metaData.getDatabaseMinorVersion(); // 1.4
		databaseProductVersion = metaData.getDatabaseProductVersion();
		databaseProductName = metaData.getDatabaseProductName();
		defaultTransactionIsolation = metaData.getDefaultTransactionIsolation();
		driverMajorVersion = metaData.getDriverMajorVersion();
		driverMinorVersion = metaData.getDriverMinorVersion();
		driverName = metaData.getDriverName();
		driverVersion = metaData.getDriverVersion();
		extraNameCharacters = metaData.getExtraNameCharacters();
		identifierQuoteString = metaData.getIdentifierQuoteString();
		jdbcMajorVersion = metaData.getJDBCMajorVersion(); // 1.4
		jdbcMinorVersion = metaData.getJDBCMinorVersion(); // 1.4

		extraMaximum(metaData);


		procedureTerm = metaData.getProcedureTerm();
		resultSetHoldability = metaData.getResultSetHoldability(); // 1.4



		schemaTerm = metaData.getSchemaTerm();
		searchStringEscape = metaData.getSearchStringEscape();
		sqlKeywords = metaData.getSQLKeywords();
		sqlStateType = metaData.getSQLStateType(); // 1.4

		numericFunctions = metaData.getNumericFunctions();
		stringFunctions = metaData.getStringFunctions();
		systemFunctions = metaData.getSystemFunctions();
		timeDataFunctions = metaData.getTimeDateFunctions();

		url = metaData.getURL();
		username = metaData.getUserName();

		rowIdLifetime = metaData.getRowIdLifetime(); // 1.6

		ResultSet schemas = null;
		try {
			schemas = metaData.getSchemas();
			while (schemas.next()) {
				Schema schema = new Schema();
				schema.schema = schemas.getString("TABLE_SCHEM");
				//				schema.catalog = schemas.getString("TABLE_CATALOG");
				this.schemas.add(schema);
			}
		} finally {
			if (schemas!=null&&!schemas.isClosed()) {
				try {
					schemas.close();
				} catch (SQLException sqle) {}
			}
		}
		ResultSet tableTypes = null;
		try {
			tableTypes = metaData.getTableTypes();
			while (tableTypes.next()) {
				this.tableTypes.add(tableTypes.getString("TABLE_TYPE"));
			}
		} finally {
			if (tableTypes!=null&&!tableTypes.isClosed()) {
				try {
					tableTypes.close();
				} catch (SQLException sqle) {}
			}
		}
		ResultSet typeInfos = null;
		try {
			typeInfos = metaData.getTypeInfo();
			while (typeInfos.next()) {
				TypeInfo typeInfo = new TypeInfo();
				typeInfo.typeName = typeInfos.getString("TYPE_NAME");
				typeInfo.dataType = typeInfos.getInt("DATA_TYPE");
				typeInfo.precision = typeInfos.getInt("PRECISION");
				typeInfo.literalPrefix = typeInfos.getString("LITERAL_PREFIX");
				typeInfo.literalSuffix = typeInfos.getString("LITERAL_SUFFIX");
				typeInfo.createParams = typeInfos.getString("CREATE_PARAMS");
				typeInfo.nullable = typeInfos.getShort("NULLABLE");
				typeInfo.caseSensitive = typeInfos.getBoolean("CASE_SENSITIVE");
				typeInfo.searchable = typeInfos.getShort("SEARCHABLE");
				typeInfo.unsignedAttribute = typeInfos.getBoolean("UNSIGNED_ATTRIBUTE");
				//				typeInfo.fixedPrecScale = resultSet.getBoolean("FIXED_PRE_SCALE");
				typeInfo.autoIncrement = typeInfos.getBoolean("AUTO_INCREMENT");
				typeInfo.localTypeName = typeInfos.getString("LOCAL_TYPE_NAME");
				typeInfo.minimumScale = typeInfos.getShort("MINIMUM_SCALE");
				typeInfo.maximumScale = typeInfos.getShort("MAXIMUM_SCALE");
				typeInfo.sqlDataType = typeInfos.getInt("SQL_DATA_TYPE");
				typeInfo.sqlDatetimeSub = typeInfos.getInt("SQL_DATETIME_SUB");
				typeInfo.numPrecRadix = typeInfos.getInt("NUM_PREC_RADIX");
				this.typeInfo.add(typeInfo);
			}
		} finally {
			if (typeInfos!=null&&!typeInfos.isClosed()) {
				try {
					typeInfos.close();
				} catch (SQLException sqle) {}
			}
		}
		
	}
	private List<String> tableTypes = new ArrayList<String>();
	private List<Schema> schemas = new ArrayList<Schema>();

	public class Schema implements Serializable {
		private String schema;
		private String catalog;

		/**
		 * @return the schema
		 */
		public String getSchema() {
			return schema;
		}

		/**
		 * @return the catalog
		 */
		public String getCatalog() {
			return catalog;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Schema [schema=").append(schema).append(", catalog=").append(catalog).append("]");
			return builder.toString();
		}

	}
	public class TypeInfo implements Serializable {
		private String typeName;
		private int dataType;
		private int precision;
		private String literalPrefix;
		private String literalSuffix;
		private String createParams;
		private short nullable;
		private boolean caseSensitive;
		private short searchable;
		private boolean unsignedAttribute;
		private boolean fixedPrecScale;
		private boolean autoIncrement;
		private String localTypeName;
		private short minimumScale;
		private short maximumScale;
		private int sqlDataType;
		private int sqlDatetimeSub;
		private int numPrecRadix;

		/**
		 * @return the typeName
		 */
		public String getTypeName() {
			return typeName;
		}

		/**
		 * @return the dataType
		 */
		public int getDataType() {
			return dataType;
		}

		/**
		 * @return the precision
		 */
		public int getPrecision() {
			return precision;
		}

		/**
		 * @return the literalPrefix
		 */
		public String getLiteralPrefix() {
			return literalPrefix;
		}

		/**
		 * @return the literalSuffix
		 */
		public String getLiteralSuffix() {
			return literalSuffix;
		}

		/**
		 * @return the createParams
		 */
		public String getCreateParams() {
			return createParams;
		}

		/**
		 * @return the nullable
		 */
		public short getNullable() {
			return nullable;
		}

		/**
		 * @return the caseSensitive
		 */
		public boolean isCaseSensitive() {
			return caseSensitive;
		}

		/**
		 * @return the searchable
		 */
		public short getSearchable() {
			return searchable;
		}

		/**
		 * @return the unsignedAttribute
		 */
		public boolean isUnsignedAttribute() {
			return unsignedAttribute;
		}

		/**
		 * @return the fixedPrecScale
		 */
		public boolean isFixedPrecScale() {
			return fixedPrecScale;
		}

		/**
		 * @return the autoIncrement
		 */
		public boolean isAutoIncrement() {
			return autoIncrement;
		}

		/**
		 * @return the localTypeName
		 */
		public String getLocalTypeName() {
			return localTypeName;
		}

		/**
		 * @return the minimumScale
		 */
		public short getMinimumScale() {
			return minimumScale;
		}

		/**
		 * @return the maximumScale
		 */
		public short getMaximumScale() {
			return maximumScale;
		}

		/**
		 * @return the sqlDataType
		 */
		public int getSqlDataType() {
			return sqlDataType;
		}

		/**
		 * @return the sqlDatetimeSub
		 */
		public int getSqlDatetimeSub() {
			return sqlDatetimeSub;
		}

		/**
		 * @return the numPrecRadix
		 */
		public int getNumPrecRadix() {
			return numPrecRadix;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("TypeInfo [typeName=").append(typeName).append(", dataType=").append(dataType).append(", precision=").append(precision).append(", literalPrefix=").append(literalPrefix).append(", literalSuffix=")
			.append(literalSuffix).append(", createParams=").append(createParams).append(", nullable=").append(nullable).append(", caseSensitive=").append(caseSensitive).append(", searchable=").append(searchable)
			.append(", unsignedAttribute=").append(unsignedAttribute).append(", fixedPrecScale=").append(fixedPrecScale).append(", autoIncrement=").append(autoIncrement).append(", localTypeName=")
			.append(localTypeName).append(", minimumScale=").append(minimumScale).append(", maximumScale=").append(maximumScale).append(", sqlDataType=").append(sqlDataType).append(", sqlDatetimeSub=")
			.append(sqlDatetimeSub).append(", numPrecRadix=").append(numPrecRadix).append("]");
			return builder.toString();
		}

	}
	private List<TypeInfo> typeInfo = new ArrayList<TypeInfo>();


	/**
	 * @return the autoCommit
	 */
	public boolean isAutoCommit() {
		return autoCommit;
	}


	/**
	 * @return the catalog
	 */
	public String getCatalog() {
		return catalog;
	}


	/**
	 * @return the clientInfo
	 */
	public Properties getClientInfo() {
		return clientInfo;
	}


	/**
	 * @return the holdability
	 */
	public int getHoldability() {
		return holdability;
	}


	/**
	 * @return the networkTimeout
	 */
	public int getNetworkTimeout() {
		return networkTimeout;
	}


	/**
	 * @return the schema
	 */
	public String getSchema() {
		return schema;
	}


	/**
	 * @return the transactionIsolation
	 */
	public int getTransactionIsolation() {
		return transactionIsolation;
	}


	/**
	 * @return the typeMap
	 */
	public Map<String, Class<?>> getTypeMap() {
		return typeMap;
	}


	/**
	 * @return the catalogs
	 */
	public List<String> getCatalogs() {
		return catalogs;
	}


	/**
	 * @return the catalogSeparator
	 */
	public String getCatalogSeparator() {
		return catalogSeparator;
	}


	/**
	 * @return the catalogTerm
	 */
	public String getCatalogTerm() {
		return catalogTerm;
	}


	/**
	 * @return the clientInfoProperties
	 */
	public List<ClientInfoProperty> getClientInfoProperties() {
		return clientInfoProperties;
	}


	/**
	 * @return the databaseMajorVersion
	 */
	public int getDatabaseMajorVersion() {
		return databaseMajorVersion;
	}


	/**
	 * @return the databaseMinorVersion
	 */
	public int getDatabaseMinorVersion() {
		return databaseMinorVersion;
	}


	/**
	 * @return the databaseProductName
	 */
	public String getDatabaseProductName() {
		return databaseProductName;
	}


	/**
	 * @return the databaseProductVersion
	 */
	public String getDatabaseProductVersion() {
		return databaseProductVersion;
	}


	/**
	 * @return the defaultTransactionIsolation
	 */
	public int getDefaultTransactionIsolation() {
		return defaultTransactionIsolation;
	}


	/**
	 * @return the driverMajorVersion
	 */
	public int getDriverMajorVersion() {
		return driverMajorVersion;
	}


	/**
	 * @return the driverMinorVersion
	 */
	public int getDriverMinorVersion() {
		return driverMinorVersion;
	}


	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}


	/**
	 * @return the driverVersion
	 */
	public String getDriverVersion() {
		return driverVersion;
	}


	/**
	 * @return the extraNameCharacters
	 */
	public String getExtraNameCharacters() {
		return extraNameCharacters;
	}


	/**
	 * @return the identifierQuoteString
	 */
	public String getIdentifierQuoteString() {
		return identifierQuoteString;
	}


	/**
	 * @return the jdbcMajorVersion
	 */
	public int getJdbcMajorVersion() {
		return jdbcMajorVersion;
	}


	/**
	 * @return the jdbcMinorVersion
	 */
	public int getJdbcMinorVersion() {
		return jdbcMinorVersion;
	}


	/**
	 * @return the maximum
	 */
	public Maximum getMaximum() {
		return maximum;
	}


	/**
	 * @return the numericFunctions
	 */
	public String getNumericFunctions() {
		return numericFunctions;
	}


	/**
	 * @return the procedureTerm
	 */
	public String getProcedureTerm() {
		return procedureTerm;
	}


	/**
	 * @return the resultSetHoldability
	 */
	public int getResultSetHoldability() {
		return resultSetHoldability;
	}


	/**
	 * @return the schemaTerm
	 */
	public String getSchemaTerm() {
		return schemaTerm;
	}


	/**
	 * @return the searchStringEscape
	 */
	public String getSearchStringEscape() {
		return searchStringEscape;
	}


	/**
	 * @return the sqlKeywords
	 */
	public String getSqlKeywords() {
		return sqlKeywords;
	}


	/**
	 * @return the sqlStateType
	 */
	public int getSqlStateType() {
		return sqlStateType;
	}


	/**
	 * @return the stringFunctions
	 */
	public String getStringFunctions() {
		return stringFunctions;
	}


	/**
	 * @return the systemFunctions
	 */
	public String getSystemFunctions() {
		return systemFunctions;
	}


	/**
	 * @return the timeDataFunctions
	 */
	public String getTimeDataFunctions() {
		return timeDataFunctions;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @return the rowIdLifetime
	 */
	public RowIdLifetime getRowIdLifetime() {
		return rowIdLifetime;
	}


	/**
	 * @return the tableTypes
	 */
	public List<String> getTableTypes() {
		return tableTypes;
	}


	/**
	 * @return the schemas
	 */
	public List<Schema> getSchemas() {
		return schemas;
	}


	/**
	 * @return the typeInfo
	 */
	public List<TypeInfo> getTypeInfo() {
		return typeInfo;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}


}
