package io.github.swanky.note;

import java.util.Date;

/**
 * Ref: https://dzone.com/articles/java-string-format-examples
 */
public class StringFormatNote {
  
  public static void main(String[] args) {
    Date now = new Date();
    System.out.println(String.format("%tF %tT", now, now));
  }
  
}
