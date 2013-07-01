/*
 * Framework: net.lc4ever.framework.domain.mapping.DtoMapping.java create by q-wang on May 22, 2013 1:12:10 AM
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
@Table(name="T5_MAPPING_DTO")
@DiscriminatorValue("DTO")
public class DtoMapping extends Mapping {

}
