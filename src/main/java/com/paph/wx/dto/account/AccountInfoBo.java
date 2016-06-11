package com.paph.wx.dto.account;

import com.paph.wx.components.model.AccountInfo;
import com.yuanbosu.data.common.dto.BaseBo;

//@JsonInclude(Include.NON_NULL)
public class AccountInfoBo extends BaseBo<AccountInfo> {

	@Override
	protected void processBean(AccountInfo arg0) {

	}

	public AccountInfoBo() {
	}

	public AccountInfoBo(AccountInfo model) {
		
		fromModel(model);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;
	
	
	
}
