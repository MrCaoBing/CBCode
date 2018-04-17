package com.haochen.hc0407crm.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ���β˵��ڵ�����
 * @author Mr.Cao
 *
 */
public class Node {
	/**
	 * �ڵ�ID���Լ���Զ�����ݺ���Ҫ��
	 */
	private String id;
	/**
	 * ��ʾ�ڵ��ı���
	 */
	private String text;
	/**
	 * �ڵ�״̬��'open' �� 'closed'��Ĭ�ϣ�'open'�����Ϊ'closed'��ʱ�򣬽����Զ�չ���ýڵ㡣
	 */
	private String state;
	/**
	 * �ڵ�״̬��'open' �� 'closed'��Ĭ�ϣ�'open'�����Ϊ'closed'��ʱ�򣬽����Զ�չ���ýڵ㡣
	 */
	private String checked;
	/**
	 * ����ӵ��ڵ���Զ������ԡ�
	 */
	private Map attributes;
	/**
	 * һ���ڵ��������������ɽڵ㡣
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

