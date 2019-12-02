package io.erya;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class InputFileTest {


  @Test
  public void Given_NoDataInInputFile_When_ConstructorInputFile_Then_InputFileNumbersIsEmpty() {
    // GIVEN
    String emptyInputFilePath = "./src/test/resources/empty.txt";

    //WHEN
    InputFile inputFile = new InputFile(emptyInputFilePath);

    // THEN
    assertThat(inputFile.getNumbers()).isEmpty();
  }

  @Test
  public void Given_NegativeNumber_When_ConstructorInputFile_Then_InputFileNumbersIsCorrect() {
    // GIVEN
    String emptyInputFilePath = "./src/test/resources/negative.txt";
    //WHEN
    InputFile inputFile = new InputFile(emptyInputFilePath);

    // THEN
    assertThat(inputFile.getNumbers()).hasSize(4);
  }

  @Test
  public void Given_SpaceInFile_When_ConstructorInputFile_Then_InputFileNumbersIsCorrect() {
    // GIVEN
    String emptyInputFilePath = "./src/test/resources/space.txt";

    //WHEN
    InputFile inputFile = new InputFile(emptyInputFilePath);

    // THEN
    assertThat(inputFile.getNumbers()).hasSize(3);
  }

}
