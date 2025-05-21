import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Gradebook Menu ---");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. List students");
            System.out.println("4. Show class average");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(name);

                    System.out.print("How many grades to enter? ");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Grade " + (i + 1) + ": ");
                        double grade = scanner.nextDouble();
                        student.addGrade(grade);
                    }
                    gradebook.addStudent(student);
                }
                case 2 -> {
                    System.out.print("Enter student name to remove: ");
                    String name = scanner.nextLine();
                    gradebook.removeStudent(name);
                }
                case 3 -> gradebook.listStudents();
                case 4 -> System.out.printf("Class average: %.2f%n", gradebook.getClassAverage());
                case 5 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
