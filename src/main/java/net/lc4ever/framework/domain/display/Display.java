/*
 * Framework: net.lc4ever.framework.domain.display.Display.java create by q-wang on May 20, 2013 1:23:12 AM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.display;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.lc4ever.framework.domain.BaseEntity;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T5_DISPLAY")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE")
public class Display implements BaseEntity<Long> {

	private Long id;

	/**
	 * @see net.lc4ever.framework.domain.BaseEntity#getId()
	 */
	@Override
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
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

}
