package controller;

import exception.ParkingLotException;
import model.Vehicle;
import repository.RepositoryInterface;

public class Controller {
    private final RepositoryInterface repo;

    public Controller(RepositoryInterface repo) {
        this.repo = repo;
    }

    public void addVehicle(Vehicle vehicle) throws ParkingLotException {
        repo.add(vehicle);
    }

    public void removeVehicle(String id) throws ParkingLotException {
        repo.remove(id);
    }

    public Vehicle[] filterRedVehicles() {
        Vehicle[] all = repo.getAll();
        int count = 0;

        for (Vehicle v : all) {
            if (v.isRed()) {
                count++;
            }
        }

        Vehicle[] redVehicles = new Vehicle[count];
        int idx = 0;
        for (Vehicle v : all) {
            if (v.isRed()) {
                redVehicles[idx++] = v;
            }
        }

        return redVehicles;
    }
}