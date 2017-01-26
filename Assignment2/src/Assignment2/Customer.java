package Assignment2;

public class Customer {
	protected int customerID;
	protected String transactionType;
	protected CheckingAccount check;
	protected SavingsAccount student, auto, primary;
	
	public Customer(int customer)
    {
        customerID = customer;
        check = new CheckingAccount(0);
        student = new SavingsAccount(0);
        auto = new SavingsAccount(0);
        primary = new SavingsAccount(0);
    }
	public CheckingAccount getCheckAccount(){
		return check;
	}
	public SavingsAccount getStudentAccount(){
		return student;
	}
	public SavingsAccount getAutoAccount(){
		return auto;
	}
	public SavingsAccount getPrimaryAccount(){
		return primary;
	} 
}
