package com.yufeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.dao.BankCardDao;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.service.impl.BankCardServiceImpl;

/**
 * 银行卡控制层
 * @author dh
  */
@RestController
@RequestMapping("/BankCard")
public class BankCardController { 
	
	@Autowired
	private BankCardServiceImpl bankCardServiceImpl;
	
	//查询银行卡信息(code)
	@RequestMapping("/getBankCardByCode")
	public List<UserBankCardInfo> getBankCardByCode(String code){
		List<UserBankCardInfo> info=bankCardServiceImpl.getBankCardByCode(code);
		return info;
    }
	
	//查询银行卡信息(id)
	@RequestMapping("/getBankCardByID")
	public UserBankCardInfo getBankCardByID(String id){
		UserBankCardInfo info=bankCardServiceImpl.getBankCardByID(id);
		return info;
	}
	
	//新建银行卡信息
	@RequestMapping("/insertBankCard")
	public String insertBankCard(UserBankCardInfo userBankCardInfo){
		return bankCardServiceImpl.insertBankCard(userBankCardInfo);
	}
	
	//银行卡信息修改
	@RequestMapping("/updateBankCard")
	public String updateBankCard(UserBankCardInfo userBankCardInfo){
		return bankCardServiceImpl.updateBankCard(userBankCardInfo);
	}
	
	//删除银行卡信息
	@RequestMapping("/deleteBankCard")
	public String deleteBankCard(UserBankCardInfo userBankCardInfo){
		return bankCardServiceImpl.deleteBankCard(userBankCardInfo);
	}

}
