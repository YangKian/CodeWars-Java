package seven_kyu;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in
 * descending order. Essentially, rearrange the digits to create the highest possible number.
 *
 * Examples:
 * Input: 21445 Output: 54421
 *
 * Input: 145263 Output: 654321
 *
 * Input: 1254859723 Output: 9875543221
 */

public class Descending_Order {
    public static int sortDesc(final int num) {
        int temp = num, ans = 0;
        ArrayList<Integer> container = new ArrayList<Integer>();
        while(temp != 0) {
            container.add(temp % 10);
            temp /= 10;
        }
        Collections.sort(container);
        for(int i = container.size() - 1; i >= 0; --i) {
            ans = ans * 10 + container.get(i);
        }
        return ans;
    }
}
