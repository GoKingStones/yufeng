package com.yufeng.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yufeng.dao.CityDataDao;
import com.yufeng.entity.CityCode;
import com.yufeng.entity.CityHousePrice;
import com.yufeng.service.ImportCityDataService;

public class ImportCityDataServiceimpl implements ImportCityDataService{

	/**
	 * Created by fishyu on 16/7/26.
	 */
	
    @Autowired
    private CityDataDao cityDataDao;
	
    public List<String> readTxtFile(String filePath){
    	
    	
    	List<String> housePriceList = new ArrayList<String>();
    	
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	housePriceList.add(lineTxt);
                    }
                    read.close();
                    
                    return housePriceList;
                    
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
        			cityHousePriceTmp.setInfoStatus("e");
        			
        			System.out.println("城市编码："+cityCodetmp.getCityCode()+";房屋均价："+houseAndPrice[1].replaceAll("[^0-9]", ""));
        			
        			cityDataDao.insertCityHousePriceTable(cityHousePriceTmp);
    			}
    			
    		}
    	}
    	
    }
    
    
    
    public static void main(String args[]){

    	
    	String filePath = "/Users/yuqikang777/zxworkspace/201606";

    	
    	ImportCityDataServiceimpl importCityData = new ImportCityDataServiceimpl();
    	
    	importCityData.insertCityHousePrice(filePath);
    	
    	
    }
    
    
}
