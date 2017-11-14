package com.telit.springboot.util;

import java.util.List;

public class ResultMsg<T> {
	public static final int SUCCESS = 1;
	public static final int FAULT = 0;

	private int success;
	private String msg;
	private List<T> list;
	
	public ResultMsg(){
	}
	public  ResultMsg(int success,String msg, List<T> list){
		this.success = success;
		this.msg = msg;
		this.list=list;
	}

	public static <T> ResultMsg success(List<T> list){
		return new ResultMsg(SUCCESS,"成功",list);
	}
	public static <T>ResultMsg sussess(String msg,List<T> list){
		return new ResultMsg(SUCCESS,msg,list);
	}

	public static ResultMsg fault(String msg){
		return new ResultMsg(FAULT,msg,null);
	}
	public static ResultMsg fault(){
		return new ResultMsg(FAULT,"失败",null);
	}

	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
