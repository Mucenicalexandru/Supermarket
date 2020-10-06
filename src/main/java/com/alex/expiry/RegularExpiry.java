package com.alex.expiry;

import java.util.concurrent.atomic.AtomicInteger;

public class RegularExpiry extends ExpiryDate {

    public RegularExpiry(AtomicInteger year, AtomicInteger month) {
        super(year, month);
    }
}
