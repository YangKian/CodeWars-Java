package six_kyu;

/***
 * Task
 *  	In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be
 *  	passed a string and you must return that string in an array where an uppercase letter is a person standing up.
 *
 * Rules
 *  	1.  The input string will always be lower case but maybe empty.
 *
 * 2.  If the character in the string is whitespace then pass over it as if it was an empty seat.
 * Example
 * wave("hello") => ["Hello", "hEllo", "heLlo", "helLo", "hellO"]
 * Good luck and enjoy!
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Mexican_Wave {
    public static String[] wave(String str) {

        String[] ans = new String[str.length()];
        if(str.length() == 0) return ans;

        for (int i = 0; i < str.length(); ++i) {
            StringBuilder builder = new StringBuilder();
            if(Character.isSpaceChar(str.charAt(i))) { //注意原字符串中可能有空格，要跳过空格，否则最后生成的结果数量不对
                continue;
            }
            builder.append(str, 0, i).append(Character.toUpperCase(str.charAt(i)))
                    .append(str.substring(i + 1));
            ans[i] = builder.toString();
        }

        return Arrays.stream(ans)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
    }

    //解法二：
    public static String[] wave1(String str) {
        // Your code here
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < str.length(); ++i) {
            char[] convert = str.toCharArray();
            if(convert[i] == ' ') continue;
            convert[i] = Character.toUpperCase(convert[i]);
            ans.add(String.valueOf(convert));
        }
        return ans.toArray(new String[ans.size()]);
    }

    //解法三
    public static String[] wave2(String str) {
        return IntStream
                .range(0, str.length())
                .mapToObj(x -> new StringBuilder(str).replace(x, x+1, String.valueOf(str.charAt(x)).toUpperCase()).toString())
                .filter(x -> !x.equals(str))
                .toArray(String[]::new);
    }
}

