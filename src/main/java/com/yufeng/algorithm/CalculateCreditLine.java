package com.yufeng.algorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yufeng.controller.UserBasicInfoController;
import com.yufeng.dao.CityDataDao;
import com.yufeng.dao.CollegeEntityDao;
import com.yufeng.dao.UserBasicInfoDao;
import com.yufeng.entity.RewardPunishmentInfo;
import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.entity.UserFinancialAccountInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.UserInfoService;
import com.yufeng.util.InternalCodeGenerator;
import com.yufeng.util.Utils;

public class CalculateCreditLine {
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	CollegeEntityDao collegeEntityDao;
	
	@Autowired
	CityDataDao cityDataDao;
	
	
	/**获得学校当地的消费系数
	 *@param cityCode 学校所在城市编码 
	 *@return 学校当地的消费系数
	 */
	private double getConsumptionCoefficient(String cityCode){
		
		double result = -1;
		
		//从数据库得到学校当地的消费系数
		
		if(cityDataDao.getCityConsumptionLevel(cityCode)!=null){
			result = cityDataDao.getCityConsumptionLevel(cityCode).getConsumptionLevel();
		}
		
		return result;
		
	}
	
	
	/**获得户籍地收入系数
	 *@param IDNo 身份证
	 *@return 户籍地收入系数
	 */
	private double getIncomeCoefficient(String IDNo){
		
		double result = -1;
		
		//从数据库得到户籍地收入系数
		if(cityDataDao.getCitySalaryCoefficient(IDNo.substring(0, 6))!=null){
			result = Double.parseDouble(cityDataDao.getCitySalaryCoefficient(IDNo.substring(0, 6)).getSalaryCoefficient());
		}
		
		return result;
		
	}
	
	
	/**获得户籍地房价系数，计算方式：户籍地实际房价/北京的实际房价
	 *@param IDNo 身份证
	 *@return 户籍地收入系数
	 */
	private double getHousePriceCoefficient(String IDNo){
		
		double result = -1;
		
		//从数据库得到户籍地房价系数
		String localHousePrice = "";
		
		if(cityDataDao.getCityHousePrice(IDNo.substring(0, 6))!=null){
			localHousePrice = cityDataDao.getCityHousePrice(IDNo.substring(0, 6)).getHousePrice();
		}
		
		String bjHousePrice = cityDataDao.getCityHousePrice(Utils.BJ_CODE).getHousePrice();
		
		
		if((!localHousePrice.equals(""))&&(!bjHousePrice.equals(""))){
			
			result = Double.parseDouble(localHousePrice)/Double.parseDouble(bjHousePrice);
			
		}
		
		return result;
		
	}
	
	
	/**获得在校消费系数
	 *@param collegeCode 学校编号 
	 *@return 在校消费系数
	 */
	private float getUnivsNoConsumptionCoefficient(String collegeCode){
		
		float result = 1;
		
		//从数据库得到在校消费金额
		
		//除以until.BASIC_CONSUMPTION_IN_SCHOOL
		
		//暂无相关数据，返回1
		
		return result;
		
	}
	
	/**获得学费系数
	 *@param academy_code 学院编号 
	 *@param collegeCode 学校编号 
	 *@return 在校消费系数
	 */
	private float getTuitionCoefficient(String academy_code,String collegeCode){
		
		float result = 1;
		
		//从数据库得到在所在学校院系的学费
		
		//除以until.BASIC_TUITION
		
		//暂无相关数据，返回1
		
		
		return result;
		
	}
	
	
	/**获得在校评分卡
	 *@param internalCode 内码ID 
	 *@return 评分卡分数
	 */
	private float getCreditScoreCoefficient(String internalCode){
		
		float result = 1;
		
		//从数据库得到在校评分卡分数
		
		//除以基础值
		
		//暂无相关数据，返回1
		
		return result;
		
	}
	
	
	
