package Assignment2;

import javax.swing.JOptionPane;

public class Driver {
	protected static Customer customer1, customer2, currentCustomer;
	public static void main (String[] args){
		int x = 1;
		customer1 = new Customer(1);
		customer2 = new Customer(2);
		while(x==1){
			String inputs;
			double amount2 = 0;
			inputs = JOptionPane.showInputDialog("Enter Transaction: ");
			String[] inputing = inputs.split(" ");
			int customerID = Integer.parseInt(inputing[0]);
			String transactionType = inputing[1];
			double amount = Double.parseDouble(inputing[2]);
			String accountType = inputing[3];
			String accountType2 = "0";
			try{
				if(transactionType.equals("T")){
					accountType2 = inputing[4];
				}
				else
					accountType2 = "0";
			}catch(IndexOutOfBoundsException e){
				System.out.println("Incorrect Input");
			}
			
			if (customerID == 1){
				currentCustomer = customer1;
			}
			if (customerID == 2){
				currentCustomer = customer2;
			}
			if(transactionType.equals("D")){
				if(accountType.equals("C")){
					currentCustomer.getCheckAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was deposited into the checking account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
				}
				else if(accountType.equals("S")){
					currentCustomer.getPrimaryAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was deposited into the primary savings account.");
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else if(accountType.equals("L")){
					currentCustomer.getStudentAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was deposited into the student loan account.");
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
				}
				else if(accountType.equals("A")){
					currentCustomer.getAutoAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was deposited into the auto loan account.");
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else{
					System.out.println("Incorrect Input");
				}
			}
			else if(transactionType.equals("W")){
				if(accountType.equals("C")){
					if(currentCustomer.getCheckAccount().getBalance() < amount){
						currentCustomer.getCheckAccount().withdraw(amount);
						amount2 = currentCustomer.getCheckAccount().getBalance();
						amount = amount - amount2;
						if(currentCustomer.getPrimaryAccount().getBalance() < (amount + 20)){
							System.out.println("Incorrect Input");
						}
						else{
							currentCustomer.getPrimaryAccount().withdraw(amount + 20.0);
							currentCustomer.getCheckAccount().withdraw(amount2);
							System.out.println("The checking account is now empty and the savings account was charged 20 for overdraft protection.");
							System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
							System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
						}
					}
					else {
						currentCustomer.getCheckAccount().withdraw(amount);
						System.out.println("The amount of " + amount + " was withdrew from the checking account.");
						System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
						
					}
				}
				else if(accountType.equals("S")){
					currentCustomer.getPrimaryAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was withdrew from the primary savings account.");
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else if(accountType.equals("L")){
					currentCustomer.getStudentAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was withdrew from the student loan account.");
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
				}
				else if(accountType.equals("A")){
					currentCustomer.getAutoAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was withdrew from the auto loan account.");
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else{
					System.out.println("Incorrect Input");
				}
			}
			else if(transactionType.equals("I")){
				if(accountType.equals("S")){
					if(currentCustomer.getPrimaryAccount().getBalance() >= 1000){
						currentCustomer.getPrimaryAccount().interest();
						System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance() + " after a 4% interest added.");
					}
					else
						System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance() + " because no interest was added because the account does not reach the 1000 minimum for interest.");
				}
				else{
					System.out.println("Incorrect Input");
				}
			}
			else if(transactionType.equals("T")){
				if(accountType.equals("C") && accountType2.equals("S")){
					currentCustomer.getCheckAccount().withdraw(amount);
					currentCustomer.getPrimaryAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was transferred from the checking account to the savings account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else if(accountType.equals("S") && accountType2.equals("C")){
					currentCustomer.getCheckAccount().deposit(amount);
					currentCustomer.getPrimaryAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the savings account to the checking account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else if(accountType.equals("S") && accountType2.equals("A")){
					currentCustomer.getAutoAccount().deposit(amount);
					currentCustomer.getPrimaryAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the savings account to the auto loan account.");
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else if(accountType.equals("S") && accountType2.equals("L")){
					currentCustomer.getStudentAccount().deposit(amount);
					currentCustomer.getPrimaryAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the savings account to the student loan account.");
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
				}
				else if(accountType.equals("C") && accountType2.equals("A")){
					currentCustomer.getCheckAccount().withdraw(amount);
					currentCustomer.getAutoAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was transferred from the checking account to the auto loan account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else if(accountType.equals("C") && accountType2.equals("L")){
					currentCustomer.getCheckAccount().withdraw(amount);
					currentCustomer.getStudentAccount().deposit(amount);
					System.out.println("The amount of " + amount + " was transferred from the checking account to the student loan account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
				}
				else if(accountType.equals("L") && accountType2.equals("C")){
					currentCustomer.getCheckAccount().deposit(amount);
					currentCustomer.getStudentAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the student loan account to the checking account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
				}
				else if(accountType.equals("L") && accountType2.equals("A")){
					currentCustomer.getAutoAccount().deposit(amount);
					currentCustomer.getStudentAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the student loan account to the auto loan account.");
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else if(accountType.equals("L") && accountType2.equals("S")){
					currentCustomer.getPrimaryAccount().deposit(amount);
					currentCustomer.getStudentAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the student loan account to the primary savings account.");
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else if(accountType.equals("A") && accountType2.equals("C")){
					currentCustomer.getCheckAccount().deposit(amount);
					currentCustomer.getAutoAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the auto loan account to the checking account.");
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else if(accountType.equals("A") && accountType2.equals("L")){
					currentCustomer.getStudentAccount().deposit(amount);
					currentCustomer.getAutoAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the auto loan account to the student loan account.");
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else if(accountType.equals("A") && accountType2.equals("S")){
					currentCustomer.getPrimaryAccount().deposit(amount);
					currentCustomer.getAutoAccount().withdraw(amount);
					System.out.println("The amount of " + amount + " was transferred from the auto loan account to the primary savings account.");
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else{
					System.out.println("Incorrect Input");
				}
				
			}
			else if(transactionType.equals("G")){
				if(accountType.equals("C")){
					System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
				}
				else if(accountType.equals("S")){
					System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
				}
				else if(accountType.equals("L")){
					System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
				}
				else if(accountType.equals("A")){
					System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
				}
				else{
					System.out.println("Incorrect Input");
				}
			}
			else{
				System.out.println("Incorrect Input");
			}
			String continuer = JOptionPane.showInputDialog("Next Transaction(Y/N)?: ");
			if(continuer.equals("N"))
				break;
		}
		System.out.println("The checking account now has a balance of " + currentCustomer.getCheckAccount().getBalance());
		System.out.println("The primary savings account now has a balance of " + currentCustomer.getPrimaryAccount().getBalance());
		System.out.println("The student loan account now has a balance of " + currentCustomer.getStudentAccount().getBalance());
		System.out.println("The auto loan account now has a balance of " + currentCustomer.getAutoAccount().getBalance());
	}
}
