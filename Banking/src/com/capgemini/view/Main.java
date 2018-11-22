package com.capgemini.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.service.ServiceInterface;
import com.capgemini.utils.Keyboard;

public class Main
{
	private static final String MENU [] = {"Create Account", "Deposit", "Withdraw", "Transfer"};
	
	public static void main (String [] args) throws Exception
	{
		ApplicationContext context = new AnnotationConfigApplicationContext ();
		
		((AnnotationConfigApplicationContext) context).scan ("com.capgemini");
		((AnnotationConfigApplicationContext) context).refresh ();
		
		ServiceInterface service = context.getBean (ServiceInterface.class);	
		
		int accountNumber;
		String name;
		double amount;

		int choice = -1;
		while (choice != 0)
		{
			choice = Keyboard.menuInput ("Banking System", MENU);
			
			switch (choice)
			{
				case 1:
					accountNumber = Keyboard.readInt ("Enter account number : ");
					name = Keyboard.readString ("Enter name           : ");
					amount = Keyboard.readDouble ("Enter amount         : ");
					
					System.out.println (service.createAccount (accountNumber, name, amount));
					break;
					
				case 2:
					accountNumber = Keyboard.readInt ("Enter account number : ");
					amount = Keyboard.readDouble ("Enter amount         : ");
					
					System.out.println (service.depositAmount (accountNumber, amount));
					break;
					
				case 3:
					accountNumber = Keyboard.readInt ("Enter account number : ");
					amount = Keyboard.readDouble ("Enter amount         : ");
					
					System.out.println (service.withdrawAmount (accountNumber, amount));
					break;
					
				case 4:
					int from = Keyboard.readInt ("Enter account number         : ");
					int to = Keyboard.readInt ("Enter account to transfer to : ");
					amount = Keyboard.readDouble ("Enter amount                 : ");
					
					System.out.println (service.fundTransfer (from, to, amount));
					
					service.depositAmount (to, 1);
					System.out.println (service.withdrawAmount (to, 1));
			}
		}
		
		((ConfigurableApplicationContext) context).close ();
		System.out.println ("*** End ***");
	}
}
