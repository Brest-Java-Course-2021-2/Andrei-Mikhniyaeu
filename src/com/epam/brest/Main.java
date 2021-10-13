package com.epam.brest;
// The program for calculating the cost of delivery.
//
// Input variables:
//  weight - weight of the delivered cargo
//  distance - the size of the delivered cargo
//  priceKm - price per kilometer of delivery
//  priceKg - price per kilogram of delivery
//
//  TODO: In next version make user choice menu as function.

import com.epam.brest.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigDecimal weight;
        BigDecimal distance;
        BigDecimal priceKm;
        BigDecimal priceKg;
        BigDecimal deliveryCost;

        boolean loop = true;
       System.out.println("Программа рассчёта стоимости достаки");
        try (Scanner scanner = new Scanner(System.in)) {
            while (loop) {
                System.out.println("Введите вес кг:");
                weight = scanner.nextBigDecimal();
                System.out.println("Введите расстояние км");
                distance = scanner.nextBigDecimal();
                System.out.println("Введите Цену за километр" );
                priceKm = scanner.nextBigDecimal();
                System.out.println("Введите Цену за килограмм");
                priceKg = scanner.nextBigDecimal();

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
}
