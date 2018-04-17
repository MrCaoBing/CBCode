package com.haochen.hc0407crm.entity;

import java.util.Date;

/**
 * �ͻ���Ϣ��
 * 
 * @author lzm
 *
 */
public class CstCustomer {
	
	/**
	 * �ͻ����
	 */
	private String custNo;				
	
	/**
	 * �ͻ�id
	 */
	private String custId;
	
	/**
	 * �ͻ�����
	 */
	private String custName;			
	
	/**
	 * ����
	 */
	private String custRegion;			
	
	/**
	 * �ͻ��������
	 */
	private SysUser sysUser;			
	
	/**
	 * �ͻ��ȼ�	
	 */
	private String custLevel;		
	
	/**
	 * ����ȣ�1-5����Ĭ��Ϊ3
	 */
	private Integer custSatisfy;		
	
	/**
	 * ���öȣ�1-5����Ĭ��Ϊ3
	 */
	private Integer custCredit;			
	
	/**
	 * ��ַ
	 */
	private String custAddr;			
	
	/**
	 * ��������
	 */
	private String custZip;				
	
	/**
	 * �绰
	 */
	private String custTel;			
	
	/**
	 * ����
	 */
	private String custFax;			
	
	/**
	 * ��ַ
	 */
	private String custWebsite;		
	
	/**
	 * Ӫҵִ��ע���
	 */
	private String custLicenceNo;		
	
	/**
	 * ����
	 */
	private String custChieftain;		
	
	/**
	 * ע���ʽ�
	 */
	private Integer custBankroll;	
	
	/**
	 * Ӫҵ��
	 */
	private Integer custTurnover;		
	
	/**
	 * ��������
	 */
	private String custBank;		
	
	/**
	 * �����˺�
	 */
	private String custBankAccount;	
	
	/**
	 * ��˰�ǼǺ�
	 */
	private String custLocalTaxNo;		
	
	/**
	 * ��˰�ǼǺ�
	 */
	private String custNationalTaxNo;
	
	/**
	 * �ͻ�״̬��1--������2--��ʧ��3--ɾ����4��Ԥ����
	 */
	private String custStatus;			
	
	/**
	 * ��ʧʱ�䣨����Ϊ�գ�������cust_statusΪ2ʱ��������ֵ
	 */
	private String lostTime;				
	
	/**
	 * ��ʧԭ�򣨿���Ϊ�գ�������cust_statusΪ2ʱ��������ֵ
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
