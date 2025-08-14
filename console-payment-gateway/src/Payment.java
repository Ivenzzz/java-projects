abstract public class Payment {
    private String transactionID;
    private double amount;

    Payment(String transactionID, double amount) {
        this.transactionID = transactionID;
        setAmount(amount);
    }

//    Setters
    public void setTransactionID(String transactionID) { this.transactionID = transactionID; }
    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount mustn't zero and below.");
        }
    }

//    Getters
    public String getTransactionID() { return this.transactionID; }
    public double getAmount() { return this.amount; }

    public void printReceipt() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount" + amount);
    }

//    Abstract methods
    public abstract void processPayment();
}
