import java.util.Scanner;

public class SimpleHotelReservationSystem {
    static boolean[] rooms = new boolean[10]; // Array to track room availability
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                viewAvailableRooms();
            } else if (choice == 2) {
                bookRoom();
            } else if (choice == 3) {
                System.out.println("Thank you for using the Hotel Reservation System!");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // View available rooms
    static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i]) { // If the room is not booked
                System.out.println("Room " + (i + 1));
            }
        }
    }

    // Book a room
    static void bookRoom() {
        System.out.print("\nEnter room number to book (1-10): ");
        int roomNumber = scanner.nextInt();

        if (roomNumber < 1 || roomNumber > 10) {
            System.out.println("Invalid room number! Please enter a number between 1 and 10.");
        } else if (rooms[roomNumber - 1]) {
            System.out.println("Room " + roomNumber + " is already booked.");
        } else {
            rooms[roomNumber - 1] = true; // Mark the room as booked
            System.out.println("Room " + roomNumber + " booked successfully!");
        }
    }
}
