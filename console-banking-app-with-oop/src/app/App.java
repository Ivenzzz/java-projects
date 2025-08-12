package app;

import bank.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount[] bankAccounts = {
            new SavingsAccount("09308303491", "John Doe", 0, 20),
            new CheckingAccount("09108592190", "Grace Hopkins", 0, 2000)
        };

        System.out.println("================= WELCOME TO LANDBANK ATM ===================");

        System.out.print("Enter the account number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter the account holder name: ");
        String accHolder = scanner.nextLine();

        BankAccount selectedAccount = null;
        for (BankAccount account: bankAccounts) {
            if (account.getAccountNumber().equals(accNumber) && account.getAccountHolder().equalsIgnoreCase(accHolder)) {
                selectedAccount = account;
            }
        }

        if (selectedAccount == null) {
            System.out.println("Account not found!");
            scanner.close();
            return;
        }

        System.out.println("Account Found!");
        if(selectedAccount instanceof Printable) {
            ((Printable) selectedAccount).printAccountDetails();
        }

        while (true) {
            System.out.println("\nChoose an operation: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1 -> {
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    selectedAccount.deposit(depositAmount);
                }
                case 2 -> {
                    System.out.print("Enter the withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    selectedAccount.withdraw(withdrawAmount);
                }
                case 3 -> {
                    System.out.printf("Current Balance: %.2f%n", selectedAccount.getBalance());
                }
                case 4 -> {
                    System.out.println("Thank you for banking with us.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
