package com.haochen.hc0407crm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户开发计划表
 * 
 * @author lzm
 *
 */
public class SalPlan {
	
	/**
	 * 计划编号
	 */
	private Integer plaId;			
	
	/**
	 * 机会销售对象
	 */
	private SalChance salChance;
	
	/**
	 * 日期
	 */
	private Date plaDate;			
	
	/**
	 * 计划项
	 */
	private String plaTodo;			
	
	/**
	 * 执行结果
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
