/*
 * SinoNetFramework: net.lc4ever.framework.domain.view.html.HtmlObject.java create by q-wang on Aug 13, 2013 4:27:18 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.view.html;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import net.lc4ever.framework.domain.AuditableUUIDObject;

/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@MappedSuperclass
public class HtmlObject extends AuditableUUIDObject {

	private String cssClass;

	private String cssStyle;

	private String cssId;

	/**
	 * @return the cssId
	 */
	@Column(name = "CSS_ID", length = 64)
	public String getCssId() {
		return cssId;
	}

	/**
	 * @param cssId the cssId to set
	 */
	public void setCssId(final String cssId) {
		this.cssId = cssId;
	}

	/**
	 * @return the cssClass
	 */
	@Column(name = "CSS_CLASS", length = 128)
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(final String cssClass) {
		this.cssClass = cssClass;
	}

	/**
	 * @return the cssStyle
	 */
	@Column(name = "CSS_STYLE", length = 255)
	public String getCssStyle() {
		return cssStyle;
	}

	/**
	 * @param cssStyle the cssStyle to set
	 */
	public void setCssStyle(final String cssStyle) {
		this.cssStyle = cssStyle;
	}
}
