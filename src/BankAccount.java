/*This program constructs the object BankAccount which has a name and a balance
 * @author Colette Pujol
 * @version 1.0 22 March 2015
 */
public class BankAccount {
	private String name;
	private double balance;
	public BankAccount(String name, int balance){
		this.name=name;
		this.balance=balance;
	}
	public double getBalance(){ //get the value of the bank accounts balance
		return balance;
	}
	public String displayBankAccount(){ //prints out the name and balance of the bank account
		 return String.format("Account Name: %s\nBalance: %f",name,balance);
	}
	public double deposit(double amount){ //deposits an amount of money into the bank account
		balance=balance+amount;
		return balance;
	}
	public double withdrawal(double amount){ //withdraws an amount of money into the bank account
		balance=balance-amount;
		return balance;
	}

}


