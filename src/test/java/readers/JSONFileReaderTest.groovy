package readers

import org.json.simple.JSONObject
import spock.lang.Specification

class JSONFileReaderTest extends Specification {

    JSONFileReader jsonFileReader = new JSONFileReader();
    final String JSON_FILE_PATH = "src/main/resources/employees.json";

    def "Should read JSON file and return JSONArray"() {
        when: "The 'readJSONFile' is ran"
        def result = jsonFileReader.readJSONFile(JSON_FILE_PATH)
        then: "result should be list with five elements"
        result.size() == 5
    }

    def "Should read JSON file and return Lists with elements"() {
        when: "The 'readJSONFile' is ran"
        def list = jsonFileReader.readJSONFile(JSON_FILE_PATH)
        Iterator<JSONObject> iterator = list.iterator();
        def employee = iterator.next()
        def elementValue = employee.get(elementType).toString()
        then: "result should match the parameters"
        elementValue.equals(elementName)
        where:
        elementType || elementName
        "id"        || "1"
        "name"      || "Mark"
        "surname"   || "Green"
        "job"       || "Teacher"
        "salary"    || "3540,20"
    }

    def "Should create a Map with jobs and sum of salaries"() {
        when: "The 'createMap' is ran"
        def list = jsonFileReader.readJSONFile(JSON_FILE_PATH)
        def map = jsonFileReader.createMap(list)
        def result = map.get(job)
        then: "Result should be jobs with sum of salaries"
        result == (salary)
        where:
        job       || salary
        "Teacher" || 6240.30
        "Janitor" || 26920.90
        "Priest"  || 15240.00
    }
}
