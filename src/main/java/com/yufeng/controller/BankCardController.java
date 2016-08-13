package com.yufeng.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.service.BankCardService;

/**
 * 银行卡控制层
 * @author dh
 */
@RestController
@RequestMapping("/BankCard")
public class BankCardController { 
	
	@Autowired
	private BankCardService bankCardService;
	
	//查询银行卡信息(code)
	@RequestMapping("/getBankCardByCode")
	public List<UserBankCardInfo> getBankCardByCode(String code){
		List<UserBankCardInfo> info=bankCardService.getBankCardByCode(code);
		return info;
    }
	
	//查询银行卡信息(id)
	@RequestMapping("/getBankCardByID")
	public UserBankCardInfo getBankCardByID(String id){
		UserBankCardInfo info=bankCardService.getBankCardByID(id);
		return info;
	}
	
	//新建银行卡信息
	@RequestMapping("/insertBankCard")
	public String insertBankCard(@RequestBody UserBankCardInfo userBankCardInfo){
		return bankCardService.insertBankCard(userBankCardInfo);
	}
	
	//银行卡信息修改
	@RequestMapping("/updateBankCard")
	public String updateBankCard(@RequestBody UserBankCardInfo userBankCardInfo){
		return bankCardService.updateBankCard(userBankCardInfo);
	}
	
	//删除银行卡信息
	@RequestMapping("/deleteBankCard")
	public String deleteBankCard(@RequestBody UserBankCardInfo userBankCardInfo){
		return bankCardService.deleteBankCard(userBankCardInfo);
	}

}
