package com.paph.wx.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paph.wx.components.model.AccountInfo;
import com.paph.wx.components.search.AccountInfoSearch;
import com.paph.wx.components.service.AccountInfoService;
import com.paph.wx.dto.account.AccountInfoBo;
import com.paph.wx.dto.account.AccountInfoForm;
import com.paph.wx.dto.account.AccountInfoList;
import com.yuanbosu.data.jpa.domain.dto.MessageOutput;


@RestController
@RequestMapping("/server/account/info")
public class AccountInfoRest {

	
	@Resource private AccountInfoService srv;
	
	/**
	 * 分页
	 * @param searchForm
	 * @return
	 */
    @RequestMapping("/pagelist.json")
    public Page<AccountInfoBo> pageList(@ModelAttribute AccountInfoSearch searchForm) {
    	return new AccountInfoList(srv.pageList(searchForm)).getPage();
    }
    
    
    /**
     * 列表显示
     * @param searchForm
     * @return
     */
    @RequestMapping("/list.json")
    public List<AccountInfoBo> list(@ModelAttribute AccountInfoSearch searchForm) {
    	List<AccountInfoBo> accounts = new AccountInfoList(srv.list(searchForm)).getList();
    	return accounts;
    }
    
    
    /**
     * 详细信息
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}.json")
    public AccountInfoBo detail(@PathVariable String id) {
    	return new AccountInfoBo(srv.detail(id));
    }
      
    
    /**
     * 修改保存
     * @param form
     * @return
     */
    @RequestMapping("/save.json")
    public MessageOutput save(@ModelAttribute AccountInfoForm form) {
    	return new MessageOutput(srv.saveForm(form, new AccountInfo()).getId());
    }
    
    
    
    /**
     * 删除
     * @param id
     */
    @RequestMapping("/delete.json") 
    public void delete(@RequestParam String id) {
    	srv.fakeDeleteById(id);
    }

   

    
}
