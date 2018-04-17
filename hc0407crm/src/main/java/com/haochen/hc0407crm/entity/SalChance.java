package com.haochen.hc0407crm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 销售机会表
 * 
 * @author lzm
 *
 */
public class SalChance {

	/**
	 * 编号
	 */
	private Integer chcId;

	/**
	 * 机会来源
	 */
	private String chcSource;

	/**
	 * 客户名称
	 */
	private String chcCustName;

	/**
	 * 概要
	 */
	private String chcTitle;

	/**
	 * 成功机率
	 */
	private Integer chcRate;

	/**
	 * 联系人
	 */
	private String chcLinkman;

	/**
	 * 联系电话(固定)
	 */
	private String chcTel;

	/**
	 * 联系人手机
	 */
	private String chcMobile;

	/**
	 * 机会描述
	 */
	private String chcDesc;

	/**
	 * 创建人对象
	 */
	private SysUser chcCreateUser;

	/**
	 * 创建时间
	 */
	private Date chcCreateDate;

	/**
	 * 指派的客户经理对象
	 */
	private SysUser chcDueUser;

	/**
	 * 指派时间
	 */
	private Date chcDueDate;

	/**
	 * 状态：1--未指派；2--已指派3--开发成功；4--终止开发(开发失败)。
	 */
	private String chcStatus;

	public Integer getChcId() {
		return chcId;
	}

	public void setChcId(Integer chcId) {
		this.chcId = chcId;
	}

	public String getChcSource() {
		return chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public Integer getChcRate() {
		return chcRate;
	}

	public void setChcRate(Integer chcRate) {
		this.chcRate = chcRate;
	}

	public String getChcLinkman() {
		return chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcTel() {
		return chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	public String getChcMobile() {
		return chcMobile;
	}

	public void setChcMobile(String chcMobile) {
		this.chcMobile = chcMobile;
	}

	public String getChcDesc() {
		return chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	public SysUser getChcCreateUser() {
		return chcCreateUser;
	}

	public void setChcCreateUser(SysUser chcCreateUser) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.chcCreateUser = chcCreateUser;
	}

	public String getChcCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = null;
		try {
			date = sdf.format(chcCreateDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public void setChcCreateDate(Date chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	public SysUser getChcDueUser() {
		return chcDueUser;
	}

	public void setChcDueUser(SysUser chcDueUser) {
		this.chcDueUser = chcDueUser;
	}

	public String getChcDueDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = null;
		try {
			date = sdf.format(chcDueDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}

	public void setChcDueDate(Date chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	public String getChcStatus() {
		return chcStatus;
	}

	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}

	public SalChance(Integer chcId, String chcSource, String chcCustName, String chcTitle, Integer chcRate,
			String chcLinkman, String chcTel, String chcMobile, String chcDesc, SysUser chcCreateUser,
			Date chcCreateDate, SysUser chcDueUser, Date chcDueDate, String chcStatus) {
		super();
		this.chcId = chcId;
		this.chcSource = chcSource;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcMobile = chcMobile;
		this.chcDesc = chcDesc;
		this.chcCreateUser = chcCreateUser;
		this.chcCreateDate = chcCreateDate;
		this.chcDueUser = chcDueUser;
		this.chcDueDate = chcDueDate;
		this.chcStatus = chcStatus;
	}

	public SalChance() {
		super();
	}

}
