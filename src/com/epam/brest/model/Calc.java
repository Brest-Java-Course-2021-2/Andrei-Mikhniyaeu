package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calc implements Status {
    Scanner scanner;

    public Calc(Scanner scanner){
        this.scanner = scanner;
    }


    @Override
    public Status handle() {
        try{
            System.out.println("Result:" + usrData.get(0).multiply(BigDecimal.valueOf(1)).add(usrData.get(1).multiply(BigDecimal.valueOf(1))));
        } finally {
            usrData.clear();
        } return new ReadData(scanner);
    }

    @Override
    public StatusType getType() {
        return null;
    }
}
