package com.telit.springboot.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUtil {

    /**
     * 对象转集合
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> oneToList(T t){
        return new ArrayList<T>(){{
            this.add(t);
        }};
    }

    /**
     * 数组转map
     * @param obj 数组[]
     * @param strings map的key
     * @return
     */
    public static Map<String,Object> objectToMap(Object[] obj,String ... strings){
        Map<String,Object> map=new HashMap<String,Object>();
        for(int i=0;i<obj.length;i++){
            map.put(strings[i],obj[i]);
        }
        return map;
    }

    public static List<Object[]> isEmpty(List<Object[]> list){
        boolean flag=false;
        for(Object[] obj:list){
            for(int i=0;i<obj.length;i++){
                if(BeanUtil.isNotEmpty(obj[i])){
                    flag=true;
                }
            }
        }
        if(flag){
            return list;
        }
        return null;
    }

}
