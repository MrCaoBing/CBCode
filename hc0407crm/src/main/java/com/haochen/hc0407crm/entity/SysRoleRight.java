package com.haochen.hc0407crm.entity;

/**
 * ��ɫȨ�ޱ�
 * 
 * @author lzm
 *
 */
public class SysRoleRight {
	/**
	 * ���
	 */
	private Integer rfId;		
	/**
	 * ��ɫ����
	 */
	private SysRole sysRole;	
	/**
	 * Ȩ�޶���
	 */
	private SysRight sysRight;	

	public Integer getRfId() {
		return rfId;
	}

	public void setRfId(Integer rfId) {
		this.rfId = rfId;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysRight getSysRight() {
		return sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}

	public SysRoleRight(Integer rfId, SysRole sysRole, SysRight sysRight) {
		super();
		this.rfId = rfId;
		this.sysRole = sysRole;
		this.sysRight = sysRight;
	}

	public SysRoleRight() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysRoleRight [" + (rfId != null ? "rfId=" + rfId + ", " : "")
				+ (sysRole != null ? "sysRole=" + sysRole + ", " : "")
				+ (sysRight != null ? "sysRight=" + sysRight : "") + "]";
	}

}
