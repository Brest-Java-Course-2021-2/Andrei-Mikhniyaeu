package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Status {
    List<String> msg = new ArrayList<>(Arrays.asList("Please input weight:" , "Please input distanse:"));
    List<BigDecimal> usrData = new ArrayList<>();

    Status handle();
    StatusType getType();
}
