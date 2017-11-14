package com.telit.springboot.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telit.springboot.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 5384212692354556792L;

	// 当前页码
	private int pageNum;

	// 每页条数
	private int pageSize;

	// 总页数
	private Integer totalPages;

	// 总记录数
	private Long total;

	// 内容
	private List<T> content;

	// 获取到内容
	private boolean hasContent;

	// 请求url
	private String url;

	// 请求uri
	private String uri;

	// 请求url参数
	private String params;

	public Page() {
		this.pageNum = 0;
		this.pageSize = 0;
		this.totalPages = 0;
		this.total = 0L;
		this.content = new ArrayList<T>();
		this.hasContent = false;
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.
//				getRequestAttributes()).getRequest();
//		this.url = request.getRequestURL().toString();
//		this.uri = request.getRequestURI();
//		this.params = request.getQueryString();
	}

	public Page(int pageNum, int pageSize, int totalPages, Long total, List<T> content) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.total = total;
		this.content = content;
		this.hasContent = !StringUtil.isEmpty(content) && content.size() > 0;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
				getRequestAttributes()).getRequest();
		this.url = request.getRequestURL().toString();
		this.uri = request.getRequestURI();
		this.params = request.getQueryString();
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHasContent() {
		return hasContent;
	}

	public void setHasContent(boolean hasContent) {
		this.hasContent = hasContent;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@JsonProperty
	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	@JsonProperty
	public Long getTotal() {
		return total;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
}