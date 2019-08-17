package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Admin;
import com.cg.bean.Merchant;
import com.cg.bean.User1;
import com.cg.dao.AdminDAO;
import com.cg.dao.MerchantDAO;
import com.cg.dao.User1DAO;


@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired AdminDAO dao;
	@Autowired User1DAO dao1;
	@Autowired MerchantDAO dao2;

	@Override
	public Admin findAdmin(String username,String password) {
		Admin wa1 = null;
		List<Admin> lst = dao.findAll();
		System.out.println(lst);
		for(Admin wa : lst)
		{
			if((wa.getEmailid().equals(username))&&(wa.getPassword().equals(password))) {
				wa1 = wa;
			}
		}
//		if(wa1 == null)
//		{
//			throw new ApplicationException("No account found in-Admin");
//		}
		return wa1;
	}

	@Override
	public User1 findCustomer(String username, String password) {
		User1 wa1 = null;
		List<User1> lst = dao1.findAll();
		for(User1 wa : lst)
		{
			if((wa.getEmailid().equals(username))&&(wa.getPassword().equals(password))) {
				wa1 = wa;
			}
		}
//		if(wa1 == null)
//		{
//			throw new ApplicationException("No account found in-Customer");
//		}
		return wa1;
	}

	@Override
	public Merchant findMerchant(String username, String password) {
		Merchant wa1 = null;
		List<Merchant> lst = dao2.findAll();
		for(Merchant wa : lst)
		{
			if((wa.getEmailid().equals(username))&&(wa.getPassword().equals(password))) {
				wa1 = wa;
			}
		}
//		if(wa1 == null)
//		{
//			throw new ApplicationException("No account found in-Customer");
//		}
		return wa1;
	}


	@Override
	public boolean addAdmin(Admin ad) {
		dao.save(ad);
		return true;
	}

	@Override
	public boolean addCustomer(User1 cu) {
		dao1.save(cu);
		return true;
	}

	@Override
	public boolean addMerchant(Merchant me) {
		dao2.save(me);
		return true;
	}
	

}
