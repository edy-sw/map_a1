package view;

import controller.Controller;
import exception.ParkingLotException;
import model.Bicycle;
import model.Car;
import model.Motorcycle;
import model.Vehicle;
import repository.InMemoryRepository;
import repository.RepositoryInterface;

public class View {
    public static void main(String[] args) {
        RepositoryInterface repo = new InMemoryRepository(10);
        Controller ctrl = new Controller(repo);

        System.out.println("=== 1. Adding entities to repository ===");
        try {
            ctrl.addVehicle(new Car("C1", "red"));
            ctrl.addVehicle(new Car("C2", "blue"));
            ctrl.addVehicle(new Motorcycle("M1", "RED"));
            ctrl.addVehicle(new Motorcycle("M2", "black"));
            ctrl.addVehicle(new Bicycle("B1", "Red"));
            ctrl.addVehicle(new Bicycle("B2", "green"));
            System.out.println("Entities added successfully.");
        } catch (ParkingLotException e) {
            System.err.println("Error adding vehicle: " + e.getMessage());
        }

        System.out.println("\n=== 2. Displaying all RED vehicles ===");
        Vehicle[] redVehicles = ctrl.filterRedVehicles();
        for (Vehicle v : redVehicles) {
            System.out.println(v);
        }

        System.out.println("\n=== 3. Testing removal of an entity ===");
        try {
            ctrl.removeVehicle("M1"); // Removing red motorcycle
            System.out.println("Removed vehicle with ID 'M1'.");
        } catch (ParkingLotException e) {
            System.err.println("Error removing vehicle: " + e.getMessage());
        }

        System.out.println("\n=== 4. Displaying all RED vehicles after removal ===");
        redVehicles = ctrl.filterRedVehicles();
        for (Vehicle v : redVehicles) {
            System.out.println(v);
        }

        System.out.println("\n=== 5. Testing Exception Handling ===");
        try {
            // Attempting to remove non-existent entity
            ctrl.removeVehicle("NON_EXISTENT_ID");
        } catch (ParkingLotException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
            // Attempting duplicate ID addition
            ctrl.addVehicle(new Car("C1", "yellow"));
        } catch (ParkingLotException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}