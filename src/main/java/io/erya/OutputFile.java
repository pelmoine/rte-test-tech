package io.erya;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

/**
 * Class representing the output file "result.txt".
 * Which contains all number of input file "test.txt" order and group by last digit
 */
class OutputFile {

  private static final Logger LOGGER = Logger.getLogger(OutputFile.class);
  private final String outputFilePath;
  Map<Integer, List<InputFileNumber>> numbersByLastDigitMap = new HashMap<>();

  /**
   * Constructor
   * @param numbers number list read in input file
   * @param outputFilePath the output file path
   */
  OutputFile(List<InputFileNumber> numbers, String outputFilePath) {
    this.outputFilePath = outputFilePath;
    createNumbersByLastDigitMap(numbers);
  }

  /**
   * Create a map representing numbers by last digit
   * @param numberList the number list
   */
  private void createNumbersByLastDigitMap(
      List<InputFileNumber> numberList) {
    if (numberList  == null || numberList.isEmpty() ) {
      LOGGER.error("Error during creating the output file number list, the number list is null or "
          + "empty");
      return;
    }
    numbersByLastDigitMap =
        numberList.stream().collect(Collectors.groupingBy(InputFileNumber::getLastDigit));
  }

  /**
   * Write the output file "result.txt"
   */
  void write() {
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {
      for (Map.Entry<Integer, List<InputFileNumber>> entry : numbersByLastDigitMap.entrySet()) {
        for (InputFileNumber inputFileNumber : entry.getValue()) {
          writer.write(inputFileNumber.toString() + " ");
        }
        writer.write("\n");
      }
    } catch (IOException e) {
      LOGGER.error(
          String.format("Error during opening or creating the file %s.", outputFilePath));
    }
  }
}
