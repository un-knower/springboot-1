package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.RecipeDao;
import com.telit.springboot.web.dao.RecipeTypeDao;
import com.telit.springboot.web.model.RecipeTypeModel;
import com.telit.springboot.web.service.RecipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("recipeTypeServiceImpl")
public class RecipeTypeServiceImpl extends BaseServiceImpl<RecipeTypeModel,String>implements RecipeTypeService{

    @Autowired
    private RecipeTypeDao recipeTypeDao;

    @Resource(name="recipeTypeDao")
    public void setBaseDao(RecipeTypeDao recipeTypeDao){
        super.setBaseDao(recipeTypeDao);
    }

    @Transactional
    public void recipeDel(List<String> idList)throws Exception{
        if(idList!=null&&idList.size()>0){
            for(String id:idList){
                recipeTypeDao.delete(id);
            }
        }
    }
}
