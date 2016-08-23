package com.yufeng.algorithm;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.yufeng.dao.CityDataDao;
import com.yufeng.dao.CollegeEntityDao;
import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.UserInfoService;
import com.yufeng.util.Utils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculateCreditLine {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private CollegeEntityDao collegeEntityDao;
	
	@Autowired
	private CityDataDao cityDataDao;
	
	
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
	 * 二级，额度按照规则测算，最高10000元，打造自身特色。
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
		int userLevel = userInfoService.getStudentUserLevel(userInfo);
		
		System.out.println("学生信用账户级别=="+userLevel);
		
		switch (userLevel){

			case Utils.LEVEL_0:
				
				creditLine = 500;

				break;
								
			case Utils.LEVEL_1:
				
				creditLine = 3000;

				break;
	
			case Utils.LEVEL_2:
	
				creditLine = CalculateRuleForStudent(userInfo);
				
				if(creditLine>Utils.HIGHEST_CREDIT_LINE){
					
					creditLine = Utils.HIGHEST_CREDIT_LINE;
					
				}
							
				break;
				
		}
		
		System.out.println("学生信用账户额度=="+creditLine);

		return creditLine;
		
	}
	
	/**
	 * 规则未确定，暂时返回基础值
	 * 
	 * 
	 * */
	public double CalculateCreditLineForAdult(String internalCode){
		
		double creditLine = Utils.BASIC_CREDIT_LINE;
		
		return creditLine;
		
	}
	
	
	/**公式：基础值*学校所属地区消费系数*当地经济系数*月消费水平系数*院系年费系数*信用分系数
	 * 当地经济系数 = 0.5+ 2.5*户籍地收入/房价系数
	 * @param UserInfo userInfo 客户全部信息
	 * @return 客户测算额度值
	 * */
	private double CalculateRuleForStudent(UserInfo userInfo){
		
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
		System.out.println("从数据库获得学校所在cityNo=="+cityNo);
					
		//从数据库获得IDNo
		String IDNo = userInfo.getUserBasicInfo().getIdNo();
		System.out.println("从数据库获得IDNo=="+IDNo);
					
		//从数据库获得collegeCode学校编号
		String collegeCode = completingSchoolExperienceInfo.getSchoolCode();
		System.out.println("从数据库获得collegeCode学校编号=="+collegeCode);
					
		//从数据库获得getAcademyCode学院编号
		String academyCode = completingSchoolExperienceInfo.getAcademyCode();
		System.out.println("从数据库获得getAcademyCode学院编号=="+academyCode);
					
					
		double consumptionCoefficient = getConsumptionCoefficient(cityNo);
		
		System.out.println("消费系数=="+consumptionCoefficient);
					
		double incomeCoefficient = getIncomeCoefficient(IDNo);
		
		System.out.println("收入系数=="+incomeCoefficient);
					
		double housePriceCoefficient = getHousePriceCoefficient(IDNo);
		
		System.out.println("房价系数=="+housePriceCoefficient);
					
		double univsNoConsumptionCoefficient = getUnivsNoConsumptionCoefficient(collegeCode);
		
		System.out.println("校园消费系数=="+univsNoConsumptionCoefficient);
					
		double tuitionCoefficient = getTuitionCoefficient(academyCode,collegeCode);
		
		System.out.println("学费系数=="+tuitionCoefficient);
					
		double creditScoreCoefficient = getCreditScoreCoefficient(userInfo.getUserBasicInfo().getInternalCode());
		
		System.out.println("信用评分系数=="+creditScoreCoefficient);
		
		double economicCoefficient = 0.5+2.5*(incomeCoefficient/housePriceCoefficient);
		
		System.out.println("经济系数=="+economicCoefficient);
				
		double creditLine = Utils.BASIC_CREDIT_LINE*consumptionCoefficient*economicCoefficient*univsNoConsumptionCoefficient*tuitionCoefficient*creditScoreCoefficient;
					
		System.out.println("计算出的额度=="+creditLine);
		
		return Math.round(creditLine);
		
	}
	
	
	
}
