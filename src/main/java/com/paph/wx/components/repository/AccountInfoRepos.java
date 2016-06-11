package com.paph.wx.components.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paph.wx.components.model.AccountInfo;
import com.yuanbosu.data.jpa.repository.BaseRepository;


@Repository
public interface AccountInfoRepos extends BaseRepository<AccountInfo>{
 


    /**
     * 根据用户USERID或EMAIL或MOBILE登录
     * @param input
     * @param password
     * @return 用户列表
     */
    @Query("select u from AccountInfo u where (u.accountNumber = :input or u.mobile = :input or u.email = :input) and u.password=:password")
    public List<AccountInfo> findByLoginInput(@Param("input") String input,@Param("password") String password);
  


    
    /**
     * 更新最后登录时间/IP
     * @param id 用户ID
     * @return 
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying
    @Query("update AccountInfo u set u.lastLoginTime = ?2, u.lastLoginIp = ?3 where u.id = ?1")
    public int updateLastLoginInfo(String id,Date loginTime,String loginIp);

    
    /**
     * 更新密码
     * @param id 用户ID
     * @param password 新密码
     * @return 
     */
    @Transactional
    @Modifying
    @Query("update AccountInfo u set u.password =?2 where u.id = ?1")
    public int updatePassword(String id,String password);


    
}
