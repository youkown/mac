/*
 * Framework: net.lc4ever.framework.domain.display.ext42.Ext4Display.java create by q-wang on May 20, 2013 1:36:15 AM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.display.ext42;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.lc4ever.framework.domain.display.Display;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T6_DISPLAY_EXT4")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="XTYPE")
public class Ext4Display extends Display {

}
