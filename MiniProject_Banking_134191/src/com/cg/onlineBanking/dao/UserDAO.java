package com.cg.onlineBanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.onlineBanking.bean.UserBean;
import com.cg.onlineBanking.exception.BankingException;
import com.cg.onlineBanking.util.ConnectionUtil;

public class UserDAO implements IUserDAO{

	private Connection connect;
	private ConnectionUtil util;
	
	public UserDAO() {
		try {
			util=new ConnectionUtil();
		} catch (BankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect = util.getConnection();
	}

	@Override
	public ArrayList getUserIdList() throws BankingException{
		String qry="select user_Id from user_table";
		ArrayList userList;
		try {
			Statement st=connect.createStatement();
			userList = new ArrayList();
			ResultSet rs=st.executeQuery(qry);
			
			while(rs.next()){
				
				userList.add(rs.getInt("user_Id"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankingException("unable to retrieve userId List",e);
		}
		
		return userList;
	}

	@Override
	public UserBean getUserDetailsOnId(int userId) throws BankingException {
		String qry="select * from user_table where user_id=?";
		UserBean bean=null;
		try {
			PreparedStatement st=connect.prepareStatement(qry);
			st.setInt(1, userId);
			ResultSet rs=st.executeQuery();
			
			
			while(rs.next()){
				bean=new UserBean();
				
				bean.setAccNo(rs.getLong("account_id"));
				bean.setLockStatus(rs.getString("lock_status"));
				bean.setLoginPassword(rs.getString("login_password"));
				bean.setSecretQstn(rs.getString("secret_question"));
				bean.setUserId(userId);
				bean.setTransPassword(rs.getString("transaction_Password"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankingException("unable to retrieve userDetails List",e);
		}
		
		return bean;
}
}
/*	@Override
	public UserBean validateUser(int userId) throws BankingException {
		
		UserBean existUser=null;
		String qry = "SELECT * FROM UserDetails WHERE userId=? ";
		
		try (PreparedStatement ps = connect.prepareStatement(qry);)
		{
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				int userid = rs.getInt("user_id");
				String loginPassword = rs.getString("login_password");
				
				existUser = new UserBean(userid, loginPassword);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankingException("unable to get user details",e);
			}
		
		return existUser;
	}

}
*/