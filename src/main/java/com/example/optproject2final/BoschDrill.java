package com.example.optproject2final;

public class BoschDrill implements Drill, Rentable {
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

    public void setRented(boolean isRented) {
        this.isRented = isRented;
        if (isRented) {
            status = "Rented";
        } else {
            status = "Available";
        }
    }

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
    public String getType() {return type;}

    public BoschDrill() {
        this("Bosch","Impact Drill", "Bosch Drill");
    }
    public BoschDrill(String brand, String model, String description) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.isRented = false;
    }
    public void assemble() {
        System.out.println("Assembling Bosch Drill");
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void rent() {
        System.out.println("Renting Bosch Drill");
        this.isRented = true;
        this.status = "Rented";
    }
    public void returnItem() {
        System.out.println("Returning Bosch Drill");
        this.isRented = false;
        this.status = "Available";
    }
}
