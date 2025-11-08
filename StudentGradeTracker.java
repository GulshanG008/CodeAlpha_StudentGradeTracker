package CodeAlpha_Internship;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Grades");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(name));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    Student studentToAddGrade = findStudent(students, name);
                    if (studentToAddGrade != null) {
                        System.out.print("Enter grade: ");
                        int grade = scanner.nextInt();
                        studentToAddGrade.addGrade(grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    Student studentToDisplay = findStudent(students, name);
                    if (studentToDisplay != null) {
                        studentToDisplay.displayGrades();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    Student studentToCalculate = findStudent(students, name);
                    if (studentToCalculate != null) {
                        double average = studentToCalculate.calculateAverage();
                        System.out.printf("Average grade for %s: %.2f%n", name, average);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Student findStudent(ArrayList<Student> students, String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
}    
}
