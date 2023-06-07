package com.example.optproject2final;

public interface RentalFactory {

    public abstract Car createCar();
    public abstract Car createCar(String brand, String model, String description);
    public abstract Truck createTruck();
    public abstract Truck createTruck(String brand, String model, String description);
    public abstract Drill createDrill();
    public abstract Drill createDrill(String brand, String model,String description);
}
