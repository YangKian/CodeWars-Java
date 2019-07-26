package six_kyu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 未完成版本
 */
public class Consecutive_strings {
    public static String longestConsec(String[] strarr, int k) {
        // your code
        final int n = strarr.length;
        if (n == 0 || k > n || k < 0) {
            return null;
        }

        List<String> res = Arrays.stream(strarr)
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .distinct()
//                .sorted((s1, s2) -> {
//                    return s2.length() - s1.length();
//                })
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(k)
                .collect(Collectors.toList());
        System.out.println(res.toString());
        return null;

    }


    public static void main(String[] args) {
        String[] a = {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"};
        Consecutive_strings.longestConsec(a, 2);
    }
}
