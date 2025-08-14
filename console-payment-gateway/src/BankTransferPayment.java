public class BankTransferPayment extends Payment {
    private String accountHolder;
    private String accountNumber;

    BankTransferPayment(String transactionID, double amount, String accountHolder, String accountNumber) {
        super(transactionID, amount);
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() { return this.accountHolder; }
    public String getAccountNumber() { return this.accountNumber; }

    public void setAccountHolder() { this.accountHolder = accountHolder; }
    public void setAccountNumber() { this.accountNumber = accountNumber; }

    @Override
    public void processPayment() {
        System.out.println("==========================================================");
        System.out.println("Payment has been processed.");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Bank Account Holder: " + getAccountHolder());
        System.out.println("Bank Account Number: " + getAccountNumber());
        System.out.println("Amount: " + getAmount());
    }
}
