package com.yufeng.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yufeng.dao.CityDataDao;
import com.yufeng.entity.CityCode;
import com.yufeng.entity.CityConsumptionLevel;
import com.yufeng.entity.CityHousePrice;
import com.yufeng.entity.CitySalaryCoefficient;
import com.yufeng.service.ImportCityDataService;

public class ImportCityDataServiceimpl implements ImportCityDataService{

	/**
	 * Created by fishyu on 16/7/26.
	 */
	
    @Autowired
    private CityDataDao cityDataDao;
	
    public List<String> readTxtFile(String filePath){
    	
    	
    	List<String> dataList = new ArrayList<String>();
    	
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	dataList.add(lineTxt);
                    }
                    read.close();
                    
                    return dataList;
                    
        }else{
            System.out.println("找不到指定的文件");
            return null;
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
            return null;
        }
     
    }
    
    
    public void insertCityHousePrice(String filePath){
    	
    	List<String> listHousePrice = readTxtFile(filePath);
    	
    	if(listHousePrice!=null){
    		
    		for(String housePrice:listHousePrice){
    			
    			System.out.println(housePrice);
    			
    			String[] houseAndPrice = housePrice.split("\\s+");
    			
    			System.out.println(houseAndPrice[0]);
    			
    			List<CityCode> cityCodeList = cityDataDao.getCityCodeByCityName(houseAndPrice[0]);
    			
    			for(CityCode cityCodetmp:cityCodeList){
    					
    				CityHousePrice cityHousePriceTmp = new CityHousePrice();
        			
        			cityHousePriceTmp.setCityCode(cityCodetmp.getCityCode());
        			cityHousePriceTmp.setHousePrice(houseAndPrice[1].replaceAll("[^0-9]", ""));
        			cityHousePriceTmp.setDataPeriod(filePath.substring(filePath.lastIndexOf("/")+1));
        			
        			System.out.println("城市编码："+cityCodetmp.getCityCode()+";房屋均价："+houseAndPrice[1].replaceAll("[^0-9]", ""));
        			
        			cityDataDao.insertCityHousePriceTable(cityHousePriceTmp);
    			}
    			
    		}
    	}
    	
    }
    
    
    public void insertCitySalaryCoefficient(String filePath){
    	
    	
    	Map<String,String> citySalaryCoefficientMap = new HashMap<String,String>();
    	
    	List<String> listCitySalaryCoefficient = readTxtFile(filePath);
    	
    	if(listCitySalaryCoefficient!=null){
    		
    		for(String citySalaryCoefficient:listCitySalaryCoefficient){
    			
    			System.out.println(citySalaryCoefficient);
    			
    			String[] citySalaryCoefficientArray = citySalaryCoefficient.split("\\s+");
    			
    			citySalaryCoefficientMap.put(citySalaryCoefficientArray[1], citySalaryCoefficientArray[2]);
    			
    		}
    	}
    	
    	List<CityCode> cityCodeList = cityDataDao.getCityCode();
    	
    	for(CityCode tmpCityCode:cityCodeList){
    		
    		CitySalaryCoefficient citySalaryCoefficient = new CitySalaryCoefficient();
    		
    		
    		if(tmpCityCode.getCityName().contains("市")&&citySalaryCoefficientMap.containsKey(tmpCityCode.getCityName().substring(0, tmpCityCode.getCityName().indexOf("市")))){    			
    			
    			citySalaryCoefficient.setCityCode(tmpCityCode.getCityCode());
    			citySalaryCoefficient.setSalaryCoefficient(citySalaryCoefficientMap.get(tmpCityCode.getCityName().substring(0, tmpCityCode.getCityName().indexOf("市"))));
    			citySalaryCoefficient.setDataPeriod(filePath.substring(filePath.lastIndexOf("/")+1));
    			
    			cityDataDao.insertCitySalaryCoefficient(citySalaryCoefficient);
    			
    		}else{
    			
    			if(citySalaryCoefficientMap.containsKey(tmpCityCode.getProvinceName())){
    				
    				citySalaryCoefficient.setCityCode(tmpCityCode.getCityCode());
        			citySalaryCoefficient.setSalaryCoefficient(citySalaryCoefficientMap.get(tmpCityCode.getProvinceName()));
        			citySalaryCoefficient.setDataPeriod(filePath.substring(filePath.lastIndexOf("/")+1));
        			
        			cityDataDao.insertCitySalaryCoefficient(citySalaryCoefficient);
    			}
    					
    		}
    			
    	}
    	
    }
    
    public void insertCityConsumptionlevel(String filePath){
    	
    	Map<String,Double> cityConsumptionlevelMap = new HashMap<String,Double>();
    	
    	double bjConsumption = 0;
    	
    	List<String> listCityConsumption = readTxtFile(filePath);
    	
    	if(listCityConsumption!=null){
    		
    		bjConsumption = Double.parseDouble(listCityConsumption.get(0).split(",")[1]);
    		
    		for(String cityConsumptionStr:listCityConsumption){
    			
    			String cityName = cityConsumptionStr.split(",")[0];
    			double cityConsumption = Double.parseDouble(cityConsumptionStr.split(",")[1]);
    			
    			cityConsumptionlevelMap.put(cityName, Math.round((cityConsumption/bjConsumption) * 100) * 0.01);		
    		}
    	}
    	
    	List<CityCode> cityCodeList = cityDataDao.getCityCode();
    	
    	for(CityCode tmpCityCode:cityCodeList){
    		
    		CityConsumptionLevel cityConsumptionLevel = new CityConsumptionLevel();
    		
    		
    		if(cityConsumptionlevelMap.containsKey(tmpCityCode.getProvinceName())){
    				
    			cityConsumptionLevel.setCityCode(tmpCityCode.getCityCode());
    			cityConsumptionLevel.setConsumptionLevel(cityConsumptionlevelMap.get(tmpCityCode.getProvinceName()));
    			cityConsumptionLevel.setDataPeriod("2014");
        			
        		cityDataDao.insertCityConsumptionLevel(cityConsumptionLevel);
    			}
    					
    		}
    			
    	}
   
}
