import java.util.*;
public class Bank{
    List<Customer> custList; 
    public Bank(){
        custList = new ArrayList<Customer>();
    }

    public void addCustomer(Customer c){
        custList.add(c);
    }

    public Customer validatePin(long accNo, String pin){
        Customer c = getCustomer(accNo);
        if(c==null){
            return null;
        }
        if(c.getPin().equals(pin)){
            return c;
        }
        return null;
    }

    public Customer getCustomer(long accNo){
    	Iterator <Customer> iter = custList.iterator();
    	while(iter.hasNext()) {
    		Customer cust = iter.next();
    		if(cust.getAccNo()==accNo) {
    			return cust;
    		}
    	}
        return null;
    }

    public void removeCustomer(long accNo){
        for(Customer cust : custList){
            if(cust.getAccNo()==accNo){
                custList.remove(cust);
            }
        }
    }

    public boolean hasCustomer(long accNo){
        for(Customer cust : custList){
            if(cust.getAccNo()==accNo){
                return true;
            }
        }
        return false;
    }

}