package com.tatygulov.telgrambotgetcurrencyrate.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tatygulov.telgrambotgetcurrencyrate.model.CurrencyModel;
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
        URL url = new URL("https://api.currencyapi.com/v3/latest?apikey=cur_live_WxpHJRs4iDwGjOx5QzFnCM9qXVXDG27D6RKPhlOS&currencies=KZT&base_currency=" + message.toUpperCase());
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()){
            result +=scanner.nextLine();
        }

         model = objectMapper.readValue(result, CurrencyModel.class);

        String lastUpdatedAt = model.getMeta().getLast_updated_at();
        String currencyCode = model.getData().get("KZT").getCode();
        double currencyValue = model.getData().get("KZT").getValue();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = sdf.parse(lastUpdatedAt);


        return "Official rate of KZT to " + message.toUpperCase() + "\n" +
                "on the date: " + date + "\n" +
                "is: " + currencyValue + " KZT per " + 1 + " " + message.toUpperCase();

    }


}
