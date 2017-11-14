package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.RecipeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeDao extends BaseDao<RecipeModel,String>{
    @Query(value = "SELECT r.`id` AS 'id', rt.id AS  'tId',r.`school_id` AS'schoolId',r.`weekly` AS 'weekly'," +
            " rt.`food_name` AS'foodName',rt.`meal_type` AS'mealType',rt.`photo`AS'photo'," +
            " rt.`food_desc` AS 'foodDesc',rt.`create_date` AS'createDate'" +
            " FROM t_recipe r LEFT JOIN t_recipe_type rt ON r.`id`=rt.`recipe_id`" +
            " WHERE rt.`food_name`LIKE %:foodName% ORDER BY r.weekly,rt.meal_type,rt.create_date",nativeQuery = true)
    public List<Object[]> findByFoodName(@Param("foodName") String foodName);
}
