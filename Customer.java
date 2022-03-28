public class Customer {
    private long accNo;
    private String pin;
    private String custName;
    private String address;
    private String mobileNo;
    private int balance;
    public Customer(String pin, String custName, String address, String mobileNo){
        this.pin = pin;
        this.custName = custName;
        this.address = address;
        this.mobileNo = mobileNo;
        balance = 1000;
    }
    public long getAccNo(){
        return accNo;
    }
    public String getPin(){
        return pin;
    }
    public String getCustName(){
        return custName;
    }
    public String getAddress(){
        return address;
    }
    public String getMobileNo(){
        return mobileNo;
    }
    public int getBalance(){
        return balance;
    }

    public void setAccNo(long accNo){
        this.accNo = accNo;
    }
    public void setPin(String pin){
        this.pin = pin;
    }
    public void setCustName(String custName){
        this.custName = custName;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }

    public String toString(){
        return accNo + ',' + custName + ',' + address + ',' + mobileNo + ',' + balance;
    }

    public void deposit(int amount){
        balance+=amount;
        return ;
    }

    public int withdraw(int amount){
        if(balance-amount<1000){
            return 0;
        }
        balance-=amount;
        return 1;
    }

    public void display(){
        System.out.println("Account Number: "+accNo);
        System.out.println("Name: "+custName);
        System.out.println("Address: "+address);
        System.out.println("Balance: "+balance);
    }
    
}
