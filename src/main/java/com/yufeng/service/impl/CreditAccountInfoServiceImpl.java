package com.yufeng.service.impl;

import com.yufeng.dao.CityDataDao;
import com.yufeng.dao.CollegeEntityDao;
import com.yufeng.dao.CreditAccountInfoDao;
import com.yufeng.entity.CreditAccountInfo;
import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.CreditAccountInfoService;
import com.yufeng.service.UserInfoService;
import com.yufeng.util.Utils;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishyu on 16/8/12.
 */
public class CreditAccountInfoServiceImpl implements CreditAccountInfoService{

    @Autowired
    private CreditAccountInfoDao creditAccountInfoDao;
    
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private CollegeEntityDao collegeEntityDao;
	
	@Autowired
	private CityDataDao cityDataDao;
    
    

	public CreditAccountInfo getCreditAccountInfo(String internalCode) {
		
		CreditAccountInfo creditAccountInfo = new CreditAccountInfo();
		
		creditAccountInfo = creditAccountInfoDao.getCreditAccountInfo(internalCode);
		
		return creditAccountInfo;
	}


	public boolean isExistedCreditAccountInfo(String internalCode) {
		
		
		boolean result = false;
		
		int resultCount = creditAccountInfoDao.isExistedCreditAccountInfo(internalCode);
		System.out.println("resultCount=="+resultCount);
		if(resultCount>0){
			
			result = true;
			
		}
		System.out.println("result是否存在=="+result);
		return result;
	}


	public CreditAccountInfo insertOrUpdateCreditAccountInfo(String internalCode,String accountType) {
		
		CreditAccountInfo creditAccountInfoResult=null;
		//如果账户存在就重新计算信用额度，并更新信用账户
		if(isExistedCreditAccountInfo(internalCode)){
			
			System.out.println("存在该信用账户，用于更新额度");
			
			CreditAccountInfo creditAccountInfoNew = new CreditAccountInfo();
			
			creditAccountInfoNew = updateCreditAccountLine(internalCode,accountType);
			
			int result =  creditAccountInfoDao.updateCreditAccountInfo(creditAccountInfoNew);
			
		    if(result==1) {

		    	creditAccountInfoResult=creditAccountInfoDao.getCreditAccountInfo(internalCode);

		    }
		    		
			
		}else{
			//如果账户不存在就生成一个新的信用账户
			
			System.out.println("不存在该信用账户，用于创建额度");
			
			CreditAccountInfo creditAccountInfoNew = new CreditAccountInfo();
			
			creditAccountInfoNew = makeNewCreditAccountInfo(internalCode, accountType);
			
			int result =  creditAccountInfoDao.insertCreditAccountInfo(creditAccountInfoNew);

		    if(result==1) {

		    	creditAccountInfoResult=creditAccountInfoDao.getCreditAccountInfo(internalCode);

		    }
		}
		
		return creditAccountInfoResult;
		   
	}


	public CreditAccountInfo updateCreditAccountInfo(String internalCode,String accountType) {
		
		
		CreditAccountInfo creditAccountInfo = new CreditAccountInfo();
		
		creditAccountInfo = updateCreditAccountLine(internalCode,accountType);
		
		int result = creditAccountInfoDao.updateCreditAccountInfo(creditAccountInfo);
		
		CreditAccountInfo creditAccountInfoResult=null;
	        
		if(result==1) {
			
			creditAccountInfoResult =creditAccountInfoDao.getCreditAccountInfo(creditAccountInfo.getInternalCode());
	    
		}

	        return creditAccountInfoResult;
	}
	
	/**
	 * 构造信用账户
	 * @param UserInfo userInfo 该用户所有信息
	 * @param String accountType 该用户类型
	 * @return CreditAccountInfo 信用账户
	 * 
	 * */
	public CreditAccountInfo makeNewCreditAccountInfo(String internalCode,String accountType){
				
		double creditLine = 0;
		
		if(accountType!=null&&accountType.equals(Utils.STUDENT_ACCOUNT)){
			
			System.out.println("学生信用账户");
			creditLine = CalculateCreditLineForStudent(internalCode);
			
		}
		
		if(accountType!=null&&accountType.equals(Utils.ADULT_ACCOUNT)){
			
			
			creditLine = CalculateCreditLineForAdult(internalCode);
			
		}
		
		CreditAccountInfo creditAccountInfo = new CreditAccountInfo();
		
		creditAccountInfo.setInternalCode(internalCode);
		creditAccountInfo.setAccountType(accountType);
		creditAccountInfo.setAccountStatus(Utils.NORMAL_ACCOUNT);
		creditAccountInfo.setOpenDate(new Date());
		creditAccountInfo.setInitialCashQuota(new BigDecimal(creditLine));
		creditAccountInfo.setInitialGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		creditAccountInfo.setCurrentCashQuota(new BigDecimal(creditLine));
		creditAccountInfo.setCurrentGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		creditAccountInfo.setAvailableCashQuota(new BigDecimal(creditLine));
		creditAccountInfo.setAvailableGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		
		
		return creditAccountInfo;
	}
	
	
	
	/**
	 * 更新信用账户
	 * @param UserInfo userInfo 该用户所有信息
	 * @param String accountType 该用户类型
	 * @return CreditAccountInfo 信用账户
	 * 
	 * */
	public CreditAccountInfo updateCreditAccountLine(String internalCode,String accountType){
				
		double creditLine = 0;
		
		if(accountType!=null&&accountType.equals(Utils.STUDENT_ACCOUNT)){
			
			
			creditLine = CalculateCreditLineForStudent(internalCode);
			
		}
		
		if(accountType!=null&&accountType.equals(Utils.ADULT_ACCOUNT)){
			
			
			creditLine = CalculateCreditLineForAdult(internalCode);
			
		}
		
		CreditAccountInfo creditAccountInfoOld = getCreditAccountInfo(internalCode);
		
		BigDecimal OldCurrentCashQuota = creditAccountInfoOld.getCurrentCashQuota();
		BigDecimal OldCurrentGuaranteeQuota = creditAccountInfoOld.getCurrentGuaranteeQuota();
		BigDecimal OldAvailableCashQuota = creditAccountInfoOld.getAvailableCashQuota();
		BigDecimal OldAvailableGuaranteeQuota = creditAccountInfoOld.getAvailableGuaranteeQuota();
		
		
		creditAccountInfoOld.setCurrentCashQuota(new BigDecimal(creditLine));
		creditAccountInfoOld.setCurrentGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		creditAccountInfoOld.setAvailableCashQuota(new BigDecimal(creditLine).subtract(OldCurrentCashQuota.subtract(OldAvailableCashQuota)));
		creditAccountInfoOld.setAvailableGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO).subtract(OldCurrentGuaranteeQuota.subtract(OldAvailableGuaranteeQuota)));
		
		
		return creditAccountInfoOld;
	}
	

	

	
	
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
				if(creditLine<0){
					creditLine = Utils.BASIC_CREDIT_LINE;	
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
		String cityNo = ""; 
		try{
			cityNo = collegeEntityDao.getCollegeAcademyEntityByCollegeCode(completingSchoolExperienceInfo.getSchoolCode()).getCityCode();
		}catch(Exception e){
			System.out.println("从数据库中未查到获得学校所在cityNo");
			cityNo = null;
		}		
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
