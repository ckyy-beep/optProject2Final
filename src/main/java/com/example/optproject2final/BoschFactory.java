package com.example.optproject2final;

public class BoschFactory implements RentalFactory {

    public Car createCar() {
        return null;
    }
    public Car createCar(String brand, String model, String description) {
        return null;
    }
    public Truck createTruck() {
        return null;
    }
    public Truck createTruck(String brand, String model, String description) {
        return null;
    }
    public Drill createDrill() {
        return new BoschDrill();
    }
    public Drill createDrill(String brand, String model, String description) {
        return new BoschDrill(brand, model, description);
    }
}
