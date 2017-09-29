package com.cg.onlineBanking.ui;

import java.util.Scanner;

import com.cg.onlineBanking.bean.UserBean;

public class UserConsole {
	
	private UserBean user;
	public UserConsole(UserBean user) {
		this.user = user; 
	}

	public void start() {
		System.out.println("Running succesfully");
		System.out.println(user);
		
		Scanner sc=new Scanner(System.in);
		int choice;
		System.out.println("Welcome");
		
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
			
		}

		}
	}

}
