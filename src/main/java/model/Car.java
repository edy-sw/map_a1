package model;

public class Car implements Vehicle {
    private final String id;
    private final String color;

    public Car(String id, String color) {
        this.id = id;
        this.color = color;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean isRed() {
        return "red".equalsIgnoreCase(this.color);
    }

    @Override
    public String toString() {
        return "Car [ID: " + id + ", Color: " + color + "]";
    }
}