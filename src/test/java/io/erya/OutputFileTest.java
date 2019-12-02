package io.erya;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class OutputFileTest {


  @Test
  public void Given_emptyInputFileNumbers_When_ConstructorInputFile_Then_InputFileNumbersIsEmpty() {
    // GIVEN
    List<InputFileNumber> inputFileNumbers = Collections.emptyList();

    //WHEN
    OutputFile outputFile = new OutputFile(inputFileNumbers, "");

    // THEN
    assertThat(outputFile.numbersByLastDigitMap).isEmpty();
  }

  @Test
  public void Given_nullInputFileNumbers_When_ConstructorInputFile_Then_InputFileNumbersIsEmpty() {
    //WHEN
    OutputFile outputFile = new OutputFile(null, "");

    // THEN
    assertThat(outputFile.numbersByLastDigitMap).isEmpty();
  }

  @Test
  public void Given_emptyOutputFileNumberByLastDigit_When_Write_Then_FileIsEmpty() throws IOException {
    // GIVEN
    String path = "./src/test/resources/result_empty.txt";
    OutputFile outputFile = new OutputFile(null,path );

    //WHEN
    outputFile.write();

    // THEN
    try(Stream<String> streamLine = Files.lines(Paths.get(path))) {
      assertThat(streamLine.count()).isEqualTo(0);
    }
  }
}
