package io.github.swanky.note;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Java 8 Optional Notes.
 * <ol>
 * <li>Optional should only be used for return types</li>
 * <li>Don't call get() without checking the value is present</li>
 * </ol>
 * 
 * @see <a href=
 *      "https://blog.jetbrains.com/upsource/2016/08/03/what-to-look-for-in-java-8-code/">What
 *      to Look for in Java 8 Code</a>
 * @see <a href=
 *      "http://blog.joda.org/2015/08/java-se-8-optional-pragmatic-approach.html">Java
 *      SE 8 Optional, a pragmatic approach</a>
 * 
 * @author swanky
 */
public class Java8_Optional_Notes {

	/**
	 * 1. Look for the most elegant solution: if.
	 * 
	 * <ol>
	 * <li><code>isPresent()</code> + <code>get()</code></li>
	 * <li><code>isPresent()</code> + lambda</li>
	 * </ol>
	 */
	void note1() {
		Optional<String> _text = Optional.of("data");
		Set<String> textSet = new HashSet<>();

		// 1.1. isPresent() + get()
		if (_text.isPresent()) {
			textSet.add(_text.get());
		}

		// 1.2. ifPresent() + lambda
		_text.ifPresent(text -> textSet.add(text));
	}

	/**
	 * 2. Look for the most elegant solution: if else.
	 * 
	 * <ol>
	 * <li><code>isPresent()</code> + <code>get()</code> + else</li>
	 * <li><code>orElse()</code></li>
	 * <li><code>orElseGet()</code> + lambda</li>
	 * <li><code>orElseGet()</code> + methodRef</li>
	 * </ol>
	 */
	void note2() {
		Optional<String> _text = Optional.of("data");
		Set<String> textSet = new HashSet<>();

		// 2.1. isPresent() + get() + else
		if (_text.isPresent()) {
			textSet.add(_text.get());
		} else {
			textSet.add("no_data");
		}

		// 2.2. orElse()
		textSet.add(_text.orElse("no_data"));

		// 2.3. orElseGet() + lambda
		textSet.add(_text.orElseGet(() -> "no_data"));

		// 2.4. orElseGet() + methodRef
		textSet.add(_text.orElseGet(this::noData));
	}

	String noData() {
		return "no_data";
	}

}
