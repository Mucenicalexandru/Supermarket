package com.alex.expiry;

import java.util.concurrent.atomic.AtomicInteger;

public class LongExpiry extends ExpiryDate {

    private AtomicInteger day;

    public LongExpiry(AtomicInteger year, AtomicInteger month, AtomicInteger day) {
        super(year, month);
        this.day = day;
    }

    public AtomicInteger getDay() {
        return day;
    }

    public void setDay(AtomicInteger day) {
        this.day = day;
    }

}
