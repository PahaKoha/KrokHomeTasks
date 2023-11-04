package Task7_Gerasimik_Pavel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderNumberGenerator {
    public static String createOrderNumber(LocalDateTime orderReceiptDate, String userPhoneNumber) {
        String phoneNumber = userPhoneNumber.replace("+", "").trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss");
        String formattedDate = orderReceiptDate.format(formatter);
        String[] dateArray = formattedDate.split(" ");
        return getTwoLastSymbolByDate(dateArray) + getFourLastSymbolByPhoneNumber(phoneNumber);
    }

    public static String getTwoLastSymbolByDate(String[] array) {
        String regex = "(..)$";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder orderNumber = new StringBuilder();
        for (String s : array) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                orderNumber.append(matcher.group(1));
            }
        }
        return orderNumber.toString();
    }

    public static String getFourLastSymbolByPhoneNumber(String phoneNumber) {
        String lastFourSymbol = "";
        String regex = "(.{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            lastFourSymbol = matcher.group(1);
        }
        return lastFourSymbol;
    }
}