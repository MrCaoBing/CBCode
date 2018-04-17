package com.haochen.hc0407crm.entity;

import java.util.Date;

/**
 * 订单表
 * 
 * @author lzm
 *
 */
public class Orders {
	
	/**
	 * 订单编号
	 */
	private Integer odrId;			
	
	/**
	 * 订单客户公司编号
	 */
	private CstCustomer cstCustomer;	
	
	/**
	 * 订单日期
	 */
	private String odrDate;			
	
	/**
	 * 地址
	 */
	private String odrAddr;			
	
	/**
	 * 状态(5: 已发货  6:已回款)
	 */
	private String odrStatus;		
	
	/**
	 * 备注
	 */
	private String odrMemo;	
	
	public Integer getOdrId() {
		return odrId;
	}

	public void setOdrId(Integer odrId) {
		this.odrId = odrId;
	}

	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getOdrDate() {
		return odrDate;
	}

	public void setOdrDate(String odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrAddr() {
		return odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	public String getOdrStatus() {
		return odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	
	
	/**
	 * @return the odrMemo
	 */
	public String getOdrMemo() {
		return odrMemo;
	}

	/**
	 * @param odrMemo the odrMemo to set
	 */
	public void setOdrMemo(String odrMemo) {
		this.odrMemo = odrMemo;
	}

	
	public Orders() {
		super();
	}
	
	
	/**
	 * @param odrId
	 * @param cstCustomer
	 * @param odrDate
	 * @param odrAddr
	 * @param odrStatus
	 * @param odrMemo
	 */
	public Orders(Integer odrId, CstCustomer cstCustomer, String odrDate, String odrAddr, String odrStatus,
			String odrMemo) {
		super();
		this.odrId = odrId;
		this.cstCustomer = cstCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
		this.odrMemo = odrMemo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Orders [" + (odrId != null ? "odrId=" + odrId + ", " : "")
				+ (cstCustomer != null ? "cstCustomer=" + cstCustomer + ", " : "")
				+ (odrDate != null ? "odrDate=" + odrDate + ", " : "")
				+ (odrAddr != null ? "odrAddr=" + odrAddr + ", " : "")
				+ (odrStatus != null ? "odrStatus=" + odrStatus + ", " : "")
				+ (odrMemo != null ? "odrMemo=" + odrMemo : "") + "]";
	}

	
}
