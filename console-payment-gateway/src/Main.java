public class Main {
    public static void main(String[] args) {
        Payment[] payments = {
                new BankTransferPayment("492129", 1000, "John Doe", "09505161947"),
                new PaypalPayment("911291", 5000, "johndoe@gmail.com"),
                new CreditCardPayment("492190", 2000, "421-2982-9210")
        };

        PaymentProcessor paymentProcessor = new PaymentProcessor(payments);

        paymentProcessor.refundPayments();
    }
}