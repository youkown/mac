/*
 * Framework: net.lc4ever.framework.domain.TimestampObject.java create by q-wang on Mar 17, 2013 4:42:25 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 时间戳类Domain抽象父类.
 * 
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
//@MappedSuperclass
public abstract class TimestampObject<K extends Serializable> extends AbstractEntity<K> {

	/**
	 * 创建时间戳.
	 * 
	 * CREATE_TIMESTAMP
	 */
	protected Date createTimestamp;

	/**
	 * 修改时间戳.
	 * 
	 * MODIFY_TIMESTAMP
	 */
	protected Date modifyTimestamp;

	/**
	 * 删除标记位.
	 * 
	 * DELETION_TAG
	 */
	protected boolean deletionTag;

	/**
	 * 创建时间戳.
	 * 
	 * CREATE_TIMESTAMP
	 * @return the createTimestamp
	 */
	@Column(name = "CREATE_TIMESTAMP", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * 创建时间戳.
	 * 
	 * CREATE_TIMESTAMP
	 * @param createTimestamp the createTimestamp to set
	 */
	public void setCreateTimestamp(final Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	/**
	 * 修改时间戳.
	 * 
	 * MODIFY_TIMESTAMP
	 * @return the modifyTimestamp
	 */
	@Column(name="MODIFY_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyTimestamp() {
		return modifyTimestamp;
	}

	/**
	 * 修改时间戳.
	 * 
	 * MODIFY_TIMESTAMP
	 * @param modifyTimestamp the modifyTimestamp to set
	 */
	public void setModifyTimestamp(final Date modifyTimestamp) {
		this.modifyTimestamp = modifyTimestamp;
	}


	/**
	 * 删除标记位.
	 * 
	 * DELETION_TAG
	 * @return the deletionTag
	 */
	@Column(name="DELETION_TAG")
	public boolean isDeletionTag() {
		return deletionTag;
	}


	/**
	 * 删除标记位.
	 * 
	 * DELETION_TAG
	 * @param deletionTag the deletionTag to set
	 */
	public void setDeletionTag(final boolean deletionTag) {
		this.deletionTag = deletionTag;
	}

}
