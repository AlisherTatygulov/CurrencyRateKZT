package com.tatygulov.telgrambotgetcurrencyrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class CurrencyModel {
    private Meta meta;
    private Map<String, CurrencyValue> data;





    // Add getters and setters (or use Lombok annotations) for the fields
}


