package bank;

public class CheckingAccount extends BankAccount implements Printable {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() { return this.overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }

    @Override
    public void deposit(double amount) {
        if(amount < 0) {
            System.out.println("Amount mustn't zero or below.");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("Successfully deposited " + CURRENCY + String.format("%.2f", amount) + " to Checking Account");
            System.out.println("New Balance: "+ CURRENCY + String.format("%.2f", getBalance()));
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > getBalance() + overdraftLimit){
            System.out.println("Withdrawal denied. Amount exceeds the balance and overdraft limit.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrawn " + CURRENCY + String.format("%.2f", amount) + " from Checking Account.");
            System.out.println("Remaining Balance: " + CURRENCY + String.format("%.2f", getBalance()));
        }
    }

    @Override
    public void printAccountDetails() {
        System.out.println("\n=== Checking Account Details ===");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Balance: "+ CURRENCY + String.format("%.2f", getBalance()));
        System.out.println("Overdraft Limit: " + CURRENCY + String.format("%.2f", getOverdraftLimit()));
    }
}
