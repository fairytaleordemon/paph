package com.paph.wx.dto.account;

import com.paph.wx.components.model.AccountInfo;
import com.yuanbosu.data.jpa.domain.dto.BaseListOutput;

public class AccountInfoList extends BaseListOutput<AccountInfo, AccountInfoBo>{

	public AccountInfoList(Object form) {
		super(form);
	}
}

