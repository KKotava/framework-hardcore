package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String getPrice (String message) {
        String price = "";
        Pattern pattern = Pattern.compile("\\bUSD\\s\\d+\\p{Punct}\\d+\\p{Punct}\\d+\\b");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            price = matcher.group(0);
        }
        return price;
    }
}
