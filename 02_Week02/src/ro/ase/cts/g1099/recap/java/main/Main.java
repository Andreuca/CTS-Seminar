package ro.ase.cts.g1099.recap.java.main;

import java.util.ArrayList;
import java.util.List;

import ro.ase.cts.g1099.recap.java.exceptions.IllegalTransferException;
import ro.ase.cts.g1099.recap.java.exceptions.InsufficientFundsException;
import ro.ase.cts.g1099.recap.java.models.AccountType;
import ro.ase.cts.g1099.recap.java.models.BankAccount;
import ro.ase.cts.g1099.recap.java.models.Banker;

public class Main {

	public static void main(String[] args) throws IllegalTransferException, InsufficientFundsException {
		
		System.out.println("Hello, my friends!");
		
		List<BankAccount> accounts = new ArrayList<>();
		
		Banker lawrence = new Banker("LAW");
		
		BankAccount myDebit = lawrence.openAccount(AccountType.SAVINGS);
		BankAccount myCredit = lawrence.openAccount(AccountType.CURRENT);
		
		accounts.add(myCredit);
		accounts.add(myDebit);
		
		myCredit.transfer(myDebit, 1000);
		

	}

}