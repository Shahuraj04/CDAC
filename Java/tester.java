package com.bms.ui;

import java.util.ArrayList;

import com.bms.core.BankAccount;
import com.bms.customExceptions.BankingExceptions;
import com.bms.service.BMSValidations;

public class tester{
	public static void main(String[] args) throws BankingExceptions {
		
//		ArrayList<BankAccount> list = new ArrayList<>();
//		list.add(new BankAccount(101,1000,"Shahu",null,SAVING,null));
//		for(BankAccount a : list) {
//			System.out.println(a);
//			BMSValidations.checkForDup(101, list);
//		}
		
		System.out.println(BMSValidations.checkAccountType("Dmat"));
	}
}