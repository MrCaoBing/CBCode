package com.haochen.hc0407crm.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 树形菜单节点类型
 * @author Mr.Cao
 *
 */
public class Node {
	/**
	 * 节点ID，对加载远程数据很重要。
	 */
	private String id;
	/**
	 * 显示节点文本。
	 */
	private String text;
	/**
	 * 节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	 */
	private String state;
	/**
	 * 节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	 */
	private String checked;
	/**
	 * 被添加到节点的自定义属性。
	 */
	private Map attributes;
	/**
	 * 一个节点数组声明了若干节点。
	 */
	private List<Node> children = new ArrayList<Node>();
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the checked
	 */
	public String getChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}
	/**
	 * @return the attributes
	 */
	public Map getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the children
	 */
	public List<Node> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Node [" + (id != null ? "id=" + id + ", " : "") + (text != null ? "text=" + text + ", " : "")
				+ (state != null ? "state=" + state + ", " : "") + (checked != null ? "checked=" + checked + ", " : "")
				+ (attributes != null ? "attributes=" + attributes + ", " : "")
				+ (children != null ? "children=" + children : "") + "]";
	}
	
}

