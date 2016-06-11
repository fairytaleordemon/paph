package com.paph.wx.components.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.paph.wx.components.model.AccountInfo;
import com.paph.wx.components.search.AccountInfoSearch;


public class AccountInfoSpec implements Specification<AccountInfo>{

	private AccountInfoSearch form;
	
	public AccountInfoSpec(AccountInfoSearch searchForm) {
		this.form = searchForm;
	}
	
	public Predicate toPredicate(Root<AccountInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		Predicate p = cb.conjunction();
		
		   /**
         * 关键字搜索
         * 
         * 多关键字方法：KeywordsPredicate.addExpression(r, cb, p, form, "name", "name2", "name3");
         * 多关键字全匹配：form.setAllMathchKeywords(true);
         * 精确匹配：form.setExactMatchKeywords(true);
         * 逆向匹配：form.setNotMatchKeywords(true);
         * 
         * 
         */
		
		 p.getExpressions().add(cb.equal(root.<Boolean>get("deleted"), false));
		 
		 if (!form.getAccountNumber().isEmpty()){
	            p.getExpressions().add(cb.like(root.<String>get("accountNumber"), "%"+form.getAccountNumber()+"%")); 
	        }
	        
	        if (!form.getMobile().isEmpty()){
	            p.getExpressions().add(cb.equal(root.<String>get("mobile"),form.getMobile())); 
	        }
	        
	        if (!form.getEmail().isEmpty()){
	            p.getExpressions().add(cb.equal(root.<String>get("email"), form.getEmail())); 
	        }
	        
	        if(form.getEmailConfirm()!=null){
	        	p.getExpressions().add(cb.equal(root.<Boolean>get("emailConfirm"),form.getEmailConfirm()));
	        }
	        
	        if(form.getMobileConfirm()!=null){
	        	p.getExpressions().add(cb.equal(root.<Boolean>get("mobileConfirm"), form.getMobileConfirm()));
	        }
		 
		return p;
	}

}
