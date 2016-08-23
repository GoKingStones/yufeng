import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yufeng.controller.RegisterAccountController;
import com.yufeng.controller.UserBasicInfoController;
import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.InternalCodeGenerator;

/**
 * Created by fishyu on 16/8/9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class CalculateCreditLineTest {
	
	@Resource
	private UserBasicInfoService userBasicInfoService;
	
	@Resource
	private RegisterAccountDao registerAccountDao;
	
	
    @Test
    public void testCalculateCreditLine() throws Exception {

    	
    	RegisterAccount registerAccount = new RegisterAccount();
    	
    	registerAccount.setAccountFlag("0");
    	registerAccount.setAccountName("fishyu");
    	registerAccount.setPassword("123456");
    	registerAccount.setPhoneNumber("18601923137");
    	registerAccount.setSource("mall");
    	
    	registerAccountDao.insertRegisterAccount(registerAccount);
    	
		
    	String internal_code = InternalCodeGenerator.getCode(0, "120104198408175117");

    	System.out.println("internal_code==="+internal_code);

    	//保存客户基本信息
    	UserBasicInfo userBasicInfo = new UserBasicInfo();	
    	userBasicInfo.setName("于祺康");
    	userBasicInfo.setIdType("0");
    	userBasicInfo.setIdNo("120104198408175117");
    	userBasicInfo.setCellNo("18601923137");
    	userBasicInfo.setEmail("81741099@qq.com");
    	userBasicInfo.setFamilyAddress("天津市家庭地址");
    	userBasicInfo.setMaritalStatus("已婚");
    	userBasicInfo.setPostalAddress("天津市邮寄地址");
    	userBasicInfo.setIdcardFrontImgUrl("/user/zhengmian");
    	userBasicInfo.setIdcardBackImgUrl("/user/fanmian");
    	userBasicInfo.setWeixinNo("yuqikang");
    	userBasicInfo.setQqNo("81741099");
    	userBasicInfo.setAddress("天津市现住址");
    	

    	//userBasicInfoService.insertUserBasicInfoForSignUp(userBasicInfo,registerAccount);


















//
//
//userBasicInfo = userBasicInfoDao.getUserBasicInfoByInternalCode(internalCode);
//				
////保存客户学业信息
//List<SchoolExperienceInfo> schoolExperienceInfoList = new ArrayList<SchoolExperienceInfo>();		
//schoolExperienceInfoList = schoolExperienceInfoDao.getSchoolExperienceInfoByInternalCodeForCreditLine(internalCode);
//				
////保存客户银行卡信息
//List<UserBankCardInfo> userBankCardInfoList = new ArrayList<UserBankCardInfo>();
//userBankCardInfoList = bankCardDao.getBankCardByCode(internalCode);
//		
////保存客户金融账户信息
//List<UserFinancialAccountInfo> userFinancialAccountInfoList = new ArrayList<UserFinancialAccountInfo>();
//userFinancialAccountInfoList = userFinancialAccountDao.getUserFinancialAccountByCode(internalCode);
//		
////保存客户奖惩信息
//List<RewardPunishmentInfo> rewardPunishmentInfoList = new ArrayList<RewardPunishmentInfo>();
//rewardPunishmentInfoList = rewardPunishmentInfoDao.getRewardPunishmentInfoByInternalCode(internalCode);
//		
////保存客户联系人信息
//List<UserFamilyInfo> userFamilyInfoList = new ArrayList<UserFamilyInfo>();
//
    }
	
	
	
	
}
