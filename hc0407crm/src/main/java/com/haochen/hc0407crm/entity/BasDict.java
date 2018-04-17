package com.haochen.hc0407crm.entity;

/**
 * �ֵ��
 * @author lzm
 *
 */
public class BasDict {
	/**
	 * ���
	 */
	private Integer dictId;	
	
	/**
	 * ���
	 */
	private String dictType;
	
	/**
	 * ��Ŀ
	 */
	private String dictItem;
	
	/**
	 * ֵ
	 */
	private String dictValue;
	
	/**
	 * ��ɱ༭ 1-���ԣ�0-������
	 */
	private Integer dictIsEdiTable;
	
	/**
	 * ״̬��0-������1-ɾ��
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
	/*��-128 �� 127 ��Integer���󴴽���,��������cache������,
	һ���������valueOf ����,���i��ֵ����-128 �� 127 ֮��
	��ֱ����cache����������ȥȡ,���Ե�һ���������true,
	���ڶ����������´�������,����Ϊfalse*/
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

	}
	
}



