package com.ht.model.filters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pagination {
	
	private Integer current = 0;
	private Integer recordPage = 15;
	private Integer recordTotal = 0;
	private Integer recordOffset = 0;
	private List<?> list;
	private Map<String,Object> params=new HashMap<>();
	
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getSize() {
		return (int) Math.ceil(this.recordTotal / 1.0 / this.recordPage);
	}

	public Integer getRecordPage() {
		return recordPage;
	}
	public void setRecordPage(Integer recordPage) {
		this.recordPage = recordPage;
	}
	public Integer getRecordLow() {
		return this.current * this.recordPage + 1;
	}

	public Integer getRecordHigh() {
		Integer high = this.current * this.recordPage + this.recordPage;
		if(high > this.recordTotal){
			return this.recordTotal;
		} else {
			return high;
		}
	}

	public Integer getRecordTotal() {
		return recordTotal;
	}
	public void setRecordTotal(Integer recordTotal) {
		this.recordTotal = recordTotal;
	}
	public Integer getRecordOffset() {
		return recordOffset;
	}
	public void setRecordOffset(Integer recordOffset) {
		this.recordOffset = recordOffset;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
