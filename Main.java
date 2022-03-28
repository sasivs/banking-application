import java.util.*;
public class Main {
    public static Customer createAccount(){
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String custName = sc.nextLine();
		System.out.println("Enter your address");
		String address = sc.nextLine();
		System.out.println("Enter your mobile number");
		String mobileNo = sc.nextLine();
		while(checkMobileNumber(mobileNo)==false) {
			System.out.println("Enter valid 10 digit mobile number");
			mobileNo = sc.nextLine();
		}
		System.out.println("Enter your pin");
		String pin = sc.nextLine();
		while(checkPin(pin)==false) {
			System.out.println("Enter valid 4 digit pin number");
			pin = sc.nextLine();
		}
		Customer c = new Customer(pin, custName, address, mobileNo);
		return c;
    }
    public static boolean checkMobileNumber(String mobileNo) {
    	if(mobileNo.length()==10) {
    		return true;
    	}
    	return false;
    }
    public static boolean checkPin(String pin) {
    	if(pin.length()==4) {
    		return true;
    	}
    	return false;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
		Bank b1 = new Bank();
		System.out.println("Welcome");
		System.out.println("Services");
		int choice;
		do{
		    System.out.println("1. Create an Account");
		    System.out.println("2. Balance Enquiry");
		    System.out.println("3. Deposit Amount");
		    System.out.println("4. Withdraw Amount");
		    System.out.println("5. Change Mobile Number");
		    System.out.println("6. Exit");
		    System.out.println("Enter your choice");
		    choice = sc.nextInt();
		    sc.nextLine();
		    long accNo;
		    Customer c;
		    int amount;
			String pin;
		    switch(choice){
		        case 1:
		            c = createAccount();
		            c.setAccNo(b1.custList.size()+1);
		            b1.addCustomer(c);
		            System.out.println("Account created successfully");
		            c.display();
		            System.out.println();
		            break;
		        case 2:
		            System.out.println("Enter Account Number");
		            accNo = sc.nextLong();
		            sc.nextLine();
		            System.out.println("Enter your pin");
		            pin = sc.nextLine();
		            if((c=b1.validatePin(accNo, pin))!=null){
		                System.out.println("Your Account Balance is Rs."+c.getBalance());
		                System.out.println();
		            }
		            else{
		                System.out.println("Invalid credentials");
		                System.out.println();
		            }
		            break;
		        case 3:
		            System.out.println("Enter Account Number");
		            accNo = sc.nextLong();
		            sc.nextLine();
		            if((c=b1.getCustomer(accNo))!=null){
		                System.out.println("Enter Deposit Amount");
		                amount = sc.nextInt();
		                sc.nextLine();
		                c.deposit(amount);
		                System.out.println("Rs."+amount+" deposited to account No: "+accNo);
		                System.out.println();
		            }
		            else{
		                System.out.println("Invalid Account Number");
		                System.out.println();
		            }
		            break;
		        case 4:
		            System.out.println("Enter Account Number");
		            accNo =  sc.nextLong();
		            sc.nextLine();
		            System.out.println("Enter pin");
		            pin = sc.nextLine();
		            if((c=b1.validatePin(accNo, pin))!=null){
		                System.out.println("Enter amount to withdraw");
		                amount = sc.nextInt();
		                if(c.withdraw(amount)==0){
		                    System.out.println("Insufficient balance");
		                    System.out.println();
		                }
		                else{
		                    System.out.println("Amount withdrawn successfully");
		                    System.out.println("Available Balance is Rs."+c.getBalance());
		                    System.out.println();
		                }
		            }
		            else{
		                System.out.println("Invalid credentials");
		                System.out.println();
		            }
		            break;
		        case 5:
		            System.out.println("Enter Account Number");
		            accNo =  sc.nextLong();
		            sc.nextLine();
		            System.out.println("Enter pin");
		            pin = sc.nextLine();
		            if((c=b1.validatePin(accNo, pin))!=null){
		                System.out.println("Enter new mobile number");
		                String mobileNo = sc.nextLine();
						while(checkMobileNumber(mobileNo)==false) {
							System.out.println("Enter valid 10 digit mobile number");
							mobileNo = sc.nextLine();
						}
		                c.setMobileNo(mobileNo);
		                System.out.println("Mobile Number updated successfully");
		                System.out.println();
		            }
		            else{
		                System.out.println("Invalid credentials");
		                System.out.println();
		            }
		            break;
		        case 6:
		            System.out.println("Thank you for choosing our service");
		            break;
		    }
		}while(choice!=6);
    }

}
