/*
 * Framework: net.lc4ever.framework.security.domain.rbac.AbstractUser.java create by q-wang on Apr 19, 2013 4:52:00 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.security.domain.rbac;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import net.lc4ever.framework.domain.AuditableObject;

import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@MappedSuperclass
public abstract class AbstractUser extends AuditableObject<Long> implements UserDetails {

	private String uid;


	/**
	 * @return the uid
	 */
	@Column
	public String getUid() {
		return uid;
	}


	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

}
