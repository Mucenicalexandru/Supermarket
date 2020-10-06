package com.alex.supermarket;

public class Truck extends Product {

    private int numberOfWheels;

    public Truck(String brandName, int quantity, int numberOfWheels) {
        super(brandName, quantity);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels(){
        return numberOfWheels;
    }
}
