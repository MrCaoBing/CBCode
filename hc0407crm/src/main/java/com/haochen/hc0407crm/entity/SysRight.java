package com.haochen.hc0407crm.entity;

/**
 * Ȩ�ޱ�
 * 
 * @author lzm
 *
 */
public class SysRight {
	/**
	 * Ȩ�ޱ��
	 */
	private String rightCode;		
	/**
	 * ģ�鸸���
	 */
	private String rightParentCode;	
	/**
	 * Ȩ������
	 */
	private String rightType;		
	/**
	 * Ȩ������
	 */
	private String rightText;		
	/**
	 * url(Ȩ�޶�Ӧ���ܵķ���url)
	 */
	private String rightUrl;		
	/**
	 * ��ʾ
	 */
	private String rightTip;		
	/**
	 * Ȩ�޽ڵ�����0-�˵����� 1-��ť����
	 */
	private String rightNodeType;	

	public String getRightCode() {
		return rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParentCode() {
		return rightParentCode;
	}

	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}

	public String getRightType() {
		return rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightText() {
		return rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightTip() {
		return rightTip;
	}

	public void setRightTip(String rightTip) {
		this.rightTip = rightTip;
	}

	public String getRightNodeType() {
		return rightNodeType;
	}

	public void setRightNodeType(String rightNodeType) {
		this.rightNodeType = rightNodeType;
	}

	public SysRight(String rightCode, String rightParentCode, String rightType, String rightText, String rightUrl,
			String rightTip, String rightNodeType) {
		super();
		this.rightCode = rightCode;
		this.rightParentCode = rightParentCode;
		this.rightType = rightType;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.rightTip = rightTip;
		this.rightNodeType = rightNodeType;
	}

	public SysRight() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysRight [" + (rightCode != null ? "rightCode=" + rightCode + ", " : "")
				+ (rightParentCode != null ? "rightParentCode=" + rightParentCode + ", " : "")
				+ (rightType != null ? "rightType=" + rightType + ", " : "")
				+ (rightText != null ? "rightText=" + rightText + ", " : "")
				+ (rightUrl != null ? "rightUrl=" + rightUrl + ", " : "")
				+ (rightTip != null ? "rightTip=" + rightTip + ", " : "")
				+ (rightNodeType != null ? "rightNodeType=" + rightNodeType : "") + "]";
	}
	
}
