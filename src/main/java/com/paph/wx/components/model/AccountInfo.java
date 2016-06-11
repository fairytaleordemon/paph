package com.paph.wx.components.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.yuanbosu.data.jpa.domain.model.BaseModel;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "account_info")
public class AccountInfo extends BaseModel{

	private static final long serialVersionUID = 6776793976098546639L;
	
	@Column(length=20)
	private String mobile;                           //手机
	
	@Basic
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean mobileConfirm;                   //手机号是否认证
	
	@Column(length=60)
	private String email;                            //邮箱
	
	@Basic
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean emailConfirm;                    //邮箱是否确认
	
	@Column(length=40)
	private String accountNumber;                    //帐号
	
	@Column(length=40)
	private String password;                         //密码（密文）
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTime;                      //最后登录时间
	
	@Column(length=60)
	private String lastLoginIp;                      //最后登录IP
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getMobileConfirm() {
		return mobileConfirm;
	}

	public void setMobileConfirm(Boolean mobileConfirm) {
		this.mobileConfirm = mobileConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(Boolean emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
}
