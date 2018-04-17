package com.haochen.hc0407crm.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ��ҳ������,��Ӧlayui
 * @author Mr.Cao
 *
 */
public class Paging<T> {
		/**
		 * ��ҳ��
		 */
		private int pageCount;
		/**
		 * ÿҳ��ʾ��
		 */
		private int limit;
		/**
		 * ����
		 */
		private int count;
		/**
		 * ��ǰҳ,Ĭ��Ϊ1
		 */
		private int page;		
		/**
		 * ��װ��ҳ����
		 */
		private List<T> data;		
		/**
		 * ��ҳ����
		 */
		private Map<String,Object> map = new HashMap<String,Object>();
	
		@SuppressWarnings( "rawtypes" )
		private Map resultMap = new HashMap();

	
		/**
		 * �������������������õ���ҳ��
		 * @param count
		 */
		public void setCount(int count) {
			this.count = count;
			// ��ҳ�������ܼ�¼������ÿҳ��ʾ�ļ�¼��,���������1
			if (limit > 0)
			this.pageCount = this.count % this.limit == 0 ? this.count / this.limit : this.count / this.limit + 1;							
		}
		
		/**
		 * ��������������
		 * @return
		 */
		public int getCount() {
			return count;
		}	
		
		/**
		 * ��ȡ���ݵ�ǰҳ��
		 * @return
		 */
		public int getPage() {
			//�����ǰҳ����βҳ�����õ�ǰҳΪβҳ,�����ǰҳС��1�����õ�ǰҳΪ��ҳ
			if (page > pageCount) {
				page = pageCount;
			} else if (page < 1) {
				page = 1;
			}
			return limit * (page - 1);
		}
		
		/**	
		 * ���õ�ǰҳ
		 * @param page
		 */
		public void setPage(int page) {			
			this.page = page;			
		}
		
		/**
		 * ����ÿҳ��ʾ��������
		 * @return
		 */
		public int getLimit() {
			return limit;
		}
		
		/**
		 * ����ÿҳ��ʾ��������
		 * @return
		 */
		public void setLimit(int limit) {
			this.limit = limit;
		}	
		
		/**
		 * �õ���ҳ����
		 */
		public List<T> getData() {
			return data;
		}

		/**
		 * ע���ҳ����
		 */
		public void setData(List<T> data) {
			this.data = data;
		}
		
		/**
		 * �õ�����
		 */
		@SuppressWarnings("rawtypes")
		public Map getMap() {
			Set<String> set = map.keySet();
			for (String s : set) {
				if("".equals(map.get(s))) {
					map.put(s, null);
				}				
			}
			return map;
		}


		/**
		 * ��������
		 */
		@SuppressWarnings("rawtypes")
		public void setMap(Map map) {
			this.map = map;
		}
		
		
		/**
		 * @return the resultMap
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Map getResultMap() {
			resultMap.put("msg", "");
			resultMap.put("code", 0);	
			resultMap.put("count", this.getCount());
			resultMap.put("data", this.getData());			
			return resultMap;
		}

		

		/**
		 * ��ǰ��ҳ����Ϣ
		 */
		@Override
		public String toString() {
			return "Paging [pageCount=" + pageCount + ", limit=" + limit + ", count=" + count + ", page=" + page
					+ ", " + (data != null ? "data=" + data + ", " : "") + (map != null ? "map=" + map : "") + "]";
		}		
			
}