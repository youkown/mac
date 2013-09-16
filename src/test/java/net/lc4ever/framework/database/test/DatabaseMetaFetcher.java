/*
 * Framework: net.lc4ever.framework.database.test.DatabaseMetaFetcher.java create by q-wang on May 16, 2013 1:06:40 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.database.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.lc4ever.framework.database.meta.DatabaseMetadata;
import oracle.jdbc.driver.OracleDriver;
//import oracle.jdbc.driver.OracleDriver;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public class DatabaseMetaFetcher {

	private Connection connection;

	public static void main(String[] args) throws Exception {
		System.out.println(OracleDriver.BUILD_DATE);
		System.out.println(com.mysql.jdbc.Driver.class);

		DatabaseMetaFetcher fetcher = new DatabaseMetaFetcher();

		Connection connection = null;

		try {
			connection = fetcher.getConnection();
			DatabaseMetadata metadata = new DatabaseMetadata(connection);
			System.out.println(metadata);

			fetcher.printDatabaseMeta();

			fetcher.printDriverInfo();

			fetcher.printTables();
		} finally {
			if (connection!=null&&connection.isClosed()) {
				connection.close();
			}
		}
	}

	public void printTables() throws SQLException {
		ResultSet tables = null;
		try {
			tables =	connection.getMetaData().getTables(null, null, "", new String[]{"TABLE"});
			while (tables.next()) {
				String catalog = tables.getString("TABLE_CAT");
				String schema = tables.getString("TABLE_SCHEM");
				String table = tables.getString("TABLE_NAME");
				String type = tables.getString("TABLE_TYPE");
				String remarks = tables.getString("REMARKS");
				String typeCatalog = tables.getString("TYPE_CAT");
				String typeSchema = tables.getString("TYPE_SCHEM");
				String typeName = tables.getString("TYPE_NAME");
				String selfReferencingColName = tables.getString("SELF_REFERENCING_COL_NAME");
				String refGeneration = tables.getString("REF_GENERATION");

				System.out.println("catalog\t:"+catalog);
				System.out.println("schema\t:"+schema);
				System.out.println("table\t:"+table);
				System.out.println("type\t:"+type);
				System.out.println("remarks\t:"+remarks);
				System.out.println("typeCatalog\t:"+typeCatalog);
				System.out.println("typeSchema\t:"+typeSchema);
				System.out.println("typeName\t:"+typeName);
				System.out.println("selfReferencingColName\t:"+selfReferencingColName);
				System.out.println("refGeneration\t:"+refGeneration);

				System.out.println();
			}
		} finally {
			if (tables!=null&&!tables.isClosed()) {
				tables.close();
			}
		}
	}

	public void printDriverInfo() throws SQLException {
		Driver driver = DriverManager.getDriver("jdbc:oracle:thin:@localhost:1521:DEV");
		System.out.println(driver.getClass());

		//		Class<? extends Driver> clazz = driver.getClass();
		//		Method[] methods = clazz.getMethods();
	}


	public void printResultSet(ResultSet resultSet) throws SQLException {
		resultSet.getMetaData();
		while (resultSet.next()) {

		}
	}

	public void getResultSetMeta(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metaData = resultSet.getMetaData();
		int count = metaData.getColumnCount();
		for (int i=0;i<count;i++) {
			String catalogName = metaData.getCatalogName(i);
			String columnClassName = metaData.getColumnClassName(i);
			int columnDisplaySize = metaData.getColumnDisplaySize(i);
			String columnLabel = metaData.getColumnLabel(i);
			String columnName = metaData.getColumnName(i);
			//			int columntype = metaData.getColumnType(i);
			String columnTypeName = metaData.getColumnTypeName(i);
		}
	}

	public void printDatabaseMeta() throws SQLException {

		DatabaseMetaData metaData = connection.getMetaData();

		System.out.println("allProceduresAreCallable:"+metaData.allProceduresAreCallable());
		System.out.println("allTablesAreSelectable:"+metaData.allTablesAreSelectable());
		System.out.println("autoCommitFailureClosesAllResultSets:"+metaData.autoCommitFailureClosesAllResultSets());
		System.out.println("dataDefinitionCausesTransactionCommit:"+metaData.dataDefinitionCausesTransactionCommit());
		System.out.println("dataDefinitionIgnoredInTransactions:"+metaData.dataDefinitionIgnoredInTransactions());
		System.out.println("doesMaxRowSizeIncludeBlobs:"+metaData.doesMaxRowSizeIncludeBlobs());
		//		System.out.println("generatedKeyAlwaysReturned:"+metaData.generatedKeyAlwaysReturned()); // 1.7
		System.out.println("isCatalogAtStart:"+metaData.isCatalogAtStart());
		System.out.println("isReadOnly:"+metaData.isReadOnly());
		System.out.println("locatorsUpdateCopy:"+metaData.locatorsUpdateCopy());

		System.out.println("nullPlusNonNullIsNull:"+metaData.nullPlusNonNullIsNull());
		System.out.println("nullsAreSortedAtEnd:"+metaData.nullsAreSortedAtEnd());
		System.out.println("nullsAreSortedAtStart:"+metaData.nullsAreSortedAtStart());
		System.out.println("nullsAreSortedHigh:"+metaData.nullsAreSortedHigh());
		System.out.println("nullsAreSortedLow:"+metaData.nullsAreSortedLow());

		System.out.println("storesLowerCaseIdentifiers:"+metaData.storesLowerCaseIdentifiers());
		System.out.println("storesLowerCaseQuotedIdentifiers:"+metaData.storesLowerCaseQuotedIdentifiers());
		System.out.println("storesMixedCaseIdentifiers:"+metaData.storesMixedCaseIdentifiers());
		System.out.println("storesMixedCaseQuotedIdentifiers:"+metaData.storesMixedCaseQuotedIdentifiers());
		System.out.println("storesUpperCaseIdentifiers:"+metaData.storesUpperCaseIdentifiers());
		System.out.println("storesUpperCaseQuotedIdentifiers:"+metaData.storesUpperCaseQuotedIdentifiers());

		System.out.println("supportsAlterTableWithAddColumn:"+metaData.supportsAlterTableWithAddColumn());
		System.out.println("supportsAlterTableWithDropColumn:"+metaData.supportsAlterTableWithDropColumn());
		System.out.println("supportsANSI92EntryLevelSQL:"+metaData.supportsANSI92EntryLevelSQL());
		System.out.println("supportsANSI92FullSQL:"+metaData.supportsANSI92FullSQL());
		System.out.println("supportsANSI92IntermediateSQL:"+metaData.supportsANSI92IntermediateSQL());
		System.out.println("supportsBatchUpdates:"+metaData.supportsBatchUpdates());
		System.out.println("supportsCatalogsInDataManipulation:"+metaData.supportsCatalogsInDataManipulation());
		System.out.println("supportsCatalogsInIndexDefinitions:"+metaData.supportsCatalogsInIndexDefinitions());
		System.out.println("supportsCatalogsInPrivilegeDefinitions:"+metaData.supportsCatalogsInPrivilegeDefinitions());
		System.out.println("supportsCatalogsInProcedureCalls:"+metaData.supportsCatalogsInProcedureCalls());
		System.out.println("supportsCatalogsInTableDefinitions:"+metaData.supportsCatalogsInTableDefinitions());
		System.out.println("supportsColumnAliasing:"+metaData.supportsColumnAliasing());
		System.out.println("supportsConvert:"+metaData.supportsConvert());
		System.out.println("supportsCoreSQLGrammar:"+metaData.supportsCoreSQLGrammar());
		System.out.println("supportsCorrelatedSubqueries:"+metaData.supportsCorrelatedSubqueries());
		System.out.println("supportsDataDefinitionAndDataManipulationTransactions:"+metaData.supportsDataDefinitionAndDataManipulationTransactions());
		System.out.println("supportsDataManipulationTransactionsOnly:"+metaData.supportsDataManipulationTransactionsOnly());
		System.out.println("supportsDifferentTableCorrelationNames:"+metaData.supportsDifferentTableCorrelationNames());
		System.out.println("supportsExpressionsInOrderBy:"+metaData.supportsExpressionsInOrderBy());
		System.out.println("supportsExtendedSQLGrammar:"+metaData.supportsExtendedSQLGrammar());
		System.out.println("supportsFullOuterJoins:"+metaData.supportsFullOuterJoins());
		System.out.println("supportsGetGeneratedKeys:"+metaData.supportsGetGeneratedKeys());
		System.out.println("supportsGroupBy:"+metaData.supportsGroupBy());
		System.out.println("supportsGroupByBeyondSelect:"+metaData.supportsGroupByBeyondSelect());
		System.out.println("supportsGroupByUnrelated:"+metaData.supportsGroupByUnrelated());
		System.out.println("supportsIntegrityEnhancementFacility:"+metaData.supportsIntegrityEnhancementFacility());
		System.out.println("supportsLikeEscapeClause:"+metaData.supportsLikeEscapeClause());
		System.out.println("supportsLimitedOuterJoins:"+metaData.supportsLimitedOuterJoins());
		System.out.println("supportsMinimumSQLGrammar:"+metaData.supportsMinimumSQLGrammar());
		System.out.println("supportsMixedCaseIdentifiers:"+metaData.supportsMixedCaseIdentifiers());
		System.out.println("supportsMixedCaseQuotedIdentifiers:"+metaData.supportsMixedCaseQuotedIdentifiers());
		System.out.println("supportsMultipleOpenResults:"+metaData.supportsMultipleOpenResults());
		System.out.println("supportsMultipleResultSets:"+metaData.supportsMultipleResultSets());
		System.out.println("supportsMultipleTransactions:"+metaData.supportsMultipleTransactions());
		System.out.println("supportsNamedParameters:"+metaData.supportsNamedParameters());
		System.out.println("supportsNonNullableColumns:"+metaData.supportsNonNullableColumns());
		System.out.println("supportsOpenCursorsAcrossCommit:"+metaData.supportsOpenCursorsAcrossCommit());
		System.out.println("supportsOpenCursorsAcrossRollback:"+metaData.supportsOpenCursorsAcrossRollback());
		System.out.println("supportsOpenStatementsAcrossCommit:"+metaData.supportsOpenStatementsAcrossCommit());
		System.out.println("supportsOpenStatementsAcrossRollback:"+metaData.supportsOpenStatementsAcrossRollback());
		System.out.println("supportsOrderByUnrelated:"+metaData.supportsOrderByUnrelated());
		System.out.println("supportsOuterJoins:"+metaData.supportsOuterJoins());
		System.out.println("supportsPositionedDelete:"+metaData.supportsPositionedDelete());
		System.out.println("supportsPositionedUpdate:"+metaData.supportsPositionedUpdate());
		System.out.println("supportsSavepoints:"+metaData.supportsSavepoints());
		System.out.println("supportsSchemasInDataManipulation:"+metaData.supportsSchemasInDataManipulation());
		System.out.println("supportsSchemasInIndexDefinitions:"+metaData.supportsSchemasInIndexDefinitions());
		System.out.println("supportsSchemasInPrivilegeDefinitions:"+metaData.supportsSchemasInPrivilegeDefinitions());
		System.out.println("supportsSchemasInProcedureCalls:"+metaData.supportsSchemasInProcedureCalls());
		System.out.println("supportsSchemasInTableDefinitions:"+metaData.supportsSchemasInTableDefinitions());
		System.out.println("supportsSelectForUpdate:"+metaData.supportsSelectForUpdate());
		System.out.println("supportsStatementPooling:"+metaData.supportsStatementPooling());
		System.out.println("supportsStoredFunctionsUsingCallSyntax:"+metaData.supportsStoredFunctionsUsingCallSyntax());
		System.out.println("supportsStoredProcedures:"+metaData.supportsStoredProcedures());
		System.out.println("supportsSubqueriesInComparisons:"+metaData.supportsSubqueriesInComparisons());
		System.out.println("supportsSubqueriesInExists:"+metaData.supportsSubqueriesInExists());
		System.out.println("supportsSubqueriesInIns:"+metaData.supportsSubqueriesInIns());
		System.out.println("supportsSubqueriesInQuantifieds:"+metaData.supportsSubqueriesInQuantifieds());
		System.out.println("supportsTableCorrelationNames:"+metaData.supportsTableCorrelationNames());
		System.out.println("supportsTransactions:"+metaData.supportsTransactions());
		System.out.println("supportsUnion:"+metaData.supportsUnion());
		System.out.println("supportsUnionAll:"+metaData.supportsUnionAll());


		//
		//		metaData.getCatalogs();
		//		metaData.getCatalogSeparator();
		//		metaData.getCatalogTerm();
		//		metaData.getClientInfoProperties();
		//		metaData.getDatabaseMajorVersion();
		//		metaData.getDatabaseMinorVersion();
		//		metaData.getDatabaseProductVersion();
		//		metaData.getDatabaseProductName();
		//		metaData.getDefaultTransactionIsolation();
		//		metaData.getDriverMajorVersion();
		//		metaData.getDriverMinorVersion();
		//		metaData.getDriverName();
		//		metaData.getDriverVersion();
		//		metaData.getExtraNameCharacters();
		//		metaData.getIdentifierQuoteString();
		//		metaData.getJDBCMajorVersion();
		//		metaData.getJDBCMinorVersion();
		//		metaData.getMaxBinaryLiteralLength();
		//		metaData.getMaxCatalogNameLength();
		//		metaData.getMaxColumnNameLength();
		//		metaData.getMaxColumnsInGroupBy();
		//		metaData.getMaxColumnsInIndex();
		//		metaData.getMaxColumnsInOrderBy();
		//		metaData.getMaxColumnsInSelect();
		//		metaData.getMaxColumnsInTable();
		//		metaData.getMaxConnections();
		//		metaData.getMaxCursorNameLength();
		//		metaData.getMaxIndexLength();
		//		metaData.getMaxProcedureNameLength();
		//		metaData.getMaxRowSize();
		//		metaData.getMaxSchemaNameLength();
		//		metaData.getMaxStatementLength();
		//		metaData.getMaxStatements();
		//		metaData.getMaxTableNameLength();
		//		metaData.getMaxTablesInSelect();
		//		metaData.getMaxUserNameLength();
		//
		//		metaData.getNumericFunctions();
		//		metaData.getProcedureTerm();
		//		metaData.getResultSetHoldability();
		//		metaData.getRowIdLifetime();
		//		metaData.getSchemas();
		//		metaData.getSchemaTerm();
		//		metaData.getSearchStringEscape();
		//		metaData.getSQLKeywords();
		//		metaData.getSQLStateType();
		//		metaData.getStringFunctions();
		//		metaData.getSystemFunctions();
		//		metaData.getTableTypes();
		//		metaData.getTimeDateFunctions();
		//		metaData.getTypeInfo();
		//		metaData.getURL();
		//		metaData.getUserName();
		//
		//
		//		metaData.getAttributes(catalog, schemaPattern, typeNamePattern, attributeNamePattern);
		//
		//		metaData.getBestRowIdentifier(catalog, schema, table, scope, nullable);
		//		metaData.getColumnPrivileges(catalog, schema, table, columnNamePattern);
		//		metaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
		//		metaData.getCrossReference(parentCatalog, parentSchema, parentTable, foreignCatalog, foreignSchema, foreignTable);
		//		metaData.getExportedKeys(catalog, schema, table);
		//		metaData.getFunctionColumns(catalog, schemaPattern, functionNamePattern, columnNamePattern);
		//		metaData.getFunctions(catalog, schemaPattern, functionNamePattern);
		//		metaData.getImportedKeys(catalog, schema, table);
		//		metaData.getIndexInfo(catalog, schema, table, unique, approximate);
		//		metaData.getPrimaryKeys(catalog, schema, table);
		//		metaData.getProcedureColumns(catalog, schemaPattern, procedureNamePattern, columnNamePattern);
		//		metaData.getProcedures(catalog, schemaPattern, procedureNamePattern);
		//		metaData.getPseudoColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
		//		metaData.getSchemas(catalog, schemaPattern);
		//		metaData.getSuperTables(catalog, schemaPattern, tableNamePattern);
		//		metaData.getSuperTypes(catalog, schemaPattern, typeNamePattern);
		//		metaData.getTablePrivileges(catalog, schemaPattern, tableNamePattern);
		//		metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
		//		metaData.getUDTs(catalog, schemaPattern, typeNamePattern, types);
		//		metaData.getVersionColumns(catalog, schema, table);

		//		metaData.getColumns(null, null, null, null);

	}

	public Connection getConnection() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:DEV", "LC_ARCH", "LC_ARCH");
		//		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snms?useUnicode=true&characterEncoding=UTF-8","snms","snms");
		return connection;
	}
}
