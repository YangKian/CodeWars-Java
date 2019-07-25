package seven_kyu;

public class Jaden_Casing_String {
    public String toJadenCase(String phrase) {
        if(phrase == null || phrase.equals("")) return null;

        String[] strs = phrase.split(" ");
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
            if(Character.isUpperCase(s.charAt(0))) {
                builder.append(s).append(" ");
                continue;
            }
            builder.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
        }
        String ans = new String(builder);
        return ans.trim();
    }
}

