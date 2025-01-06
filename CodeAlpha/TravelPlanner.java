import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String name;
    private String date;
    private String weather;
    private double cost;

    public Destination(String name, String date, String weather, double cost) {
        this.name = name;
        this.date = date;
        this.weather = weather;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getWeather() {
        return weather;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nDate: " + date + "\nWeather: " + weather + "\nEstimated Cost: $" + cost;
    }
}

class TravelItinerary {
    private ArrayList<Destination> destinations = new ArrayList<>();
    private double budget;

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void addDestination(String name, String date, double cost) {
        String weather = getMockWeather(name); // Mock weather
        destinations.add(new Destination(name, date, weather, cost));
    }

    public void displayItinerary() {
        System.out.println("\n--- Travel Itinerary ---");
        double totalCost = 0;
        for (Destination dest : destinations) {
            System.out.println(dest);
            System.out.println("---------------------");
            totalCost += dest.getCost();
        }
        System.out.println("Total Estimated Cost: $" + totalCost);
        System.out.println("Budget: $" + budget);
        if (budget >= totalCost) {
            System.out.println("You are within your budget!");
        } else {
            System.out.println("Warning: You are over budget!");
        }
    }

    private String getMockWeather(String location) {
        // Simple mock weather data
        switch (location.toLowerCase()) {
            case "paris":
                return "Sunny";
            case "london":
                return "Rainy";
            case "tokyo":
                return "Cloudy";
            default:
                return "Unknown";
        }
    }
}

public class TravelPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItinerary itinerary = new TravelItinerary();

        System.out.print("Enter your total budget: $");
        double budget = scanner.nextDouble();
        itinerary.setBudget(budget);

        System.out.println("Enter destinations (type 'done' to finish): ");
        while (true) {
            System.out.print("Destination name: ");
            String name = scanner.next();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Travel date (YYYY-MM-DD): ");
            String date = scanner.next();

            System.out.print("Estimated cost: $");
            double cost = scanner.nextDouble();

            itinerary.addDestination(name, date, cost);
        }

        itinerary.displayItinerary();
        scanner.close();
    }
}
