package com.haochen.hc0407crm.entity;

import java.util.Date;

/**
 * �ͻ���ʧ��
 * @author lzm
 *
 */
public class CstLost {
	
	/**
	 * ���
	 */
	private Integer lstId;					
	
	/**
	 * �ͻ���Ŷ���
	 */
	private CstCustomer cstCustomer;	
	
	/**
	 * �ͻ��������
	 */
	private SysUser lstCustManagerUser;		
	
	/**
	 * �ϴ��µ�ʱ��
	 */
	private String lstLastOrderDate;			
	
	/**
	 * �ݻ���ʩ
	 */
	private String lstDelay;			
	
	/**
	 * ��ʧ״̬ 1-���棨��δ���ݻ������������2-�ݻ���ʧ(�Ѿ������ݻ��������)��3-����ʧ
	 */
	private String lstStatus;			
	public Integer getLstId() {
		return lstId;
	}
	public void setLstId(Integer lstId) {
		this.lstId = lstId;
	}
	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}
	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}
	public SysUser getLstCustManagerUser() {
		return lstCustManagerUser;
	}
	public void setLstCustManagerUser(SysUser lstCustManagerUser) {
		this.lstCustManagerUser = lstCustManagerUser;
	}
	public String getLstLastOrderDate() {
		return lstLastOrderDate;
	}
	public void setLstLastOrderDate(String lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}
	public String getLstDelay() {
		return lstDelay;
	}
	public void setLstDelay(String lstDelay) {
		this.lstDelay = lstDelay;
	}
	public String getLstStatus() {
		return lstStatus;
	}
	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}
	public CstLost(Integer lstId, CstCustomer cstCustomer, SysUser lstCustManagerUser, String lstLastOrderDate,
			String lstDelay, String lstStatus) {
		super();
		this.lstId = lstId;
		this.cstCustomer = cstCustomer;
		this.lstCustManagerUser = lstCustManagerUser;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lstDelay = lstDelay;
		this.lstStatus = lstStatus;
	}
	public CstLost() {
		super();
	}

	
	
	
	
}
