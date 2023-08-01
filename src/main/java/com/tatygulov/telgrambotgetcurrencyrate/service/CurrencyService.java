package com.tatygulov.telgrambotgetcurrencyrate.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tatygulov.telgrambotgetcurrencyrate.model.CurrencyModel;
import org.json.JSONObject;
import org.springframework.expression.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CurrencyService {


    public static String getCurrencyRate(String message, CurrencyModel model) throws IOException, ParseException, java.text.ParseException {

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://www.floatrates.com/daily/kzt.json");
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()){
            result +=scanner.nextLine();
        }

        JSONObject jsonObject = new JSONObject(result);

        System.out.println(jsonObject);

        // Parsing U.S. Dollar (USD) data
        JSONObject currencyObject = jsonObject.getJSONObject(message.toLowerCase());
        CurrencyModel currencyModel = new CurrencyModel(
                currencyObject.getString("code"),
                currencyObject.getString("alphaCode"),
                currencyObject.getString("numericCode"),
                currencyObject.getString("name"),
                currencyObject.getDouble("rate"),
                currencyObject.getString("date"),
                currencyObject.getDouble("inverseRate")
        );


        return "Official rate of KZT to " + currencyModel.getName() + "\n" +
                "on the date: " + currencyModel.getDate() + "\n" +
                "is: " + currencyModel.getInverseRate() + " KZT per " + 1 + " " + currencyModel.getCode();

    }


}
