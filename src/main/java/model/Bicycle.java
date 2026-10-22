package model;

public class Bicycle implements Vehicle {
    private final String id;
    private final String color;

    public Bicycle(String id, String color) {
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
        return "Bicycle [ID: " + id + ", Color: " + color + "]";
    }
}