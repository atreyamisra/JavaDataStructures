package Assignment2;

public class CheckingAccount extends BankAccount{

	public CheckingAccount(double initialBalance) {
		super(initialBalance);
		// TODO Auto-generated constructor stub
	}
	public CheckingAccount(int acct, String owner, double initBalance) {
		super(acct, owner, initBalance);
		// TODO Auto-generated constructor stub
	}
	public void overdraft(double initBalance){
		initBalance = 0;
	}
}
