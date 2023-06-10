package com.example.optproject2final;

public class BoschFactory implements RentalFactory {

    public Drill createProduct() {
        return new BoschDrill();
    }
    public Drill createProduct(String brand, String model, String description) {
        return new BoschDrill(brand, model, description);
    }
}
