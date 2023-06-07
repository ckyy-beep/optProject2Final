package com.example.optproject2final;

public class ToyotaFactory implements RentalFactory {

    public Car createCar() {
        return new ToyotaCar();
    }
    public Car createCar(String brand, String model, String description) {
        return new ToyotaCar(brand, model, description);
    }
    public Truck createTruck() {
        return null;
    }
    public Truck createTruck(String brand, String model, String description) {
        return null;
    }
    public Drill createDrill() {
        return null;
    }
    public Drill createDrill(String brand, String model, String description) {
        return null;
    }
}
