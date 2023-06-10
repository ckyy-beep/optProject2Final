package com.example.optproject2final;

public interface Rentable {
    String getType();
    String getBrand();
    String getModel();
    String getDescription();
    boolean getIsRented();
    void rent();
    void returnItem();
}
