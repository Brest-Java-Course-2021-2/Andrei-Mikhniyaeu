package com.epam.brest.model;

import com.epam.brest.Main;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.READ_DATA;

public class ReadData implements Status{
   public static final int NUMBER_OF_USER_DATA = 2;
   final Scanner scanner;
    public static final String JSON_PATH = "src/com/epam/brest/resources/CalcKg.json";

    BigDecimal weight, distance, priceKm, priceKg, deliveryCost;

    public ReadData(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Status handle() {

        if (usrData.size() < NUMBER_OF_USER_DATA){
            System.out.println(msg.get(usrData.size()));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase("q")) {
                return new Exit();
            }else if (isCorrectValue(inputValue)){
                usrData.add(new BigDecimal(inputValue));
                BigDecimal price = new BigDecimal(inputValue);
                priceKg = priceFromFile(price, JSON_PATH).multiply(price) ;
              }
            else {return  new Calc(scanner);
            }
        }
        return this;
    }
    private boolean isCorrectValue(String inputValue){
        try{
            BigDecimal enteredValue = new BigDecimal(inputValue);
            return enteredValue.doubleValue()>0;
        }catch (NumberFormatException nfe){
            System.out.println("Incorrect value:"+ inputValue);
        }
        return false;
    }

    @Override
    public StatusType getType() {
        return READ_DATA;
    }

    public static BigDecimal priceFromFile(BigDecimal usrData, String fileName){

        Map<BigDecimal, BigDecimal> price = new HashMap<>();
        try {
            File file = new File(fileName);
            Type type = new TypeToken<Map<BigDecimal, BigDecimal>>(){}.getType();
            price = new Gson().fromJson(new FileReader(file), type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        BigDecimal result = new BigDecimal(1);
        for (BigDecimal fileCoefficient: price.keySet()){
            if(usrData.compareTo(fileCoefficient) >= 0) {
                result = price.get(fileCoefficient);
            }
        }
        return result;
    }



}
