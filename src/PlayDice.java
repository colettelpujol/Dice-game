/*This program uses the classes Die, ShowDie, and BankAccount to create a dice game where 2 players can wager money and each roll a die.  The player that rolls an even number wins
 * @author Colette Pujol
 * @version 1.0 22 March 2015
 */
import javax.swing.*;
import java.util.*;
public class PlayDice{
    public PlayDice() {
    }
    public static void main(String[] args) {
		Die d1 = new Die(); //2 new die are created from the class Die
		Die d2 = new Die();
		Scanner input=new Scanner(System.in);
		String player1; 
		String player2;
		System.out.println("Enter the first player's name");  // the 2 players are asked to enter their names
		player1=input.next();
		System.out.println("Enter the second player's name");
		player2=input.next();
		BankAccount account1=new BankAccount(player1, 1000); //the names of the BankAccount objects are changed to the names of the players and each player is given $1000 to start playing
		BankAccount account2=new BankAccount(player2, 1000);
		System.out.println("\nplayer1 account:\n " + account1.displayBankAccount());
	    System.out.println("\nplayer2 account:\n " + account2.displayBankAccount());
	    do{
	    	double wage1;
	    	double wage2;
	    	System.out.println("\nHow much would the player " + player1 + " like to wager?"); //each player is asked to give their wager
	    	wage1=Double.parseDouble(input.next());
	    	System.out.println("\nHow much would the player " + player2 + " like to wager?");
	    	wage2=Double.parseDouble(input.next());
	    	if(wage1==0 || wage2==0){ //if either player wagers $0 the game ends
	    		System.exit(0);
	    	}
	    	if(wage1>account1.getBalance()){
	    		System.out.println("The player "+ player1 +" is trying to cheat and the game will end"); //if either player tries to wager more than their bank balance they are caught cheating and the game ends
	    		System.exit(0);
	    	}
	    	if(wage2>account2.getBalance()){
	    		System.out.println("The player " + player2 + " is trying to cheat and the game will end");
	    		System.exit(0);
	    	}
	    	int r1 = d1.roll(); //each player's die is rolled
	    	int r2 = d2.roll();
	    	System.out.println(player1 + " rolled a " + r1); 
	    	System.out.println(player2 + " rolled a " + r2);
	    	ShowDie sd1 = d1.display(0, 0);
	    	ShowDie sd2 = d2.display(110, 0);
	    	if(r1%2==0 && r2%2==1){ //if one player rolls an even number and the other an odd number, the player with the even number wins
	    		System.out.println(player1 +" wins!");
	    		account1.deposit(wage2);
	    		account2.withdrawal(wage2);
			
	    	}else if(r1%2==1 && r2%2==0){
	    		System.out.println(player2 + " wins!");
	    		account2.deposit(wage1);
	    		account1.withdrawal(wage2);
	    		
	    	}else //if both or neither of the players rolls an even number, the roll is a draw and neither player gains or loses money
	    		System.out.println("Draw");
	    	System.out.println(player1 + "Balance:" + account1.getBalance());
	    	System.out.println(player2 + "Balance:" + account2.getBalance());
	    	}while(account1.getBalance()>0 && account2.getBalance()>0); //the game continues until 1 of the players runs out of money
    }
}
	   
	    	