package com.telit.springboot.filter;

import java.util.List;

public class DataGrid<T> implements java.io.Serializable {

    private static final long serialVersionUID = -4438072298270206027L;
    private int total;// 总记录数
    private List<T> rows;// 每页记录
    private int pageNumber;//当前页
    private int totalPage;//总页数
    public DataGrid(int total,int pageNumber, List<T> rows){
        this.total=total;
        this.pageNumber=pageNumber;
        this.rows=rows;
    }
    public int getTotal() {
        return total;
    }
    public List<T> getRows() {
        return rows;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
