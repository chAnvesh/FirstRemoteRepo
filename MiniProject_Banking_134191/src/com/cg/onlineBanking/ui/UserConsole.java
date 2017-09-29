package com.cg.onlineBanking.ui;

import java.util.Scanner;

import com.cg.onlineBanking.bean.AccountMasterBean;
import com.cg.onlineBanking.bean.UserBean;
import com.cg.onlineBanking.exception.BankingException;
import com.cg.onlineBanking.service.IUserService;
import com.cg.onlineBanking.service.UserService;

public class UserConsole {
	
	private UserBean user;
	private IUserService service;
	public UserConsole(UserBean user) {
		this.user = user; 
		service = new UserService();
	}

	public void start() {
		System.out.println("Running succesfully");
		System.out.println(user);
		
		Scanner sc=new Scanner(System.in);
		int choice;
		boolean flag = false;
		System.out.println("Welcome");
		
		try {
			for(AccountMasterBean list:service.getAccountDetails(user.getUserId())){
			System.out.println(list);
			}
		} catch (BankingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("1.View statements");
		System.out.println("2.Chage communication details");
		System.out.println("3.Request for Cheque book");
		System.out.println("4.Track service request");
		System.out.println("5.Fund Transfer");
		System.out.println("6.Change password");
	
		choice = sc.nextInt();
		
		switch(choice){
		
		case 1:{
			
			
		}
		case 2:{
			
		}
		case 3:{
			
		}
		case 4:{
			
		}
		case 5:{
			
		}
		case 6:{
			do {
			System.out.println("Change Your Password");
			System.out.println("Please enter your Old password");
			String old = sc.next();
			if(old.equals(user.getLoginPassword())) {
			System.out.println("Please enter your new password (Maximum 15 characters)");
			String newpass = sc.next();
			System.out.println("Please re-enter your new password");
			String confpass = sc.next();
			if(newpass.equals(confpass)) {
				try {
					flag = service.changePassword(confpass,user.getUserId());
				} catch (BankingException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			else {
				flag = false;
			}
			} else {
				flag = false;
			}
			}while(!flag);
		}

		}
	}

}
