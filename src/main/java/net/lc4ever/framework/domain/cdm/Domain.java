/*
 * Framework: net.lc4ever.framework.domain.cdm.Domain.java create by q-wang on Mar 31, 2013 11:21:44 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.cdm;
import net.lc4ever.framework.domain.TimestampObject;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooEquals
@RooSerializable
public class Domain extends TimestampObject<Long> {
}
