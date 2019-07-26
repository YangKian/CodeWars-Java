package seven_kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/***
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
 * Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known
 * for almost always capitalizing every word.
 *
 * Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from
 * Jaden Smith, but they are not capitalized in the same way he originally typed them.
 *
 * Example:
 *
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 * Note that the Java version expects a return value of null for an empty string or null.
 */
public class Jaden_Casing_String {
    //解法一：
    public String toJadenCase(String phrase) {
        if(phrase == null || phrase.equals("")) return null;

        String[] strs = phrase.split(" ");
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
            if(Character.isUpperCase(s.charAt(0))) {
                builder.append(s).append(" ");
                continue;
            }
            builder.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
        }
        String ans = new String(builder);
        return ans.trim();
    }

    //解法二：
    public String toJadenCaseFunc(String phrase) {
        if(phrase == null || phrase.equals("")) {
            return null;
        }

        return Arrays.stream(phrase.split(" "))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1, s.length()))
                .collect(Collectors.joining(" "));
    }
}

