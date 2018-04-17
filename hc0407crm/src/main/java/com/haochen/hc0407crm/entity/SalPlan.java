package com.haochen.hc0407crm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �ͻ������ƻ���
 * 
 * @author lzm
 *
 */
public class SalPlan {
	
	/**
	 * �ƻ����
	 */
	private Integer plaId;			
	
	/**
	 * �������۶���
	 */
	private SalChance salChance;
	
	/**
	 * ����
	 */
	private Date plaDate;			
	
	/**
	 * �ƻ���
	 */
	private String plaTodo;			
	
	/**
	 * ִ�н��
	 */
	private String plaResult;	

	public Integer getPlaId() {
		return plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}

	public SalChance getSalChance() {
		return salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public String getPlaDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = null;
		date = sdf.format(plaDate);
		return date;
	}

	public void setPlaDate(Date plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

	public SalPlan(Integer plaId, SalChance salChance, Date plaDate, String plaTodo, String plaResult) {
		super();
		this.plaId = plaId;
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	public SalPlan() {
		super();
	}

}
