package Assignment2;

import java.security.acl.Owner;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(double initialBalance) {
		super(initialBalance);
		// TODO Auto-generated constructor stub
	}
	public SavingsAccount(int acct, String owner, double initBalance) {
		super(acct, owner, initBalance);
		// TODO Auto-generated constructor stub
	}
	public void interest(){
		balance = balance*1.04;
	}
}
