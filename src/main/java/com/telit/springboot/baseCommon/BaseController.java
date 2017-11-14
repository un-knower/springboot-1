package com.telit.springboot.baseCommon;

import com.telit.springboot.util.StringUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    /**
     * 分页参数设置
     */
    public PageRequest getPageable() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String pageNumStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("rows");
        Integer pageNum = null;
        Integer pageSize = null;

        try {
            pageNum = Integer.parseInt(pageNumStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            pageSize = Integer.parseInt(pageSizeStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return new PageRequest(pageNum, pageSize);
    }

    /**
     * 分页参数设置，含排序方式
     */
    public PageRequest getPageable(Sort sort) {
        PageRequest pageable = getPageable();
        return new PageRequest(pageable.getPageNumber(),
                pageable.getPageSize(), sort);
    }
}
