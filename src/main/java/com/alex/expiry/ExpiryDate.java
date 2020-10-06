package com.alex.expiry;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ExpiryDate {

    private AtomicInteger year;
    private AtomicInteger month;


    public AtomicInteger getYear() {
        return year;
    }

    public void setYear(AtomicInteger year) {
        this.year = year;
    }

    public AtomicInteger getMonth() {
        return month;
    }

    public void setMonth(AtomicInteger month) {
        this.month = month;
    }


    public ExpiryDate(AtomicInteger year, AtomicInteger month) {
        this.year = year;
        this.month = month;
    }
}
