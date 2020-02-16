package readers;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileReader {

  public JSONArray readJSONFile(String path) {
    JSONParser parser = new JSONParser();
    JSONArray employees = new JSONArray();
    try {
      Object obj = parser.parse(new FileReader(path));
      JSONObject jsonObject = (JSONObject) obj;
      employees = (JSONArray) jsonObject.get("employees");

    } catch (Exception e) {
      e.printStackTrace();
    }
    return employees;
  }

  public Map<String, BigDecimal> createMap(JSONArray employees) {
    Map<String, BigDecimal> finalMap = new HashMap<>();
    Iterator<JSONObject> iterator = employees.iterator();

    while (iterator.hasNext()) {
      JSONObject object = iterator.next();
      BigDecimal salary = new BigDecimal(object.get("salary").toString().replace(",", "."));
      String job = object.get("job").toString();
      if (finalMap.containsKey(job)) {
        salary = finalMap.get(job).add(salary);
      }
      finalMap.put(job, salary);
    }
    return finalMap;
  }
}
