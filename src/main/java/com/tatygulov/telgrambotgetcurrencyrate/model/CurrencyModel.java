package com.tatygulov.telgrambotgetcurrencyrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyModel {
    private String code;
    private String alphaCode;
    private String numericCode;
    private String name;
    private double rate;
    private String date;
    private double inverseRate;







    // Add getters and setters (or use Lombok annotations) for the fields
}


