package com.haochen.hc0407crm.entity;

import java.io.Serializable;

/**
 * �û���
 * 
 * @author lzm
 *
 */
public class SysUser implements Serializable{
	/**
	 * ���л�
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���
	 */
	private Integer usrId;		
	/**
	 * ����
	 */
	private String usrName;		
	/**
	 * ����
	 */
	private String usrPassword;	
	/**
	 * ��ɫ
	 */
	private SysRole sysRole;	
	/**
	 * ״̬(0:��ɾ��,1:����)
	 */
	private Integer usrFlag;	

	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public Integer getUsrFlag() {
		return usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}

	public SysUser(Integer usrId, String usrName, String usrPassword, SysRole sysRole, Integer usrFlag) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.sysRole = sysRole;
		this.usrFlag = usrFlag;
	}

	public SysUser() {
		super();
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysUser [" + (usrId != null ? "usrId=" + usrId + ", " : "")
				+ (usrName != null ? "usrName=" + usrName + ", " : "")
				+ (usrPassword != null ? "usrPassword=" + usrPassword + ", " : "")
				+ (sysRole != null ? "sysRole=" + sysRole + ", " : "") + (usrFlag != null ? "usrFlag=" + usrFlag : "")
				+ "]";
	}
	
	
}
