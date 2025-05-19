// Copyright @2025 Iven Loro
// Inspired by: 'Bro Code' Youtube Channel

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double principal = 0, rate = 0, totalAmount;
        int timesCompounded = 0, years = 0;

        try {
            System.out.print("Enter the principal amount: ");
            principal = getPositiveDouble(scanner);

            System.out.print("Enter the rate (in percent): ");
            rate = getPositiveDouble(scanner) / 100;

            System.out.print("Enter the times compounded per year: ");
            timesCompounded = getPositiveInt(scanner);

            System.out.print("Enter the number of years: ");
            years = getPositiveInt(scanner);

            totalAmount = principal * Math.pow(1 + rate / timesCompounded, timesCompounded * years);

            System.out.println("Total Amount after " + years + (years > 1 ? " years: " : " year: ") + totalAmount);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Helper method to read a positive double
    public static double getPositiveDouble(Scanner scanner) {
        while (true) {
            try {
                double value = scanner.nextDouble();
                if (value <= 0) throw new IllegalArgumentException("Value must be positive.");
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next(); // clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Try again: ");
            }
        }
    }

    // Helper method to read a positive integer
    public static int getPositiveInt(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                if (value <= 0) throw new IllegalArgumentException("Value must be a positive integer.");
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
                scanner.next(); // clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Try again: ");
            }
        }
    }
}
