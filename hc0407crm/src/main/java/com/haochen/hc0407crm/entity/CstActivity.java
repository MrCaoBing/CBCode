package com.haochen.hc0407crm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������¼��
 * 
 * @author lzm
 *
 */
public class CstActivity {
	/**
	 * ������¼���
	 */
	private Integer atvId;			
	
	/**
	 * �ͻ���Ŷ���
	 */
	private CstCustomer cstCustomer;	
	
	/**
	 * ��������
	 */
	private String atvDate;
	
	/**
	 * �����ص�
	 */
	private String atvPlace;
	
	/**
	 * ������Ҫ
	 */
	private String atvTitle;
	
	/**
	 * ��ϸ��Ϣ
	 */
	private String atvDesc;	
	
	private String atvMemo;
	
	public Integer getAtvId() {
		return atvId;
	}
	
	public void setAtvId(Integer atvId) {
		this.atvId = atvId;
	}

	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getAtvDate() {
		return atvDate;
	}

	public void setAtvDate(String atvDate) {
		this.atvDate = atvDate;
	}

	public String getAtvPlace() {
		return atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	public String getAtvTitle() {
		return atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	public String getAtvDesc() {
		return atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

	
	/**
	 * @return the atvMemo
	 */
	public String getAtvMemo() {
		return atvMemo;
	}

	/**
	 * @param atvMemo the atvMemo to set
	 */
	public void setAtvMemo(String atvMemo) {
		this.atvMemo = atvMemo;
	}

	/**
	 * @param atvId
	 * @param cstCustomer
	 * @param atvDate
	 * @param atvPlace
	 * @param atvTitle
	 * @param atvDesc
	 * @param atvMemo
	 */
	public CstActivity(Integer atvId, CstCustomer cstCustomer, String atvDate, String atvPlace, String atvTitle,
			String atvDesc, String atvMemo) {
		super();
		this.atvId = atvId;
		this.cstCustomer = cstCustomer;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
		this.atvMemo = atvMemo;
	}

	public CstActivity() {
		super();
	}

}
