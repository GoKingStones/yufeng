package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.CityCode;
import com.yufeng.entity.CityHousePrice;

/**
 * Created by fishyu on 16/7/26
 */
public interface CityDataDao {

	List<CityCode> getCityCodeByCityName(String cityName);
    int insertCityHousePriceTable(CityHousePrice cityHousePrice);
   
}