package com.alex.supermarket;

import com.alex.expiry.ExpiryDate;

public abstract class DairyProduct extends Product {

    private final int CURRENT_YEAR = 2020;
    private final int CURRENT_MONTH = 10;
    private ExpiryDate expiryDate;

    public DairyProduct(String brandName, int quantity, ExpiryDate expiryDate) {
        super(brandName, quantity);
        this.expiryDate = expiryDate;
    }

    public ExpiryDate getExpiryDate(){
        return expiryDate;
    }

    public boolean isMilkSoured(){
        if(expiryDate.getYear().get() < CURRENT_YEAR){
            return true;
        }else if( expiryDate.getYear().get() == CURRENT_YEAR && expiryDate.getYear().get() < CURRENT_MONTH){
            return true;
        }else{
            return false;
        }
    }

}
