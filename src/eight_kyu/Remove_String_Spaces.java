package eight_kyu;

/***
 * Simple, remove the spaces from the string, then return the resultant string.
 */
public class Remove_String_Spaces {

    //解法一
    static String noSpace(final String x) {
        return x.replace(" ","");
    }

    //解法二：
    static String noSpace2(final String x) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < x.length(); ++i) {
            if(x.charAt(i) == ' ') continue;
            res.append(x.charAt(i));
        }
        return new String(res);
    }
}
