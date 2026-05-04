import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int subjects;
        int totalMarks = 0;

        System.out.print("Enter number of subjects: ");
        subjects = sc.nextInt();

        int[] marks = new int[subjects];

        // Input marks
        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter valid marks: ");
                sc.next();
            }

            marks[i] = sc.nextInt();

            // Optional validation (0–100)
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Marks should be between 0 and 100. Re-enter: ");
                marks[i] = sc.nextInt();
            }

            totalMarks += marks[i];
        }

        // Calculate average
        double average = (double) totalMarks / subjects;

        // Grade calculation
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n=== RESULT ===");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}