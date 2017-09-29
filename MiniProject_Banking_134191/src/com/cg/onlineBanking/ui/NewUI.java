package com.cg.onlineBanking.ui;

import java.util.Scanner;

import com.cg.onlineBanking.bean.UserBean;
import com.cg.onlineBanking.exception.BankingException;
import com.cg.onlineBanking.service.IUserService;
import com.cg.onlineBanking.service.UserService;

public class NewUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int userId =0;
		String password;
		IUserService userService = new UserService(); 
		
		
		UserBean user ;
		UserBean resultUser=new UserBean() ;
		boolean flagu=false;
		boolean flagp=false;
		boolean flag=false;
		
		System.out.println("Welocme to Banking Application");
		
		do{

			
			System.out.println("Please enter your UserId");
			userId = sc.nextInt();
			System.out.println("Please enter your Password");
			password = sc.next();
			
				user= new UserBean(userId,password);
				
				if(userId==5&&"admin".equals(password)){
					flag =true;
				}else{
					try {
						
						resultUser= userService.validateCredentials(user);
						if(resultUser.getUserId()==0){
							flagu=false;
							System.out.println("UserId doesn't exists.");
						}
						else if(resultUser.getLoginPassword()==null){
							flagp = false;
							System.out.println("Password doesn't match.");
						}
						else {
							flagu=true;
							flagp=true;
						}
	
					}catch (BankingException e) {
					System.out.println("asdfghj");
					}
				}
			}while(!(flagu||flagp||flag));
				
			if(!flag){
			UserConsole uConsole = new UserConsole(resultUser);
			uConsole.start();
			}else
			{
				AdminConsole aConsole = new AdminConsole();
				aConsole.start();
				
			}
			
	}
	
}