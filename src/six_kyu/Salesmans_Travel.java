package six_kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Salesmans_Travel {

    public static String travel(String r, String zipcode) {

        if(zipcode.equals("")) return ":/"; //注意边界条件的判断

        StringBuilder builder = new StringBuilder();
        List<String> code = new ArrayList<>();

        String[] road = r.split(",");
        builder.append(zipcode).append(":"); // 返回字符串头部zipcode:
        for(String s : road) {
            if(s.endsWith(zipcode)) {
                //注意不能用contains（zipcode）, e.g.：OH 430 和 OH 43071 都满足条件
                String[] temp = s.split(" ");
                for(int i = 1; i < temp.length - 3; ++i) { //注意i的取值范围
                    builder.append(temp[i]).append(" ");
                }
                builder.append(temp[temp.length - 3]).append(";");
                code.add(temp[0]);
            }
        }
        if(!code.isEmpty()) {
            builder.setCharAt(builder.length() - 1, '/');
            builder.append(String.join(",", code));
        } else {
            builder.setCharAt(builder.length() - 1, ':');
            builder.append("/");
        }
        return builder.toString();
    }

    //解法二
    public static String travel1(String r, String zipcode) {
        StringBuilder res = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\d+) ([a-zA-Z\\. ]+) " + zipcode + ",");
        Matcher matcher = pattern.matcher(r);
        while (matcher.find()) {
            res.append(",").append(matcher.group(2));
            sub.append(matcher.group(1)).append(",");
        }
        return zipcode + ":" + res.toString().replaceAll("^,", "") + "/" +
                sub.toString().replaceAll(",$", "");
    }

    //解法三：
    public static String travel2(String r, String zipcode) {
        if(zipcode.isEmpty()) return ":/";
        List<String> num = new ArrayList<>();
        String res = Stream.of(r.split(","))
                .filter(s -> s.endsWith(zipcode))
                .map(s -> {
                    String[] temp = s.split(" ");
                    num.add(temp[0]);
                    return String.join(" ", Arrays.copyOfRange(temp, 1, temp.length - 2));
                }).collect(Collectors.joining(","));
        return zipcode + ":" + res + "/" + String.join(",", num);

    }


    public static void main(String[] args) {
        String r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
                + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
                + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
                + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
                + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
                + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
                + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
                + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
                + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
                + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000";
        String res = Salesmans_Travel.travel(r, "");
        System.out.println(res);
        String res1 = Salesmans_Travel.travel(r, "OH 43071");
        System.out.println(res1);
        String res2 = Salesmans_Travel.travel(r, "");
        System.out.println(res2);
    }
}
