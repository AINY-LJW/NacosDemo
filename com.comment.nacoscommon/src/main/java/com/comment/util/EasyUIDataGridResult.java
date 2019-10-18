package com.comment.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 * ClassName: EasyUIDataGridResult <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年10月28日 下午3:52:21 <br/> 
 * 
 * @author lijiawen
 * @version  
 * @since JDK 1.7
 */
public class EasyUIDataGridResult implements Serializable{

	private static final long serialVersionUID = 1L;
	private long total;
	private List rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}

