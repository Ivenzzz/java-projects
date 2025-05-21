import java.util.ArrayList;

public class Gradebook {
    private ArrayList<Student> students;

    public Gradebook() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in gradebook.");
            return;
        }

        for (Student s : students) {
            System.out.printf("Name: %s, Grades: %s, Avg: %.2f%n",
                    s.getName(), s.getGrades(), s.getAverage());
        }
    }

    public double getClassAverage() {
        if (students.isEmpty())
            return 0.0;
        double total = 0;
        for (Student s : students) {
            total += s.getAverage();
        }
        return total / students.size();
    }
}
