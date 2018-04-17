package com.haochen.hc0407crm.entity;

/**
 * �ͻ���ϵ�˱�
 * 
 * @author lzm
 *
 */
public class CstLinkman {

	/**
	 * ��ϵ�˱��
	 */
	private Integer lkmId;

	/**
	 * �ͻ�����
	 */
	private CstCustomer cstCustomer;

	/**
	 * ��ϵ������
	 */
	private String lkmName;

	/**
	 * �Ա�
	 */
	private String lkmSex;

	/**
	 * ְλ
	 */
	private String lkmPostion;

	/**
	 * �칫�ҵ绰
	 */
	private String lkmTel;

	/**
	 * �ֻ�
	 */
	private String lkmMobile;

	/**
	 * ��ע
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
