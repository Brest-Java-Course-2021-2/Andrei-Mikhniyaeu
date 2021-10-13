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

import com.epam.brest.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigDecimal weight, distance, priceKm, priceKg, deliveryCost;

        boolean loop = true;
       System.out.println("Программа рассчёта стоимости достаки");
        try (Scanner scanner = new Scanner(System.in)) {
            while (loop) {

                weight = getValueFromConsole(scanner, "Введите вес кг:");
                distance = getValueFromConsole(scanner, "Введите расстояние км");
                priceKm = getValueFromConsole(scanner, "Введите Цену за километр");
                priceKg = getValueFromConsole(scanner, "Введите Цену за килограмм");

                if (weight != null && weight.compareTo(BigDecimal.ZERO) > 0
                        && priceKg != null && priceKg.compareTo(BigDecimal.ZERO) > 0
                        && distance != null && distance.compareTo(BigDecimal.ZERO) > 0
                        && priceKm != null && priceKm.compareTo(BigDecimal.ZERO) >0) {

                    CalcImpl calculator = new CalcImpl(weight, distance, priceKm, priceKg);
                    deliveryCost = calculator.calculator(weight, distance, priceKm, priceKg);
                    System.out.println("Delivery cost: " + deliveryCost);
                    System.out.println("Для завершения программы нажмите 'q' для продолжения введите 'c'");
                }
                else{
                    System.out.println("Были введены отрицательные или нулевые значения.");
                    System.out.println("Пожалуйста нажмите 'c' и введите корректные значения");}
                    String userIn = scanner.next();
                    switch (userIn) {
                        case ("c"):
                            System.out.format("Вы ввели c, продолжаем.");
                           break;
                        case ("q"):
                            System.out.format("Вы ввели q, программа завершается.");
                            scanner.close();
                            System.exit(0);
                        default:
                            break;

                    }
                }
         }
        catch (Exception e) {
            System.out.format("Ошибочный ввод, свяжитесь с медеджером доставки. Программа завершена.");

        }
    }

    private static BigDecimal getValueFromConsole(Scanner scanner, String s) {
        BigDecimal data;
        System.out.println(s);
        data = scanner.nextBigDecimal();
        return data;
    }
}
