package repository;

import exception.ParkingLotException;
import model.Vehicle;

public class InMemoryRepository implements RepositoryInterface {
    private final Vehicle[] elements;
    private int size;

    public InMemoryRepository(int capacity) {
        this.elements = new Vehicle[capacity];
        this.size = 0;
    }

    @Override
    public void add(Vehicle vehicle) throws ParkingLotException {
        if (vehicle == null) {
            throw new ParkingLotException("Cannot add a null entity.");
        }
        if (this.size >= this.elements.length) {
            throw new ParkingLotException("Repository is full. Maximum capacity reached.");
        }
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].getId().equals(vehicle.getId())) {
                throw new ParkingLotException("An entity with ID '" + vehicle.getId() + "' already exists.");
            }
        }
        this.elements[this.size++] = vehicle;
    }

    @Override
    public void remove(String id) throws ParkingLotException {
        int targetIndex = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].getId().equals(id)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            throw new ParkingLotException("Entity with ID '" + id + "' not found.");
        }

        // Shift elements down to fill the gap
        for (int i = targetIndex; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[--this.size] = null;
    }

    @Override
    public Vehicle[] getAll() {
        Vehicle[] currentElements = new Vehicle[this.size];
        System.arraycopy(this.elements, 0, currentElements, 0, this.size);
        return currentElements;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}