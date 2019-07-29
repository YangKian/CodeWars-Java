package six_kyu;

/**
 * Description:
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if
 * that character appears only once in the original string, or ")" if that character appears more than once in the
 * original string. Ignore capitalization when determining if a character is a duplicate.
 *
 * Examples
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 * Notes
 *
 * Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX",
 * the "XXX" is the expected result, not the input!
 */

import java.util.stream.Collectors;

public class Duplicate_Encoder {
    static String encode(String word){
        word = word.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            builder.append(word.lastIndexOf(w) == word.indexOf(w) ? "(" : ")");
        }
        return builder.toString();
    }

    //解法二
    static String encode1(String word){
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char)i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());
    }
}
