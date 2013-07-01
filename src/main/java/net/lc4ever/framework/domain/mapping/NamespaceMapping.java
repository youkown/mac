/*
 * Framework: net.lc4ever.framework.domain.mapping.NamespaceMapping.java create by q-wang on May 22, 2013 2:06:33 PM
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
@Table(name="T5_MAPPING_NS")
@DiscriminatorValue("NS")
public class NamespaceMapping extends Mapping {

}
