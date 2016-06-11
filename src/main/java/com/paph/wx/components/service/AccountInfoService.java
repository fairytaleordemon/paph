package com.paph.wx.components.service;

import com.paph.wx.components.model.AccountInfo;
import com.yuanbosu.data.jpa.service.BaseService;

public interface AccountInfoService extends BaseService<AccountInfo>{
	
	
	
	/**
	 * 获取账户
	 * @param mobile
	 * @return
	 */
	public AccountInfo findByMobile(String mobile);
	
	/**
	 * 获取邮箱
	 * @param email
	 * @return
	 */
	public AccountInfo findByMail(String email);
	
}
