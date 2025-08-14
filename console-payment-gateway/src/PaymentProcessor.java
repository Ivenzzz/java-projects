public class PaymentProcessor {
    private Payment[] payments;

    public PaymentProcessor(Payment[] payments) {
        this.payments = payments;
    }

    public void processPayments() {
        for (Payment payment : payments) {
            payment.processPayment();
        }
    }

    public void refundPayments() {
        for (Payment payment : payments) {
            if (payment instanceof Refundable) {
                ((Refundable) payment).processRefund(payment.getAmount());
            } else {
                System.out.println("Payment type " + payment.getClass().getSimpleName() + " is not refundable");
            }
        }
    }
}
