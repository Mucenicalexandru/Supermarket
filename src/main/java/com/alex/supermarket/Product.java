package com.alex.supermarket;

import java.util.UUID;

public abstract class Product {
    private final String brandName;
    private final int quantity;
    private final UUID id;

    public Product(String brandName, int quantity){
        this.brandName = brandName;
        this.quantity = quantity;
        id = UUID.randomUUID();
    }

    public String getBrandName(){
        return brandName;
    }

    public int getQuantity(){
        return quantity;
    }

    public UUID getUuid(){
        return id;
    }

}
