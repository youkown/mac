/*
 * Framework: net.lc4ever.framework.domain.mapping.TableMapping.java create by q-wang on May 22, 2013 1:11:01 AM
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
@Table(name="T5_MAPPING_TABLE")
@DiscriminatorValue("TABLE")
public class TableMapping extends Mapping {


}
