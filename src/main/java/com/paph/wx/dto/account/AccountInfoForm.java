package com.paph.wx.dto.account;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.paph.wx.components.model.AccountInfo;
import com.yuanbosu.common.encrypt.MD5;
import com.yuanbosu.data.common.dto.BaseForm;

@JsonInclude(Include.NON_NULL)
public class AccountInfoForm extends BaseForm<AccountInfo> {

	private String accountNumber;

	private String password;

	private String name;

	private String mobile;

	private String email;

	private Boolean emailConfirm;

	private Boolean mobileConfirm;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return StringUtils.trimToNull(password);
	}

	public void setPassword(String password) {
		this.password = MD5.hex(password);
	}

	public Boolean getEmailConfirm() {
		return emailConfirm;
	}


	public Boolean getMobileConfirm() {
		return mobileConfirm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void processBean(AccountInfo arg0) {
		// TODO Auto-generated method stub

	}

}
