import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<Double> grades;

    public StudentGradeTracker() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double findHighestScore() {
        if (grades.isEmpty()) {
            return 0;
        }
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public double findLowestScore() {
        if (grades.isEmpty()) {
            return 0;
        }
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public void displayResults() {
        System.out.println("Average score: " + calculateAverage());
        System.out.println("Highest score: " + findHighestScore());
        System.out.println("Lowest score: " + findLowestScore());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        System.out.println("Enter student grades (type -1 to finish):");
        while (true) {
            double grade = scanner.nextDouble();
            if (grade == -1) {
                break;
            }
            tracker.addGrade(grade);
        }

        tracker.displayResults();
        scanner.close();
    }
}
