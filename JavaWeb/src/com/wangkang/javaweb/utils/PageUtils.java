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
	
	private int startPage=1;
	private int endPage=5;
	private HttpServletRequest request = null;

	public PageUtils(HttpServletRequest request, int pageSize) {
		this.request = request;
		this.pageSize = pageSize;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
		if (resultCount % pageSize == 0)
			pageCount = resultCount / pageSize;
		else
			pageCount = resultCount / pageSize + 1;
		setResultStart();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		if (resultCount % pageSize == 0)
			pageCount = resultCount / pageSize;
		else
			pageCount = resultCount / pageSize + 1;
		setResultStart();
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
		    this.startPage=this.startPage+this.currentPage;
			this.endPage=this.endPage+this.currentPage;
			
		}
		if(this.endPage>this.pageCount)
		{
			this.endPage=this.pageCount+1;
			this.startPage=this.endPage-5;
		}
		if(this.startPage<1)
			this.startPage=1;
		this.resultStart = (this.currentPage-1)*this.pageSize;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public int getEndPage()
	{
		return endPage;
	}
	
/*	<div class="pager">
	<ul class="clearfix">
	<c:if test="${pageUtils.currentPage>1 }">
	<li><a href="#">上一页</a></li>
	</c:if>
	<c:forEach   begin="${pageUtils.startPage }"    end="${pageUtils.endPage }" var="page">
		<c:if test="${page==pageUtils.currentPage }">
				<li class="current">${page }</li>
		</c:if>
		<c:if test="${page!=pageUtils.currentPage }">
				<li >${page }</li>
		</c:if>
    </c:forEach>
    <c:if test="${pageUtils.currentPage<pageUtils.pageCount }">
	<li><a href="#">下一页</a></li>
	</c:if>
	</ul>
</div>
</div>*/
/*css
.pager { margin-top:15px; }
.pager ul { float:right; }
.pager ul li { float:left; border:1px solid #eee; line-height:18px; padding:0 3px; margin:0 1px; display:inline; }
.pager ul li.current { font-weight:bold; color:#630; }*/
}
