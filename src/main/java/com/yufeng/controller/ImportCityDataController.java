package com.yufeng.controller;

import com.yufeng.service.ImportCityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


/**
 * Created by fishyu on 16/7/26.
 */
@RestController
public class ImportCityDataController {

    @Autowired
    private ImportCityDataService importCityDataService;

    
    @RequestMapping("insertCityHousePrice")
    public void insertCityHousePrice(@RequestParam("filePath") String filePath) throws ParseException{

    	importCityDataService.insertCityHousePrice(filePath);

    }
    
    
    @RequestMapping("insertCitySalaryCoefficient")
    public void insertCitySalaryCoefficient(@RequestParam("filePath") String filePath) throws ParseException{

    	importCityDataService.insertCitySalaryCoefficient(filePath);

    }


}
