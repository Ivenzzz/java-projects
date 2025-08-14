public class PaypalPayment extends Payment implements Refundable{
    public String paypalEmail;
    PaypalPayment(String transactionID, double amount, String paypalEmail) {
        super(transactionID, amount);
        this.paypalEmail = paypalEmail;
    }

    public String getPaypalEmail() { return this.paypalEmail; }
    public void setPaypalEmail() { this.paypalEmail = paypalEmail; }

    @Override
    public void processPayment() {
        System.out.println("==========================================================");
        System.out.println("Payment has been processed.");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Paypal Email: " + getPaypalEmail());
        System.out.println("Amount: " + getAmount());
    }

    @Override
    public void processRefund(double refundAmount) {
        System.out.println("Transaction has been reversed. Returning " + refundAmount + " to " + getPaypalEmail());
    }
}
