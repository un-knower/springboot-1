package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.TmodeUrgentContent;

public interface TmodeUrgentContentService extends BaseService<TmodeUrgentContent,String>{
    public Object getContent(String urgentId);
}
