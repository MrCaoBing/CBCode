package com.haochen.hc0407crm.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 分页工具类,适应layui
 * @author Mr.Cao
 *
 */
public class Paging<T> {
		/**
		 * 总页数
		 */
		private int pageCount;
		/**
		 * 每页显示数
		 */
		private int limit;
		/**
		 * 总数
		 */
		private int count;
		/**
		 * 当前页,默认为1
		 */
		private int page;		
		/**
		 * 封装分页数据
		 */
		private List<T> data;		
		/**
		 * 分页条件
		 */
		private Map<String,Object> map = new HashMap<String,Object>();
	
		@SuppressWarnings( "rawtypes" )
		private Map resultMap = new HashMap();

	
		/**
		 * 设置数据总数据行数得到总页数
		 * @param count
		 */
		public void setCount(int count) {
			this.count = count;
			// 总页数等于总记录数除以每页显示的记录数,除不尽则加1
			if (limit > 0)
			this.pageCount = this.count % this.limit == 0 ? this.count / this.limit : this.count / this.limit + 1;							
		}
		
		/**
		 * 返回总数据行数
		 * @return
		 */
		public int getCount() {
			return count;
		}	
		
		/**
		 * 获取数据当前页码
		 * @return
		 */
		public int getPage() {
			//如果当前页大于尾页则设置当前页为尾页,如果当前页小于1则设置当前页为首页
			if (page > pageCount) {
				page = pageCount;
			} else if (page < 1) {
				page = 1;
			}
			return limit * (page - 1);
		}
		
		/**	
		 * 设置当前页
		 * @param page
		 */
		public void setPage(int page) {			
			this.page = page;			
		}
		
		/**
		 * 返回每页显示的数据数
		 * @return
		 */
		public int getLimit() {
			return limit;
		}
		
		/**
		 * 设置每页显示的数据数
		 * @return
		 */
		public void setLimit(int limit) {
			this.limit = limit;
		}	
		
		/**
		 * 得到分页对象
		 */
		public List<T> getData() {
			return data;
		}

		/**
		 * 注入分页对象
		 */
		public void setData(List<T> data) {
			this.data = data;
		}
		
		/**
		 * 得到条件
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
		 * 输入条件
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
		 * 当前分页类信息
		 */
		@Override
		public String toString() {
			return "Paging [pageCount=" + pageCount + ", limit=" + limit + ", count=" + count + ", page=" + page
					+ ", " + (data != null ? "data=" + data + ", " : "") + (map != null ? "map=" + map : "") + "]";
		}		
			
}