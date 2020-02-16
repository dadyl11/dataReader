import java.io.Console;
import java.math.BigDecimal;
import java.util.Map;
import readers.CSVFileReader;
import readers.JSONFileReader;
import utils.PrintMap;

public class Demo {

  public static void main(String[] args) {
    final String CSV_FILE_PATH = "src/main/resources/employees.csv";
    final String JSON_FILE_PATH = "src/main/resources/employees.json";

    PrintMap printMap = new PrintMap();

    System.out.println("Reading CSV file:");
    CSVFileReader csvFileReader = new CSVFileReader();
    Map<String, BigDecimal> csvMap = csvFileReader.createMap(csvFileReader.readCSV(CSV_FILE_PATH));
    printMap.printMap(csvMap);

    System.out.println("Reading JSON file:");
    JSONFileReader jsonFileReader = new JSONFileReader();
    Map<String, BigDecimal> jsonMap = jsonFileReader.createMap(jsonFileReader.readJSONFile(JSON_FILE_PATH));
    printMap.printMap(jsonMap);
  }
}
