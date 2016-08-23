package io.github.swanky.note;

import java.util.stream.IntStream;

/**
 * Java 8 Stream Notes.
 * 
 * <ol>
 * <li></li>
 * </ol>
 * 
 * @see <a href=
 *      "https://blog.jetbrains.com/upsource/2016/08/03/what-to-look-for-in-java-8-code/">What
 *      to Look for in Java 8 Code</a>
 * 
 * @author swanky
 */
public class Java8_Stream_Notes {

	public void note1() {
		IntStream.range(1, 5).forEach(System.out::println);
		IntStream.rangeClosed(1, 5).forEach(System.out::println);
	}

	public static void main(String[] args) {
		new Java8_Stream_Notes().note1();
	}

}
