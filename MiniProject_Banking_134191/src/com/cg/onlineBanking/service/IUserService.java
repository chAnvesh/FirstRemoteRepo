package com.cg.onlineBanking.service;

import java.util.ArrayList;

import com.cg.onlineBanking.bean.UserBean;
import com.cg.onlineBanking.exception.BankingException;

public interface IUserService {

	public UserBean validateCredentials(UserBean user) throws BankingException;
	public ArrayList validateUserPassword() throws BankingException ;
}
