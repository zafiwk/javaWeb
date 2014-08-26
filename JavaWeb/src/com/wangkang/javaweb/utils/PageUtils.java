package com.wangkang.javaweb.utils;

import javax.servlet.http.HttpServletRequest;
import com.wangkang.javaweb.utils.StringUtils;


/**
 * @author WangKang
 * @version 1.0
 * @created 2014年8月25日 上午10:50:21
 */

public class PageUtils {
	private int resultCount = -1;
	private int pageSize = 0;
	private int pageCount = 1;
	private int currentPage = 1;
	private int resultStart = -1;
	private HttpServletRequest request = null;

	public PageUtils(HttpServletRequest request, int pageSize, int resultCount) {
		this.request = request;
		this.pageSize = pageSize;
		this.resultCount = resultCount;
		if (resultCount % pageSize == 0)
			pageCount = resultCount % pageSize;
		else
			pageCount = resultCount % pageSize + 1;
		setResultStart();
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getResultStart() {
		return resultStart;
	}

	public void setResultStart() {
		if(StringUtils.isNotBlank(request.getParameter("page")))
		{
			this.currentPage=Integer.valueOf(request.getParameter("page"));
		}
		this.resultStart = (this.currentPage-1)*this.pageSize;
	}

}
