package com.haochen.hc0407crm.entity;

/**
 * 字典表
 * @author lzm
 *
 */
public class BasDict {
	/**
	 * 编号
	 */
	private Integer dictId;	
	
	/**
	 * 类别
	 */
	private String dictType;
	
	/**
	 * 条目
	 */
	private String dictItem;
	
	/**
	 * 值
	 */
	private String dictValue;
	
	/**
	 * 否可编辑 1-可以；0-不可以
	 */
	private Integer dictIsEdiTable;
	
	/**
	 * 状态：0-正常、1-删除
	 */
	private Integer dictStatus;		

	public Integer getDictId() {
		return dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public Integer getDictIsEdiTable() {
		return dictIsEdiTable;
	}

	public void setDictIsEdiTable(Integer dictIsEdiTable) {
		this.dictIsEdiTable = dictIsEdiTable;
	}

	public Integer getDictStatus() {
		return dictStatus;
	}

	public void setDictStatus(Integer dictStatus) {
		this.dictStatus = dictStatus;
	}

	public BasDict(Integer dictId, String dictType, String dictItem, String dictValue, Integer dictIsEdiTable,
			Integer dictStatus) {
		super();
		this.dictId = dictId;
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEdiTable = dictIsEdiTable;
		this.dictStatus = dictStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BasDict [" + (dictId != null ? "dictId=" + dictId + ", " : "")
				+ (dictType != null ? "dictType=" + dictType + ", " : "")
				+ (dictItem != null ? "dictItem=" + dictItem + ", " : "")
				+ (dictValue != null ? "dictValue=" + dictValue + ", " : "")
				+ (dictIsEdiTable != null ? "dictIsEdiTable=" + dictIsEdiTable + ", " : "")
				+ (dictStatus != null ? "dictStatus=" + dictStatus : "") + "]";
	}
	
	public static void main(String[] args) {
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
	/*将-128 到 127 的Integer对象创建了,并保存在cache数组中,
	一旦程序调用valueOf 方法,如果i的值是在-128 到 127 之间
	就直接在cache缓存数组中去取,所以第一个输出的是true,
	而第二个这是重新创建对象,所以为false*/
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

	}
	
}



