package com.telit.springboot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PaginationUtil {

	public static final Integer START_PAGE=1;
	
	//页面大小
	public static final Integer PAGE_SIZE=10;
	
	public static final Integer PAGE_SIZE_MAX=20;
	
	/**
	 * 模拟分页，根据页码和分页大小显示对应数据
	 * @param list			待显示的数据集合
	 * @param currentPage 	当前页
	 * @param pageSize	  	每页大小
	 * @return
	 */
	@SuppressWarnings("hiding")
	public  static <T> Map<String, Object> pageMap(List<T> list,Integer currentPage,Integer pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		List<T> newList=new ArrayList<T>();
		if(list!=null?list.size()>0:false){
			if(currentPage==null||currentPage==0){
				currentPage=START_PAGE;
				if(list.size()<pageSize){
					for(int i=0;i<list.size();i++){
						newList.add(list.get(i));
					}
				}else{
					for(int i=0;i<pageSize;i++){
						newList.add(list.get(i));
					}
				}
			}else if(currentPage!=null){
				if(list.size()<pageSize){
					for(int i=0;i<list.size();i++){
						newList.add(list.get(i));
					}
				}else{
					for(int i=(currentPage-1)*pageSize;i<(currentPage*pageSize>list.size()?list.size():currentPage*pageSize);i++){
						newList.add(list.get(i));
					}
				}		
			}
			//总页数
			map.put("totalPage", list.size()%pageSize==0?list.size()/pageSize:list.size()/pageSize+1);
			//总记录数
			map.put("count",list.size());
		}else{
			//总页数
			map.put("totalPage",1);
			//总记录数
			map.put("count",0);
		}
		//待显示的数据集合
		map.put("newList", newList);
		//当前页数
		map.put("currentPage", currentPage);
		//页面大小
		map.put("pageSize", pageSize);
		return map;
	}
}
