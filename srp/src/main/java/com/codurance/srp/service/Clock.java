package com.codurance.srp.service;

import java.time.LocalDate;

public class Clock {

    public LocalDate today() {
        return LocalDate.now();
    }
}