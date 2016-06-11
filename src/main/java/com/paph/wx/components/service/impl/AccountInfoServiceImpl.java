package com.paph.wx.components.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paph.wx.components.model.AccountInfo;
import com.paph.wx.components.repository.AccountInfoRepos;
import com.paph.wx.components.search.AccountInfoSearch;
import com.paph.wx.components.service.AccountInfoService;
import com.yuanbosu.data.jpa.repository.BaseRepository;
import com.yuanbosu.data.jpa.service.impl.BaseServiceImpl;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountInfoServiceImpl extends BaseServiceImpl<AccountInfo> implements AccountInfoService{

	
//	private static final Logger log = LoggerFactory.getLogger(AccountInfoServiceImpl.class);

	@Resource AccountInfoRepos repo;
	
	
	
	@Resource
	private HttpServletRequest req;
	
	@Resource
	private HttpServletResponse res;
	
	@Override
	protected BaseRepository<AccountInfo> getRepo() {
		
		return repo;
	}
	
	


	// ---------------------------------------------------------- project methods
	
	
	/**
	 * 通过认证的手机号 获取账户
	 * @param mobile 手机号
	 * @return 账户信息
	 */
	public AccountInfo findByMobile(String mobile){
		mobile = StringUtils.trimToNull(mobile);
		if (mobile==null) return null;
		
		AccountInfoSearch search = new AccountInfoSearch();
		search.setMobile(mobile);
		
		return repo.findOne(search.getSpecification());
	}
	
	
	
	/**
	 * 通过认证的邮件 获取账户
	 * @param email 邮件
	 * @return 账户信息
	 */
	public AccountInfo findByMail(String email){
		email = StringUtils.trimToNull(email);
		if (email==null) return null;
		
		AccountInfoSearch search = new AccountInfoSearch();
		search.setEmail(email);
		
		return repo.findOne(search.getSpecification());
	}


	
}
