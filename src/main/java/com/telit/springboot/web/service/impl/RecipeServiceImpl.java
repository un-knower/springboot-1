package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.dao.EduPositionDao;
import com.telit.springboot.web.dao.RecipeDao;
import com.telit.springboot.web.model.RecipeModel;
import com.telit.springboot.web.model.RecipeTypeModel;
import com.telit.springboot.web.service.RecipeService;
import com.telit.springboot.web.service.RecipeTypeService;
import com.telit.springboot.web.service.TelitSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Service("recipeServiceImpl")
public class RecipeServiceImpl extends BaseServiceImpl<RecipeModel,String> implements RecipeService{


    @Autowired
    private RecipeDao recipeDao;

    @Resource(name = "recipeTypeServiceImpl")
    private RecipeTypeService recipeTypeService;

    @Resource(name="recipeDao")
    public void setBaseDao(RecipeDao recipeDao){
        super.setBaseDao(recipeDao);
    }

    @Transient
    public void saveAll(RecipeModel recipeModel, RecipeTypeModel recipeTypeModel)throws Exception{
        RecipeModel recipe= recipeDao.save(recipeModel);
        if(StringUtil.isNotEmpty(recipe.getId())){
            recipeTypeModel.setRecipeId(recipe.getId());
            recipeTypeService.save(recipeTypeModel);
        }
    }
//    public List<Object> findByWeekly(String weekly){
//        return recipeDao.findByWeekly(weekly);
//    }
//    public List<Object> findByMealType(String mealType){
//        return recipeDao.findByMealType(mealType);
//    }
    public List<Object[]> findByFoodName(String foodName){

        return recipeDao.findByFoodName(foodName);
    }
}
