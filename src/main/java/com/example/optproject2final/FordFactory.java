package com.example.optproject2final;

public class FordFactory implements RentalFactory {

    public Car createCar() {return null;}
    public Car createCar(String brand, String model, String description) {return null;}
    public Truck createTruck() {
        return new FordTruck();
    }
    public Truck createTruck(String brand, String model, String description) {
        return new FordTruck(brand, model, description);
    }
    public Drill createDrill() {
        return null;
    }
    public Drill createDrill(String brand, String model, String description) {
        return null;
    }
}
