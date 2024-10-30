import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name, grade;
    int rollNumber;

    public Student(String name, int rollNumber, String grade) {
        this.name = name; this.rollNumber = rollNumber; this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) { students.add(student); }
    public void removeStudent(int rollNumber) { students.removeIf(s -> s.rollNumber == rollNumber); }
    public Student searchStudent(int rollNumber) { return students.stream().filter(s -> s.rollNumber == rollNumber).findFirst().orElse(null); }
    public void displayAllStudents() { if (students.isEmpty()) System.out.println("No students."); else students.forEach(System.out::println); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.print("\n1. Add\n2. Remove\n3. Search\n4. Display\n5. Exit\nChoose: ");
            int choice = scanner.nextInt();
            if (choice == 5) break;

            if (choice == 1) {
                System.out.print("Name: "); String name = scanner.next();
                System.out.print("Roll No: "); int roll = scanner.nextInt();
                System.out.print("Grade: "); String grade = scanner.next();
                sms.addStudent(new Student(name, roll, grade));
            } else if (choice == 2) {
                System.out.print("Roll No to remove: "); sms.removeStudent(scanner.nextInt());
            } else if (choice == 3) {
                System.out.print("Roll No to search: ");
                Student s = sms.searchStudent(scanner.nextInt());
                System.out.println(s == null ? "Not found." : s);
            } else if (choice == 4) {
                sms.displayAllStudents();
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
        System.out.println("Bye!");
    }
}
