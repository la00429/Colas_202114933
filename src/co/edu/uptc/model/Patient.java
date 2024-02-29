package co.edu.uptc.model;

public class Patient {
    private String name;
    private char category;

    public Patient(String name, char category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public char getCategory() {
        return category;
    }
}