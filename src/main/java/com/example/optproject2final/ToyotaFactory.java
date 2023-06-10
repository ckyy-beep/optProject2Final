package com.example.optproject2final;

public class ToyotaFactory implements RentalFactory {

    public Car createProduct() {
        return new ToyotaCar();
    }
    public Car createProduct(String brand, String model, String description) {
        return new ToyotaCar(brand, model, description);
    }
}
