import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Create an array to store the grades
        int[] grades = new int[numStudents];

        // Get the grades for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        // Calculate the sum, highest, and lowest grades
        int sum = 0;
        int highest = grades[0];
        int lowest = grades[0];

        for (int i = 0; i < numStudents; i++) {
            sum += grades[i];
            
            // Update highest grade if current grade is greater
            if (grades[i] > highest) {
                highest = grades[i];
            }
            
            // Update lowest grade if current grade is smaller
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        // Calculate the average grade
        double average = (double) sum / numStudents;

        // Print the results
        System.out.println("\nResults:");
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);

        scanner.close();
    }
}
