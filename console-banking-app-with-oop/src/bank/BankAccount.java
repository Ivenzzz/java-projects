package bank;

public abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    protected final String CURRENCY = "\u20B1";

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        setBalance(balance);
    }

    public String getAccountNumber() { return this.accountNumber; }
    public String getAccountHolder() { return this.accountHolder; }
    public double getBalance() { return this.balance; }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }

    public void setBalance(double balance) {
        if(balance < 0) {
            System.out.println("Balance cannot be negative.");
            throw new IllegalArgumentException("Balance cannot be negative.");
        } else {
            this.balance = balance;
        }
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);


}
