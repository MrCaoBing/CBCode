package com.haochen.hc0407crm.entity;

import java.util.Date;

/**
 * 客户流失表
 * @author lzm
 *
 */
public class CstLost {
	
	/**
	 * 编号
	 */
	private Integer lstId;					
	
	/**
	 * 客户编号对象
	 */
	private CstCustomer cstCustomer;	
	
	/**
	 * 客户经理对象
	 */
	private SysUser lstCustManagerUser;		
	
	/**
	 * 上次下单时间
	 */
	private String lstLastOrderDate;			
	
	/**
	 * 暂缓措施
	 */
	private String lstDelay;			
	
	/**
	 * 流失状态 1-警告（还未做暂缓处理操作），2-暂缓流失(已经做了暂缓处理操作)，3-已流失
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