	/**计算学生的信用额度
	 * 
	 * 初级，额度最高500元，不予提现。解决客户拓展，独立申请便利性。经过准入审核，即给予初级额度
	 * 一级，初始额度最高3000元。参考2345贷款王，应对竞争。
	 * 二级，额度最高5000元，应对主流分期平台
	 * 三级，额度按照规则测算，最高10000元，打造自身特色。
	 * @param internalCode 用户内码
	 * @return 额度四舍五入取整
	 * 
	 * */
	public double CalculateCreditLineForStudent(String internalCode){
		
		double creditLine = 0;
		
		//获得用户所有信息
		UserInfo userInfo = new UserInfo();
		userInfo = userInfoService.getUserInfo(internalCode);
		
		//获得用户级别
		int userLevel = userInfoService.getUserLevel(userInfo);
		
		switch (userLevel){

			case Utils.LEVEL_0:
				
				creditLine = 500;

				break;
								
			case Utils.LEVEL_1:
				
				creditLine = 3000;

				break;
				
			case Utils.LEVEL_2:
				
				creditLine = 5000;

				break;
	
			case Utils.LEVEL_3:
	
				creditLine = CalculateRule(userInfo);
				
				if(creditLine>Utils.HIGHEST_CREDIT_LINE){
					
					creditLine = Utils.HIGHEST_CREDIT_LINE;
					
				}
							
				break;
				
		}

		return creditLine;
		
	}
	
	
	/**公式：基础值*学校所属地区消费系数*户籍地收入/房价系数*月消费水平系数*院系年费系数*信用分系数
	 * @param UserInfo userInfo 客户全部信息
	 * @return 客户测算额度值
	 * */
	private double CalculateRule(UserInfo userInfo){
		
		//获得在读学校信息
		SchoolExperienceInfo completingSchoolExperienceInfo = new SchoolExperienceInfo();
							
		if(userInfo.getSchoolExperienceInfoList().size()==1){
						
			completingSchoolExperienceInfo = userInfo.getSchoolExperienceInfoList().get(0);
						
		}
					
		if(userInfo.getSchoolExperienceInfoList().size()>1){
						
			Date compareDate =null;
						
			for(SchoolExperienceInfo schoolExperienceInfoTmp:userInfo.getSchoolExperienceInfoList()){
							
				if(compareDate==null){
							
					compareDate = schoolExperienceInfoTmp.getAdmissionDate();
								
					completingSchoolExperienceInfo = schoolExperienceInfoTmp;
							
				}else{
					if(Utils.compare_date(compareDate, schoolExperienceInfoTmp.getAdmissionDate())==1){
									
						completingSchoolExperienceInfo = schoolExperienceInfoTmp;
									
					}
				}		
			}	
		}
		
		//根据现在就读学校的信息计算信用额度
					
		//从数据库获得学校所在cityNo
		String cityNo = collegeEntityDao.getCollegeAcademyEntityByCollegeCode(completingSchoolExperienceInfo.getSchoolCode()).getCityCode();
					
		//从数据库获得IDNo
		String IDNo = userInfo.getUserBasicInfo().getIdNo();
					
		//从数据库获得collegeCode学校编号
		String collegeCode = completingSchoolExperienceInfo.getSchoolCode();
					
		//从数据库获得getAcademyCode学院编号
		String academyCode = completingSchoolExperienceInfo.getAcademyCode();
					
					
		double consumptionCoefficient = getConsumptionCoefficient(cityNo);
					
		double incomeCoefficient = getIncomeCoefficient(IDNo);
					
		double housePriceCoefficient = getHousePriceCoefficient(IDNo);
					
		double univsNoConsumptionCoefficient = getUnivsNoConsumptionCoefficient(collegeCode);
					
		double tuitionCoefficient = getTuitionCoefficient(academyCode,collegeCode);
					
		double creditScoreCoefficient = getCreditScoreCoefficient(userInfo.getUserBasicInfo().getInternalCode());
							
		double creditLine = Utils.BASIC_CREDIT_LINE*consumptionCoefficient*(incomeCoefficient/housePriceCoefficient)*univsNoConsumptionCoefficient*tuitionCoefficient*creditScoreCoefficient;
							
		return Math.round(creditLine);
		
	}
	
	
}
