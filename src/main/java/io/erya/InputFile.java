package io.erya;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;

/**
 * InputFile representing the test input file.
 * You can use to get the list of number contained by the input file.
 */
class InputFile {


  private static final Logger LOGGER = Logger.getLogger(InputFile.class);
  private List<InputFileNumber> numbers;
  private final String pattern = "-?[1-9]\\d*|0";

  /**
   * Constructor
   * @param path the file path
   */
  InputFile(final String path) {
    Stream<String> inputFileLines = read(path);
    createNumbers(inputFileLines);
  }

  /**
   * Read the file and return a Stream represented all lines inside.
   * @param path the path file
   * @return a Stream of String if no IOException during reading,  empty Stream otherwise.
   */
  private Stream<String> read(String path)  {
    try {
      return Files.lines(Paths.get(path));
    } catch (IOException e){
      LOGGER.error(String.format("Error during reading lines of file {%s}.", path),e);
      return Stream.empty();
    }
  }

  /**
   * Create the number list contained by the input file.
   * @param streamLineFile the stream got by the reading
   */
  private void createNumbers(Stream<String> streamLineFile) {

    if(streamLineFile == null) {
      LOGGER.error("Error during converting stream lines to list, the stream is null.");
    }else {
      numbers =  streamLineFile
          .filter(x -> x.matches(pattern))
          .map(x -> new InputFileNumber(Integer.valueOf(x)))
          .collect(Collectors.toList());
    }
  }

  /**
   * Get the list of number contained by the input file.
   * @return inputFileNumbers
   */
  public List<InputFileNumber> getNumbers() {
    return numbers;
  }
}
