package repository;

import exception.ParkingLotException;
import model.Vehicle;

public interface RepositoryInterface {
    void add(Vehicle vehicle) throws ParkingLotException;
    void remove(String id) throws ParkingLotException;
    Vehicle[] getAll();
    int getSize();
}