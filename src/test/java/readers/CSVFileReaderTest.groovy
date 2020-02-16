package readers

import spock.lang.Specification

class CSVFileReaderTest extends Specification {

    final String CSV_FILE_PATH = "src/test/resources/employees.csv";
    CSVFileReader csvFileReader = new CSVFileReader()

    def "Should read csv file and return List of List<String>"() {
        when: "The 'readCSV' is ran"
        def result = csvFileReader.readCSV(CSV_FILE_PATH)
        then: "result should be List of six Lists"
        result.size() == 6
    }

    def "Should read csv file and return Lists with elements from file"() {
        when: "The 'readCSV' is ran"
        def list = csvFileReader.readCSV(CSV_FILE_PATH)
        def result = list.get(0).get(index)
        then: "result should match the first row of CSV file"
        result.equals(elementName)
        where:
        index || elementName
        0     || "id"
        1     || "name"
        2     || "surname"
        3     || "job"
        4     || "salary"
    }

    def "Should create a Map with jobs and sum of salaries"() {
        when: "The 'createMAp' is ran"
        def list = csvFileReader.readCSV(CSV_FILE_PATH)
        def map = csvFileReader.createMap(list)
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
