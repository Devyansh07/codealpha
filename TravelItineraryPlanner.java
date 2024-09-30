import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String preferences;
    double budget;

    public Destination(String name, String date, String preferences, double budget) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Preferences: " + preferences + ", Budget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    private ArrayList<Destination> itinerary;
    private double totalBudget;

    public TravelItineraryPlanner() {
        itinerary = new ArrayList<>();
        totalBudget = 0.0;
    }

    public void addDestination(String name, String date, String preferences, double budget) {
        Destination destination = new Destination(name, date, preferences, budget);
        itinerary.add(destination);
        totalBudget += budget;
    }

    public void displayItinerary() {
        System.out.println("\n--- Travel Itinerary ---");
        for (Destination dest : itinerary) {
            System.out.println(dest);
        }
        System.out.println("Total Budget: $" + totalBudget);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        String choice;

        do {
            System.out.println("\n--- Travel Itinerary Planner ---");
            System.out.print("Enter Destination Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Travel Date: ");
            String date = scanner.nextLine();
            System.out.print("Enter Preferences (e.g., food, activities): ");
            String preferences = scanner.nextLine();
            System.out.print("Enter Budget for this Destination: ");
            double budget = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            planner.addDestination(name, date, preferences, budget);

            System.out.print("Do you want to add another destination? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        planner.displayItinerary();
        scanner.close();
    }
}

