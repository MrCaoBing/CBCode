package com.haochen.hc0407crm.entity;

/**
 * 客户联系人表
 * 
 * @author lzm
 *
 */
public class CstLinkman {

	/**
	 * 联系人编号
	 */
	private Integer lkmId;

	/**
	 * 客户对象
	 */
	private CstCustomer cstCustomer;

	/**
	 * 联系人名称
	 */
	private String lkmName;

	/**
	 * 性别
	 */
	private String lkmSex;

	/**
	 * 职位
	 */
	private String lkmPostion;

	/**
	 * 办公室电话
	 */
	private String lkmTel;

	/**
	 * 手机
	 */
	private String lkmMobile;

	/**
	 * 备注
	 */
	private String lkmMemo;

	public Integer getLkmId() {
		return lkmId;
	}

	public void setLkmId(Integer lkmId) {
		this.lkmId = lkmId;
	}

	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getLkmName() {
		return lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmSex() {
		return lkmSex;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	public String getLkmPostion() {
		return lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	public String getLkmTel() {
		return lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmMemo() {
		return lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public CstLinkman(Integer lkmId, CstCustomer cstCustomer, String lkmName, String lkmSex, String lkmPostion,
			String lkmTel, String lkmMobile, String lkmMemo) {
		super();
		this.lkmId = lkmId;
		this.cstCustomer = cstCustomer;
		this.lkmName = lkmName;
		this.lkmSex = lkmSex;
		this.lkmPostion = lkmPostion;
		this.lkmTel = lkmTel;
		this.lkmMobile = lkmMobile;
		this.lkmMemo = lkmMemo;
	}

	public CstLinkman() {
		super();
	}

}
