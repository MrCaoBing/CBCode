package com.haochen.hc0407crm.entity;

import java.util.Date;

/**
 * 客户信息表
 * 
 * @author lzm
 *
 */
public class CstCustomer {
	
	/**
	 * 客户编号
	 */
	private String custNo;				
	
	/**
	 * 客户id
	 */
	private String custId;
	
	/**
	 * 客户名称
	 */
	private String custName;			
	
	/**
	 * 地区
	 */
	private String custRegion;			
	
	/**
	 * 客户经理对象
	 */
	private SysUser sysUser;			
	
	/**
	 * 客户等级	
	 */
	private String custLevel;		
	
	/**
	 * 满意度（1-5），默认为3
	 */
	private Integer custSatisfy;		
	
	/**
	 * 信用度（1-5），默认为3
	 */
	private Integer custCredit;			
	
	/**
	 * 地址
	 */
	private String custAddr;			
	
	/**
	 * 邮政编码
	 */
	private String custZip;				
	
	/**
	 * 电话
	 */
	private String custTel;			
	
	/**
	 * 传真
	 */
	private String custFax;			
	
	/**
	 * 网址
	 */
	private String custWebsite;		
	
	/**
	 * 营业执照注册号
	 */
	private String custLicenceNo;		
	
	/**
	 * 法人
	 */
	private String custChieftain;		
	
	/**
	 * 注册资金
	 */
	private Integer custBankroll;	
	
	/**
	 * 营业额
	 */
	private Integer custTurnover;		
	
	/**
	 * 开户银行
	 */
	private String custBank;		
	
	/**
	 * 银行账号
	 */
	private String custBankAccount;	
	
	/**
	 * 地税登记号
	 */
	private String custLocalTaxNo;		
	
	/**
	 * 国税登记号
	 */
	private String custNationalTaxNo;
	
	/**
	 * 客户状态：1--正常；2--流失；3--删除，4—预警。
	 */
	private String custStatus;			
	
	/**
	 * 流失时间（可以为空），但当cust_status为2时，必须有值
	 */
	private String lostTime;				
	
	/**
	 * 流失原因（可以为空），但当cust_status为2时，必须有值
	 */
	private String lostReason;
	
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustRegion() {
		return custRegion;
	}
	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public Integer getCustSatisfy() {
		return custSatisfy;
	}
	public void setCustSatisfy(Integer custSatisfy) {
		this.custSatisfy = custSatisfy;
	}
	public Integer getCustCredit() {
		return custCredit;
	}
	public void setCustCredit(Integer custCredit) {
		this.custCredit = custCredit;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getCustZip() {
		return custZip;
	}
	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}
	public String getCustTel() {
		return custTel;
	}
	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
	public String getCustFax() {
		return custFax;
	}
	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}
	public String getCustWebsite() {
		return custWebsite;
	}
	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}
	public String getCustLicenceNo() {
		return custLicenceNo;
	}
	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}
	public String getCustChieftain() {
		return custChieftain;
	}
	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}
	public Integer getCustBankroll() {
		return custBankroll;
	}
	public void setCustBankroll(Integer custBankroll) {
		this.custBankroll = custBankroll;
	}
	public Integer getCustTurnover() {
		return custTurnover;
	}
	public void setCustTurnover(Integer custTurnover) {
		this.custTurnover = custTurnover;
	}
	public String getCustBank() {
		return custBank;
	}
	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}
	public String getCustBankAccount() {
		return custBankAccount;
	}
	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}
	public String getCustLocalTaxNo() {
		return custLocalTaxNo;
	}
	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}
	public String getCustNationalTaxNo() {
		return custNationalTaxNo;
	}
	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public String getLostTime() {
		return lostTime;
	}
	public void setLostTime(String lostTime) {
		this.lostTime = lostTime;
	}
	public String getLostReason() {
		return lostReason;
	}
	public void setLostReason(String lostReason) {
		this.lostReason = lostReason;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public CstCustomer() {
		super();
	}
	
	
	public CstCustomer(String custNo, String custId, String custName, String custRegion, SysUser sysUser,
			String custLevel, Integer custSatisfy, Integer custCredit, String custAddr, String custZip, String custTel,
			String custFax, String custWebsite, String custLicenceNo, String custChieftain, Integer custBankroll,
			Integer custTurnover, String custBank, String custBankAccount, String custLocalTaxNo,
			String custNationalTaxNo, String custStatus, String lostTime, String lostReason) {
		super();
		this.custNo = custNo;
		this.custId = custId;
		this.custName = custName;
		this.custRegion = custRegion;
		this.sysUser = sysUser;
		this.custLevel = custLevel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddr = custAddr;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBankroll = custBankroll;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custStatus = custStatus;
		this.lostTime = lostTime;
		this.lostReason = lostReason;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CstCustomer [" + (custNo != null ? "custNo=" + custNo + ", " : "")
				+ (custId != null ? "custId=" + custId + ", " : "")
				+ (custName != null ? "custName=" + custName + ", " : "")
				+ (custRegion != null ? "custRegion=" + custRegion + ", " : "")
				+ (sysUser != null ? "sysUser=" + sysUser + ", " : "")
				+ (custLevel != null ? "custLevel=" + custLevel + ", " : "")
				+ (custSatisfy != null ? "custSatisfy=" + custSatisfy + ", " : "")
				+ (custCredit != null ? "custCredit=" + custCredit + ", " : "")
				+ (custAddr != null ? "custAddr=" + custAddr + ", " : "")
				+ (custZip != null ? "custZip=" + custZip + ", " : "")
				+ (custTel != null ? "custTel=" + custTel + ", " : "")
				+ (custFax != null ? "custFax=" + custFax + ", " : "")
				+ (custWebsite != null ? "custWebsite=" + custWebsite + ", " : "")
				+ (custLicenceNo != null ? "custLicenceNo=" + custLicenceNo + ", " : "")
				+ (custChieftain != null ? "custChieftain=" + custChieftain + ", " : "")
				+ (custBankroll != null ? "custBankroll=" + custBankroll + ", " : "")
				+ (custTurnover != null ? "custTurnover=" + custTurnover + ", " : "")
				+ (custBank != null ? "custBank=" + custBank + ", " : "")
				+ (custBankAccount != null ? "custBankAccount=" + custBankAccount + ", " : "")
				+ (custLocalTaxNo != null ? "custLocalTaxNo=" + custLocalTaxNo + ", " : "")
				+ (custNationalTaxNo != null ? "custNationalTaxNo=" + custNationalTaxNo + ", " : "")
				+ (custStatus != null ? "custStatus=" + custStatus + ", " : "")
				+ (lostTime != null ? "lostTime=" + lostTime + ", " : "")
				+ (lostReason != null ? "lostReason=" + lostReason : "") + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}                            
