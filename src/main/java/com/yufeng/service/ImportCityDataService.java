package com.yufeng.service;

import java.util.List;

/**
 * Created by fishyu on 16/7/26.
 */
public interface ImportCityDataService {
    
    void insertCityHousePrice(String filePath);
    List<String> readTxtFile(String filePath);
    void insertCitySalaryCoefficient(String filePath);
}
