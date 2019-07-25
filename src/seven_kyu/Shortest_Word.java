package seven_kyu;

/***
 * Simple, given a string of words, return the length of the shortest word(s).
 *
 * String will never be empty and you do not need to account for different data types.
 */
public class Shortest_Word {
    public static int findShort(String s) {
        int min = Integer.MAX_VALUE;
        for(String w : s.split(" ")) {
            min = w.length() < min ? w.length() : min;
        }
        return min;
    }
}
