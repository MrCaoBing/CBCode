package com.haochen.hc0407crm.entity;

/**
 * @author Mr.Cao
 * @date 2018年1月14日 下午6:17:06
 */
public class CustAccounted {
	private String custNo;
	private String custId;
	private String name;
	private String y;
	/**
	 * @return the custNo
	 */
	public String getCustNo() {
		return custNo;
	}
	/**
	 * @param custNo the custNo to set
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(String y) {
		this.y = y;
	}
	
	
	/**
	 * 
	 */
	public CustAccounted() {
		super();
	}
	/**
	 * @param custNo
	 * @param custId
	 * @param name
	 * @param y
	 */
	public CustAccounted(String custNo, String custId, String name, String y) {
		super();
		this.custNo = custNo;
		this.custId = custId;
		this.name = name;
		this.y = y;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustAccounted [" + (custNo != null ? "custNo=" + custNo + ", " : "")
				+ (custId != null ? "custId=" + custId + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (y != null ? "y=" + y : "") + "]";
	}
	
	
}
