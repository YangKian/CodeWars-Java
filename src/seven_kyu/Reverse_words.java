package seven_kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/***
 * Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the
 * string should be retained.
 *
 * Examples
 * "This is an example!" ==> "sihT si na !elpmaxe"
 * "double  spaces"      ==> "elbuod  secaps"
 */
public class Reverse_words {
    public static String reverseWords(final String original)
    {
        String[] array = original.split(" ");

        if(array.length == 0)
            return original;

        return Arrays.stream(array)
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
        // Have at it
    }
}
