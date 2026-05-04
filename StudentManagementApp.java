import java.util.*;
import java.io.*;

// Student class
class Student implements Serializable {
    String name;
    int rollNo;
    String grade;

    public Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Grade: " + grade;
    }
}

// Student Management System
class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add student
    void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter grade: ");
        String grade = sc.next();

        students.add(new Student(name, roll, grade));
        System.out.println("Student added successfully!");
    }

    // Display all students
    void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search student
    void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Remove student
    void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.rollNo == roll) {
                it.remove();
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Save to file
    void saveToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"));
            out.writeObject(students);
            out.close();
            System.out.println("Data saved to file.");
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

    // Load from file
    void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"));
            students = (ArrayList<Student>) in.readObject();
            in.close();
            System.out.println("Data loaded from file.");
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
}

// Main class
public class StudentManagementApp {
    public static void main(String[] args) {

        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        sms.loadFromFile();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Save Data");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.displayStudents();
                    break;
                case 3:
                    sms.searchStudent();
                    break;
                case 4:
                    sms.removeStudent();
                    break;
                case 5:
                    sms.saveToFile();
                    break;
                case 6:
                    sms.saveToFile();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}