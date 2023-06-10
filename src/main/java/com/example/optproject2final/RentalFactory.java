package com.example.optproject2final;

public interface RentalFactory {

    public abstract Rentable createProduct();
    public abstract Rentable createProduct (String brand, String model, String description);

}
