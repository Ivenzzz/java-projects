import java.util.Scanner;

public class StudentGrades {
    // set all variables to private static in order for other methods to access it
    // why not?
    // i will fix this 10 years later
    private static Scanner scanner = new Scanner(System.in);
    private static int highestGrade = 0;
    private static double averageGrade = 0.00;
    private static int studentSize = 0;
    private static String[] students;
    private static int[] grades;
    public static void main(String[] args) {

        // try-catch for inputting wrong data types
        try {
            System.out.print("Enter the number of students: ");
            studentSize = scanner.nextInt();
            students = new String[studentSize]; // set the students array size based on the entered value
            grades = new int[studentSize];  // set the grades array size based on the entered value

            // prompt the user for name and grade of student and store it in the array
            for (int i = 0; i < studentSize; i++) {
                System.out.printf("Enter the name of student %d: ", i + 1);
                String studentName = scanner.next();
                System.out.printf("Enter the grade of student %d: ", i + 1);
                int studentGrade = scanner.nextInt();
                students[i] = studentName; 
                grades[i] = studentGrade; 
            }

            // calculate the highest and average grade using helper methods
            highestGrade = getHighestGrade();
            averageGrade = getAverageGrade();
            printGradesSummary(students, grades, averageGrade, highestGrade);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static int getHighestGrade() {
        for (int i = 0; i < studentSize; i++) {
            highestGrade = Math.max(grades[i], highestGrade);
        }
        return highestGrade;
    }

    public static double getAverageGrade() {
        int total = 0;
        for (int i = 0; i < studentSize; i++) {
            total += grades[i];
        }
        double averageGrade = total / studentSize;
        return averageGrade;
    }

    // display grades info
    // pass students and grades array as well as the calculated average and highest grade
    public static void printGradesSummary(String[] students, int[] grades, double average, int highest) {

        System.out.println("--------------------------------------");
        System.out.println("Grades Summary");
        System.out.println("--------------------------------------");

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%s = %d\n", students[i], grades[i]);
        }

        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Highest: %d\n", highest);

    }
}