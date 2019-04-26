

public class BankAccount{
    private double balance = 0.0;
    private String accountNumber = "9999";
    private Customer accountHolder; //instance of Customer accountHolder not initialize yet

//Constructors
    // Default (no arguments)
    // One that takes a start balance
    // One that takes a balance and accountNumber
    // One that takes a customer and balance
    // Need constructor to allow creation of bank accounts to specify accountHolder

    public BankAccount(){
    }

    /**
    * BankAccount(double bal) will allow user to input a starting balance
    * @param bal
    */
    public BankAccount(double bal){
        this.balance = bal;
    }
    /**
    * BankAccount(double bal, String account) will allow user to input a starting balance and accountNumber
    * @param bal
    * @param account
    */
    public BankAccount(double bal, String account){
        this.balance = bal;
        this.accountNumber = account;
    }

    /**
    * BankAccount(Customer accountHolder, double bal) will allow to user to input a customer name and id with a balance
    * @param accountHolder
    * @param bal
    */
    public BankAccount(Customer c, double bal){
        this.accountHolder = c;
        this.balance = bal;

    }


// Copy Constructor
    /**
    * BankAccount(BankAccount copy) will allow the user to create a copy constructor to have the same values of the intial instance variables
    * @param copy
    */
    BankAccount(BankAccount copy){
        this.balance = copy.balance;
        this.accountHolder = copy.accountHolder;
    }

// Mutator (setter) Methods
    /**
    * deposit(double amount) method will deposit amount if the amount is greater than 0
    * @param amount
    */
    public void deposit(double amount){
        if (amount >= 0){
            balance = balance + amount;
        }
    }
    /**
    * withdraw(double amount) method will withdraw the amount if the amount is greater than 0 and the balance is test_deposit_negativeAmount
    * @param amount
    */
    public void withdraw(double amount){
        if (amount >= 0 && balance - amount >= 0){
            balance = balance - amount;
        }
    }

    /**
    * setAccountHolder(Customer c) method will setAccountHolder of the Customer class to a parameter
    * @param c
    */
    public void setAccountHolder(Customer c){
        accountHolder = c;
    }


    /**
    * transfer(double amount, BankAccount b) will transfer amount from the original balance to the second balance
    * @param amount
    * @param b
    */
    public void transfer(double amount, BankAccount b) {
        if (balance >= amount){
            withdraw(amount);//first balance in the account to transfer to second BankAccount object
            b.deposit(amount);
        }
    }

//Accessor (getter) methods
    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public Customer getAccountHolder(){
        return accountHolder;
    }


    public String toString(){
        return "(" + accountHolder.toString() + ")" + " " +  accountNumber + ": " + balance;
    }





}
