package io.erya;

/**
 * @author Erwan PELMOINE
 * Main class of technical test.
 * Statement : Order the numbers of input file by ASC last digit and re-print it in a new file.
 */
public class App {

    private static final String INPUT_FILE_PATH = "./src/main/resources/test.txt";
    private static final String OUTPUT_FILE_PATH = "result.txt";

    public static void main(String[] args) {
        InputFile inputFile = new InputFile(INPUT_FILE_PATH);
        OutputFile outputFile = new OutputFile(inputFile.getNumbers(), OUTPUT_FILE_PATH);
        outputFile.write();
    }

}
