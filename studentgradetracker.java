import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeTracker {

    private Map<String, Double> grades;
    private double totalGrade;
    private int count;

    public GradeTracker() {
        this.grades = new HashMap<>();
        this.totalGrade = 0.0;
        this.count = 0;
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
        totalGrade += grade;
        count++;
    }

    public void displayGrades() {
        System.out.println("Grades:");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void calculateAverageGrade() {
        double averageGrade = totalGrade / count;
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Letter Grade: " + getLetterGrade(averageGrade));
        System.out.println("GPA: " + getGPA(averageGrade));
    }

    private String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    private double getGPA(double grade) {
        if (grade >= 90) {
            return 4.0;
        } else if (grade >= 80) {
            return 3.0;
        } else if (grade >= 70) {
            return 2.0;
        } else if (grade >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add Grade");
                System.out.println("2. Display Grades");
                System.out.println("3. Calculate Average Grade");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter subject: ");
                        String subject = scanner.next();
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        tracker.addGrade(subject, grade);
                        break;
                    case 2:
                        tracker.displayGrades();
                        break;
                    case 3:
                        tracker.calculateAverageGrade();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            }
        }
    }
}
