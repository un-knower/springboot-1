package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.RecipeModel;
import com.telit.springboot.web.model.RecipeTypeModel;

import java.util.List;

public interface RecipeService extends BaseService<RecipeModel,String>{
    public void saveAll(RecipeModel recipeModel, RecipeTypeModel recipeTypeModel)throws Exception;
//    public List<Object[]> findByWeekly(String weekly);
//    public List<Object[]> findByMealType(String mealType);
    public List<Object[]> findByFoodName(String foodName);
}
