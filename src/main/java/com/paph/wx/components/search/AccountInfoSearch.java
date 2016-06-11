package com.paph.wx.components.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.paph.wx.components.model.AccountInfo;
import com.paph.wx.components.specification.AccountInfoSpec;
import com.yuanbosu.data.jpa.domain.dto.BaseSearch;

public class AccountInfoSearch extends BaseSearch<AccountInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1319892553714312888L;

	@Override
	public Sort getSort(){
		return new Sort(Direction.DESC, "timeCreated");
	}
	
	public Specification<AccountInfo> getSpecification() {
		return new AccountInfoSpec(this);
	}

	
	private String accountNumber;
	
	private String mobile;
	
	private String email;

	private Boolean fetchMembers;
	
	private Boolean emailConfirm;
	
	private Boolean mobileConfirm;
	
	private String address;
	
	private String briefInfo;

	public String getMobile() {
		return StringUtils.trimToEmpty(mobile);
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return StringUtils.trimToEmpty(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountNumber() {
		return StringUtils.trimToEmpty(accountNumber);
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Boolean getFetchMembers() {
		return fetchMembers;
	}

	public Boolean getEmailConfirm() {
		return emailConfirm;
	}


	public Boolean getMobileConfirm() {
		return mobileConfirm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = StringUtils.trimToEmpty(address);
	}

	public String getBriefInfo() {
		return briefInfo;
	}

	public void setBriefInfo(String briefInfo) {
		this.briefInfo = StringUtils.trimToEmpty(briefInfo);
	}
}
