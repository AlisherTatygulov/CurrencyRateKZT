package com.tatygulov.telgrambotgetcurrencyrate.model;

import lombok.Data;

@Data
public class CurrencyValue {
    private String code;
    private double value;

    // Add getters and setters (or use Lombok annotations) for the fields
}
