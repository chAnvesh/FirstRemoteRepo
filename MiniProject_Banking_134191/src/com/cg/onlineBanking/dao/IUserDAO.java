package com.cg.onlineBanking.dao;

import java.util.ArrayList;

import com.cg.onlineBanking.bean.AccountMasterBean;
import com.cg.onlineBanking.bean.UserBean;
import com.cg.onlineBanking.exception.BankingException;

public interface IUserDAO {

	//public UserBean validateUser(int userId) throws BankingException;
	public ArrayList getUserIdList()  throws BankingException;
	//public ArrayList validateUserPassword()  throws BankingException;
	public UserBean getUserDetailsOnId(int userId) throws BankingException;
	public boolean changePassword(String password, int userId) throws BankingException;
	
	public ArrayList<AccountMasterBean> getAccountDetails(int userId) throws BankingException;
	
}
