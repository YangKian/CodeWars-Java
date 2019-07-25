package seven_kyu;

import java.util.HashMap;

/**
 * Description:
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive.
 * The string can contain any char.
 *
 * Examples input/output:
 *
 * XO("ooxx") => true
 * XO("xooxx") => false
 * XO("ooxXm") => true
 * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
 * XO("zzoo") => false
 */

public class Exes_and_Ohs {
    public static boolean getXO (String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char temp;
        for(int i = 0; i < str.length(); ++i) {
            temp = str.toLowerCase().charAt(i);
            if(temp == 'o' || temp == 'x' ) {
                int count = map.get(temp) == null ? 0 :map.get(temp) + 1;
                map.put(temp, count);
            }
        }
        if(map.isEmpty()) {
            return true;
        }
        if(map.size() != 2) {
            return false;
        }

        return map.get('x').equals(map.get('o'));

    }
}
