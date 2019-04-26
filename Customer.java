public class Customer {
    private String name = "";
    private int customerID = 0;


    // Default Constructor
    public Customer(){
    }

    public Customer(String customerName, int id){
        this.name = customerName;
        this.customerID = id;
    }

    Customer(Customer c){
        name = c.name;
        customerID = c.customerID;

    }


    //Setters
    public void setName(String customer){
        name = customer;
    }

    public void setCustomerID(int id){
        customerID = id;
    }

    public String toString(){
        return (name + " " + customerID);
    }

    //Getters
    public String getName(){
        return name;
    }
    public int getID(){
        return customerID;
    }

}
