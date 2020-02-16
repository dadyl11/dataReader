package utils;

import java.math.BigDecimal;
import java.util.Map;

public class PrintMap {

  public void printMap(Map<String, BigDecimal> map) {
    map.forEach((key, value) -> System.out.println(key.replace("\"", "") + " - " + value));
  }
}
