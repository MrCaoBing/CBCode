package com.haochen.hc0407crm.entity;

/**
 * 权限表
 * 
 * @author lzm
 *
 */
public class SysRight {
	/**
	 * 权限编号
	 */
	private String rightCode;		
	/**
	 * 模块父编号
	 */
	private String rightParentCode;	
	/**
	 * 权限类型
	 */
	private String rightType;		
	/**
	 * 权限名称
	 */
	private String rightText;		
	/**
	 * url(权限对应功能的访问url)
	 */
	private String rightUrl;		
	/**
	 * 显示
	 */
	private String rightTip;		
	/**
	 * 权限节点类型0-菜单级别 1-按钮级别
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
