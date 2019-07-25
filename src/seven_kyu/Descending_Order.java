package seven_kyu;

import java.util.ArrayList;
import java.util.Collections;

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
