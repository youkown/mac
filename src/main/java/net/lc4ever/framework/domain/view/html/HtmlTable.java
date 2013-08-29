/*
 * SinoNetFramework: net.lc4ever.framework.domain.view.html.HtmlTable.java create by q-wang on Aug 13, 2013 5:45:56 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.domain.view.html;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
@Entity
@Table(name="T2_VIEW_HTML_TABLE")
public class HtmlTable extends HtmlObject {

	private String caption;

	private List<HtmlTableColGroup> colGroups;

	private HtmlTableElement thead;
	private HtmlTableElement tfoot;
	private List<HtmlTableElement> tbodies;

}
