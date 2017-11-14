package com.telit.springboot.filter;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 排序
 */
public class Sequencer {
	
	public Sequencer() {
		
	}

	/**
     * 升序
     */
    public static Sort asc(String property) {
        return new Sort(Direction.ASC, property);
    }
    
    /**
     * 降序
     */
    public static Sort desc(String property) {
        return new Sort(Direction.DESC, property);
    }
    
}
