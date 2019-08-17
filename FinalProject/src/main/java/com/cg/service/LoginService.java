package com.cg.service;

import com.cg.bean.Admin;
import com.cg.bean.Merchant;
import com.cg.bean.User1;


public interface LoginService {
	

public boolean addAdmin(Admin ad);
public boolean addCustomer(User1 cu);
public boolean addMerchant(Merchant me);

public Admin findAdmin(String username,String password);
public User1 findCustomer(String username,String password);
public Merchant findMerchant(String username,String password);


}
