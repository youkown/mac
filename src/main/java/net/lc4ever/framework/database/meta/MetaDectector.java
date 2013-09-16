/*
 * SinoNetFramework: net.lc4ever.framework.database.meta.MetaDectector.java create by q-wang on Sep 10, 2013 3:57:51 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.database.meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public class MetaDectector {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected Connection connection;

	protected int jdbcMajorVersion;
	protected int jdbcMinorVersion;

	public MetaDectector(Connection connection) {
		this.connection = connection;
	}

	public List<String> listTables() throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		jdbcMajorVersion = metaData.getJDBCMajorVersion();
		jdbcMinorVersion = metaData.getJDBCMinorVersion();

		metaData.getTables(null, null, null, new String[]{"TABLE"});
		return null;
	}
}
