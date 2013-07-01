/*
 * Framework: net.lc4ever.framework.domain.meta.DatabaseMeta.java create by q-wang on May 16, 2013 11:11:44 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.meta;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public class DatabaseMeta implements BaseEntity<Long> {

	private Long id;

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
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

	private String name;
	private String description;

	private int type; // 1: jdbc url; 2: jndi datasource
	private boolean xa; // xa datasource
	private String url; // jdbc url or jndi
	private String user; // jdbc username or null(jndi)
	private transient String password; // jdbc password or null(jndi)

	private String host;
	private int port;

	private long detectedTimestamp;
	private long dectectedRevision;

	private String databaseProductName;
	private String databaseProductVersion;

	private int driverMajorVersion;
	private int driverMinorVersion;

	private int databaseMajorVersion;
	private int databaseMinorVersion;

	private int jdbcSpecMajorVersion;
	private int jdbcSpecMinorVersion;

}
