package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.RecipeTypeModel;

import java.util.List;

public interface RecipeTypeService extends BaseService<RecipeTypeModel,String>{
    public void recipeDel(List<String> idList)throws Exception;
}
