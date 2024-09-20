
import java.util.Scanner;

class BankAccount {
	String name;
	String username;
	String accountNo;
	String userpin;
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name : ");
		this.name = sc.nextLine();
		System.out.println("Enter the Username : ");
		this.username = sc.nextLine();
		System.out.println("Enter your Account Number: ");
		this.accountNo = sc.nextLine();
		System.out.println("Set Your ATM UserPin: ");
		this.userpin = sc.nextLine();
		System.out.println();
		System.out.println("Registration successfull.Please Log in");
		System.out.println();
	}
	public boolean Login() {
		boolean islogin = false;
		Scanner sc = new Scanner(System.in);
		while(!islogin) {
			System.out.println("Enter the Username : ");
			String Username = sc.nextLine();
			if(Username.equals(username)) {
				while(!islogin) {
					System.out.println("Enter your Userpin: ");
					String Userpin = sc.nextLine();
					if(Userpin.equals(userpin)) {
						System.out.println("You are LOGGEDIN Successfully!");
						islogin = true;
					}
					else
						System.out.println("Invalid Password! Enter the correct Password");
				}
			}
			else
				System.out.println("Username not Found!");
		}
		return islogin;
	}
	
	public void transHistory() {
		if(transactions == 0) {
				System.out.println();
				System.out.println("No Transaction History\n");
		}
		else {
				System.out.println();
				System.out.println(transactionHistory);
		}
	}
	
	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the Amount: ");
		float amount = sc.nextFloat();
		if(balance >= amount) {
			transactions++;
			balance = balance - amount;
			System.out.println();
			System.out.println("Withdrawal is Successful!");
			System.out.println();
			String str = "Rs "+amount +" Withdrawn\n";
			transactionHistory = transactionHistory.concat(str);
		}
		else
			System.out.println("Insufficient Balance");
	}
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Amount : ");
		float amount = sc.nextFloat();
		transactions++;
		balance = balance + amount;
		System.out.println();
		System.out.println("Amount Deposited Successfully");
		System.out.println();
		String str = "Rs " + amount + " deposited\n"; 
		transactionHistory = transactionHistory.concat(str);
	}
	
	public void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Receipent's Name: ");
		String name = sc.nextLine();
		System.out.println("Enter the Bank Account Number: ");
		String accNo = sc.nextLine();
		System.out.println("Enter the Amount to Transfer: ");
		float amount = sc.nextFloat();
		if(balance >= amount) {
			transactions++;
			balance = balance - amount;
			System.out.println();
			System.out.println("Successfully transferred to "+name);
			System.out.println();
			String str = "Rs "+amount +" Transferred to " +name+ "Account Number : " + accNo + "\n" ;
			transactionHistory = transactionHistory.concat(str);
		}
		else
			System.out.println("Insufficient Balance");
	}
	
	public void checkBalance() {
		System.out.println("Balance: Rs "+balance);
	}
	
}


public class AtmInterface {

    public static int Registration() {
		Scanner sc =  new Scanner(System.in);
		int input;
		System.out.println("1.Register ");
		System.out.println("0.Exit");
		input = sc.nextInt();
		if(input != 0 && input!= 1)
			System.out.println("Invalid Input!");
		
		return input;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------WELCOME TO YO-YO BANK-----------------");
		int input = Registration();
		switch(input) {
			case 1:
				BankAccount ba = new BankAccount();
				ba.register();
				System.out.println();
				System.out.println("-----------------Welcome Back to YO-YO Bank-----------------");
				System.out.println("Please Login to continue ");
				System.out.println();
				ba.Login();
				boolean isFinished = false;
				while(!isFinished) {
					System.out.println("1. Transaction History");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposit");
					System.out.println("4. Transfer");
					System.out.println("5. Check Balance");
					System.out.println("6. Quit");
					
					int choice  = sc.nextInt();
					
					switch(choice) {
						case 1:
							ba.transHistory();
							break;
						case 2:
							ba.withdraw();
							break;
						case 3:
							ba.deposit();
							break;
						case 4:
							ba.transfer();
							break;
						case 5:
							ba.checkBalance();
							break;
						case 6:
							isFinished = true;
							break;
						default :
							System.out.println("Invalid choice!");
					}
				}
				break;
			case 0:
				System.exit(0);
		}
	}
}
