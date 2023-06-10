package com.example.optproject2final;

public class FordFactory implements RentalFactory {

    public Truck createProduct() {
        return new FordTruck();
    }
    public Truck createProduct(String brand, String model, String description) {
        return new FordTruck(brand, model, description);
    }

}
