package com.haochen.hc0407crm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ۻ����
 * 
 * @author lzm
 *
 */
public class SalChance {

	/**
	 * ���
	 */
	private Integer chcId;

	/**
	 * ������Դ
	 */
	private String chcSource;

	/**
	 * �ͻ�����
	 */
	private String chcCustName;

	/**
	 * ��Ҫ
	 */
	private String chcTitle;

	/**
	 * �ɹ�����
	 */
	private Integer chcRate;

	/**
	 * ��ϵ��
	 */
	private String chcLinkman;

	/**
	 * ��ϵ�绰(�̶�)
	 */
	private String chcTel;

	/**
	 * ��ϵ���ֻ�
	 */
	private String chcMobile;

	/**
	 * ��������
	 */
	private String chcDesc;

	/**
	 * �����˶���
	 */
	private SysUser chcCreateUser;

	/**
	 * ����ʱ��
	 */
	private Date chcCreateDate;

	/**
	 * ָ�ɵĿͻ��������
	 */
	private SysUser chcDueUser;

	/**
	 * ָ��ʱ��
	 */
	private Date chcDueDate;

	/**
	 * ״̬��1--δָ�ɣ�2--��ָ��3--�����ɹ���4--��ֹ����(����ʧ��)��
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
