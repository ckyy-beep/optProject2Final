package com.example.optproject2final;

public class ToyotaCar implements Car , Rentable {
    private String brand;
    private String model;
    private String description;
    private boolean isRented = false;
    private String status = "Available";

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
        if (isRented) {
            status = "Rented";
        } else {
            status = "Available";
        }
    }
    public String getType() {return type;}
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getDescription() {
        return description;
    }
    public boolean getIsRented() {return isRented;}

    public ToyotaCar() {
        this("Toyota", "Camry", "Toyota Camry");
    }

    public ToyotaCar(String brand, String model, String description) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.isRented = false;
        this.status = "Available";
    }

    public void assemble() {
        System.out.println("Assembling Toyota Car");
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void rent() {
        System.out.println("Renting Toyota Car");
        isRented = true;
        status = "Rented";
    }
    public void returnItem() {
        System.out.println("Returning Toyota Car");
        isRented = false;
        status = "Available";
    }
}


