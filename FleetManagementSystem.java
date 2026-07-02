import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    int id;
    String name;
    String type;

    Vehicle(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Type: " + type;
    }
}

public class FleetManagementSystem {
    static ArrayList<Vehicle> fleet = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addVehicle() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Vehicle Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String type = sc.nextLine();

        fleet.add(new Vehicle(id, name, type));
        System.out.println("Vehicle Added Successfully!");
    }

    public static void viewVehicles() {
        if (fleet.isEmpty()) {
            System.out.println("No Vehicles Found.");
            return;
        }

        System.out.println("\nVehicle List:");
        for (Vehicle v : fleet) {
            System.out.println(v);
        }
    }

    public static void updateVehicle() {
        System.out.print("Enter Vehicle ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Vehicle v : fleet) {
            if (v.id == id) {
                System.out.print("Enter New Vehicle Name: ");
                v.name = sc.nextLine();

                System.out.print("Enter New Vehicle Type: ");
                v.type = sc.nextLine();

                System.out.println("Vehicle Updated Successfully!");
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    public static void deleteVehicle() {
        System.out.print("Enter Vehicle ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < fleet.size(); i++) {
            Vehicle v = fleet.get(i);
            if (v.id == id) {
                fleet.remove(i);
                System.out.println("Vehicle Deleted Successfully!");
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Fleet Management System =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    viewVehicles();
                    break;
                case 3:
                    updateVehicle();
                    break;
                case 4:
                    deleteVehicle();
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
