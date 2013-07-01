/*
 * Framework: net.lc4ever.framework.domain.mapping.EntityMapping.java create by q-wang on May 22, 2013 1:11:25 AM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.mapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_MAPPING_ENTITY")
@DiscriminatorValue("ENTITY")
public class EntityMapping extends Mapping {

}
