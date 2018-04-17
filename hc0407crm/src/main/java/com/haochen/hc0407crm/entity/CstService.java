package com.haochen.hc0407crm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户服务表
 * 
 * @author lzm
 *
 */
public class CstService {

	/**
	 * 服务编号
	 */
	private Integer svrId;

	/**
	 * 服务类型
	 */
	private String svrType;

	/**
	 * 服务概要
	 */
	private String svrTitle;

	/**
	 * 客户对象
	 */
	private CstCustomer svrCustCustomer;

	/**
	 * 服务状态1,2,3
	 */
	private String svrStatus;

	/**
	 * 服务请求
	 */
	private String svrRequest;

	/**
	 * 创建人对象
	 */
	private SysUser svrCreateUser;

	/**
	 * 创建日期
	 */
	private Date svrCreateDate;

	/**
	 * 经理对象
	 */
	private SysUser svrDueUser;

	/**
	 * 分配时间
	 */
	private Date svrDueDate;

	/**
	 * 服务处理
	 */
	private String svrDeal;

	/**
	 * 处理日期
	 */
	private Date svrDealDate;

	/**
	 * 处理结果
	 */
	private String svrResult;

	/**
	 * 满意度
	 */
	private Integer svrSatisfy;

	public Integer getSvrId() {
		return svrId;
	}

	public void setSvrId(Integer svrId) {
		this.svrId = svrId;
	}

	public String getSvrType() {
		return svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	public String getSvrTitle() {
		return svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	public CstCustomer getSvrCustCustomer() {
		return svrCustCustomer;
	}

	public void setSvrCustCustomer(CstCustomer svrCustCustomer) {
		this.svrCustCustomer = svrCustCustomer;
	}

	public String getSvrStatus() {
		return svrStatus;
	}

	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}

	public String getSvrRequest() {
		return svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	public SysUser getSvrCreateUser() {
		return svrCreateUser;
	}

	public void setSvrCreateUser(SysUser svrCreateUser) {
		this.svrCreateUser = svrCreateUser;
	}

	public String getSvrCreateDate() {
		String date = null;
		if (svrCreateDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");			
			try {
				date = sdf.format(svrCreateDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public void setSvrCreateDate(Date svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	public SysUser getSvrDueUser() {
		return svrDueUser;
	}

	public void setSvrDueUser(SysUser svrDueUser) {
		this.svrDueUser = svrDueUser;
	}

	public String getSvrDueDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = null;
		try {
			date = sdf.format(svrDueDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public void setSvrDueDate(Date svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	public String getSvrDeal() {
		return svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	public String getSvrDealDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = null;
		try {
			date = sdf.format(svrDealDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public void setSvrDealDate(Date svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	public String getSvrResult() {
		return svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	public Integer getSvrSatisfy() {
		return svrSatisfy;
	}

	public void setSvrSatisfy(Integer svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

	public CstService(Integer svrId, String svrType, String svrTitle, CstCustomer svrCustCustomer, String svrStatus,
			String svrRequest, SysUser svrCreateUser, Date svrCreateDate, SysUser svrDueUser, Date svrDueDate,
			String svrDeal, Date svrDealDate, String svrResult, Integer svrSatisfy) {
		super();
		this.svrId = svrId;
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrCustCustomer = svrCustCustomer;
		this.svrStatus = svrStatus;
		this.svrRequest = svrRequest;
		this.svrCreateUser = svrCreateUser;
		this.svrCreateDate = svrCreateDate;
		this.svrDueUser = svrDueUser;
		this.svrDueDate = svrDueDate;
		this.svrDeal = svrDeal;
		this.svrDealDate = svrDealDate;
		this.svrResult = svrResult;
		this.svrSatisfy = svrSatisfy;
	}

	public CstService() {
		super();
	}

}
