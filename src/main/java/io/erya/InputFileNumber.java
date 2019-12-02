package io.erya;

/**
 * Class representing the number read in one line of the test.txt file.
 */
class InputFileNumber {

  private final Integer  number;
  private final Integer lastDigit;

  /**
   * Constructor
   * @param number number read
   */
  InputFileNumber(Integer number) {
    this.number = number;
    lastDigit = number % 10;
  }

  /**
   * Get last digit number
   * @return last digit number
   */
  Integer getLastDigit() {
    return lastDigit;
  }

  /**
   * Convert to string this object.
   * @return number to string.
   */
  @Override
  public String toString() {
    return number.toString();
  }
}
