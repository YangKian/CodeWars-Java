package six_kyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the
 * position the word should have in the result.
 *
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 *
 * If the input string is empty, return an empty string. The words in the input String will only contain valid
 * consecutive numbers.
 *
 * Examples
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */
public class Your_Order_please {
    public static String order(String words) {
        String res = "";
        if(words.isEmpty()) return res;

        HashMap<Integer, String> order = new HashMap<Integer, String>();
        List<Integer> keys = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*(\\d).*");
        for(String s : words.split(" ")) {
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) {
                order.put(Integer.parseInt(matcher.group(1)), s);
                keys.add(Integer.parseInt(matcher.group(1)));
            }
        }
        Collections.sort(keys);

        StringBuilder result = new StringBuilder();
        for(Integer key : keys) {
            result.append(order.get(key)).append(" ");
        }
        res = new String(result).trim();
        return res;
    }
}
