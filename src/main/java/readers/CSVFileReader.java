package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVFileReader {

  public List<List<String>> readCSV(String path) {
    List<List<String>> records = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(";");
        records.add(Arrays.asList(values));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return records;
  }

  public Map<String, BigDecimal> createMap(List<List<String>> records) {
    Map<String, BigDecimal> finalMap = new HashMap<>();
    records.remove(0);
    for (List<String> list : records) {
      String job = list.get(3).trim().replace("\"", "");
      BigDecimal salary = new BigDecimal(list.get(4).replace("\"", "").replace(",", ".").trim());
      if (finalMap.containsKey(job)) {
        salary = finalMap.get(job).add(salary);
      }
      finalMap.put(job, salary);
    }
    return finalMap;
  }
}
