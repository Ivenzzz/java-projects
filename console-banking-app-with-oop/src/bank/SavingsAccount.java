package bank;

public class SavingsAccount extends BankAccount implements InterestBearing, Printable{
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return this.interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    @Override
    public void deposit(double amount) {
        if(amount < 0) {
            System.out.println("Amount mustn't zero or below.");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("Successfully deposited " + CURRENCY + String.format("%.2f", amount) + " to Savings Account");
            System.out.println("New Balance: " + CURRENCY + String.format("%.2f", getBalance()));
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount > getBalance()) {
            System.out.println("Withdrawing " + CURRENCY + String.format("%.2f", amount) + " is not enough for the balance of " + CURRENCY + String.format("%.2f", getBalance()));
        } else {
            setBalance(this.getBalance() - amount);
            System.out.println("Successfully withdrawn " + CURRENCY + String.format("%.2f", amount) + " from Savings Account");
            System.out.println("Remaining Balance: " + CURRENCY + String.format("%.2f", getBalance()));
        }
    }

    @Override
    public void applyInterest() {
        if(interestRate <= 0) {
            System.out.println("No interest applied.");
            return;
        }
        double interest = getBalance() * (interestRate / 100);
        setBalance(getBalance() + interest);
        System.out.println("Interest of " + interest + " applied.");
        System.out.println("New Balance: " + CURRENCY + String.format("%.2f", getBalance()));
    }

    @Override
    public void printAccountDetails() {
        System.out.println("\n=== Savings Account Details ===");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Balance: " + CURRENCY + String.format("%.2f", getBalance()));
        System.out.println("Interest Rate: " + getInterestRate() + "%");
    }
}
