/*
 * SinoNetFramework: net.lc4ever.framework.dao.hibernate.AuditableObjectInterceptor.java create by q-wang on Aug 7, 2013 4:00:52 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.dao.hibernate;

import java.io.Serializable;
import java.util.Date;

import net.lc4ever.framework.domain.AuditableObject;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 *
 */
public class AuditableObjectInterceptor extends EmptyInterceptor {

	/**
	 * @see org.hibernate.EmptyInterceptor#onFlushDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onFlushDirty(final Object entity, final Serializable id, final Object[] currentState, final Object[] previousState, final String[] propertyNames, final Type[] types) {
		if (entity instanceof AuditableObject<?>) {
			AuditableObject<?> auditable = (AuditableObject<?>) entity;
			auditable.setModifyTimestamp(new Date());
		}
		return true;
	}

	/**
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(final Object entity, final Serializable id, final Object[] state, final String[] propertyNames, final Type[] types) {
		if (entity instanceof AuditableObject<?>) {
			AuditableObject<?> auditable = (AuditableObject<?>) entity;
			auditable.setCreateTimestamp(new Date());
		}
		return true;
	}


}
