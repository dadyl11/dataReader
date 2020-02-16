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

    def "Should read csv file and return Lists with first element 'id'"() {
        when: "The 'readCSV' is ran"
        def list = csvFileReader.readCSV(CSV_FILE_PATH)
        String result = list.get(0).get(index)
        then: "result should be List with first element 'id'"
        result.equals(elementName)
        where:
        index || elementName
        0     || "id"
        1     || "name"
        2     || "surname"
        3     || "job"
        4     || "salary"
    }

    def "CreateMap"() {
    }
}
