package com.epam.brest.files;

import java.math.BigDecimal;
import java.util.Map;

public interface Reader {
    Map<Integer, BigDecimal> readData (final String filePath) throws Exception;
}
