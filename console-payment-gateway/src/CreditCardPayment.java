public class CreditCardPayment extends Payment implements Refundable {
    private String cardNumber;
    CreditCardPayment(String transactionID, double amount, String cardNumber) {
        super(transactionID, amount);
        setCardNumber(cardNumber);
    }

    public String getCardNumber() { return this.cardNumber; }
    public void setCardNumber(String cardNumber) {
        if (cardNumber != null && cardNumber.length() >= 12) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Invalid Credit Card number.");
        }
    }

    @Override
    public void processPayment() {
        System.out.println("==========================================================");
        System.out.println("Payment has been processed.");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Credit Card Number: " + getCardNumber());
        System.out.println("Amount: " + getAmount());
    }

    @Override
    public void processRefund(double refundAmount) {
        System.out.println("Transaction has been reversed. Returning " + refundAmount + " to card" + maskCard());
    }

    private String maskCard() {
        if (cardNumber.length() > 4) {
            return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }
}
