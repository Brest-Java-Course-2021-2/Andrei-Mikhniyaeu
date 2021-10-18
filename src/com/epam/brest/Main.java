package com.epam.brest;
// The program for calculating the cost of delivery.
//
// Input variables:
//  weight - weight of the delivered cargo
//  distance - the size of the delivered cargo
//  priceKm - price per kilometer of delivery
//  priceKg - price per kilogram of delivery
//
//

import com.epam.brest.files.JsonParse;
import com.epam.brest.model.ReadData;
import com.epam.brest.model.Status;
import com.epam.brest.model.StatusType;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            Status currentStatus = new ReadData(scanner);
            while (currentStatus.getType() != StatusType.EXIT) {
                System.out.println("Current type:" + currentStatus.getType());
                currentStatus = currentStatus.handle();

            }
        }
    }
}
