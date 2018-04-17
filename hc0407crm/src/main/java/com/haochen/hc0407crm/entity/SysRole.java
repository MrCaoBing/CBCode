package com.haochen.hc0407crm.entity;

/**
 * ��ɫ��
 * 
 * @author lzm
 *
 */
public class SysRole {
	/**
	 * ��ɫ���
	 */
	private Integer roleId;		
	/**
	 * ��ɫ����
	 */
	private String roleName;	
	/**
	 * ��ɫ��ע
	 */
	private String roleDesc;	
	/**
	 * ��ɫ״̬
	 */
	private Integer roleFlag;	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	public SysRole(Integer roleId, String roleName, String roleDesc, Integer roleFlag) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
	}

	public SysRole() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysRole [" + (roleId != null ? "roleId=" + roleId + ", " : "")
				+ (roleName != null ? "roleName=" + roleName + ", " : "")
				+ (roleDesc != null ? "roleDesc=" + roleDesc + ", " : "")
				+ (roleFlag != null ? "roleFlag=" + roleFlag : "") + "]";
	}
	
}
