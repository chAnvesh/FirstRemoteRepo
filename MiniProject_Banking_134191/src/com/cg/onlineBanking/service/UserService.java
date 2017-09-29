package com.cg.onlineBanking.service;

import java.util.ArrayList;

import com.cg.onlineBanking.bean.AccountMasterBean;
import com.cg.onlineBanking.bean.UserBean;
import com.cg.onlineBanking.dao.IUserDAO;
import com.cg.onlineBanking.dao.UserDAO;
import com.cg.onlineBanking.exception.BankingException;

public class UserService implements IUserService {

	IUserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	
	@Override
	public UserBean validateCredentials(UserBean user) throws BankingException {
		UserBean resultUser = new UserBean();
		ArrayList aList=userDAO.getUserIdList();
		
		if(aList.contains(user.getUserId())){
			
			resultUser.setUserId(user.getUserId());
			UserBean existUser=userDAO.getUserDetailsOnId(user.getUserId());
			
			if(user.getLoginPassword().equals(existUser.getLoginPassword()))
				{
					resultUser = existUser;
					return resultUser;
				}
				else{
					return resultUser;
				}
		}
		else
		{
			return resultUser;
		}
		
	}


	@Override
	public ArrayList validateUserPassword() throws BankingException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean changePassword(String password, int userId) throws BankingException {
		
		return userDAO.changePassword(password, userId);
	}


	@Override
	public ArrayList<AccountMasterBean> getAccountDetails(int userId)
			throws BankingException {
		// TODO Auto-generated method stub
		return userDAO.getAccountDetails(userId);
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	
		UserBean existingUser = userDAO.validateUser(user.getUserId());
		
		if(existingUser==null){
			break;
		}else if(existingUser.getLoginPassword()!=user.getLoginPassword()){
			break;
		}
		else{
			flag=true;
		}
		return flag;
	}
*/
	}

