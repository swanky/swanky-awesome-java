package io.github.swanky.note;

import java.util.function.BiFunction;

/**
 * Java8_Function_Notes.
 * 
 * <ol>
 * <li></li>
 * </ol>
 * 
 * @see <a href=
 *      "https://speakerdeck.com/rgra/vjug24-functional-libraries-for-java-8">Functional
 *      Libraries for Java 8</a>
 * 
 * @author swanky
 */
public class Java8_Function_Notes {
  
  public void note1() {
    BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
    BiFunction<Integer, Integer, Integer> addAndMultBy5 = add.andThen(x -> x * 5);
    System.out.println(addAndMultBy5.apply(2, 5));
  }
  
  public static void main(String[] args) {
    new Java8_Function_Notes().note1();
  }
  
}
