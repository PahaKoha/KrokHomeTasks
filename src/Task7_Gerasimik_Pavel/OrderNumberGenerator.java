package Task7_Gerasimik_Pavel;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderNumberGenerator {
    /**
     * This method create order number
     *
     * @param orderReceiptDate - the late when order was created
     * @param userPhoneNumber  - user's phone number
     * @return - order number
     */
    public static String createOrderNumber(LocalDateTime orderReceiptDate, String userPhoneNumber) {
        String phoneNumber = userPhoneNumber.replace("+", "").trim();
        String[] dateArray = {
                Integer.toString(orderReceiptDate.getYear()),
                Integer.toString(orderReceiptDate.getMonthValue()),
                Integer.toString(orderReceiptDate.getDayOfMonth()),
                Integer.toString(orderReceiptDate.getHour()),
                Integer.toString(orderReceiptDate.getMinute()),
                Integer.toString(orderReceiptDate.getSecond())
        };
        return getTwoLastSymbolByDate(dateArray) + getFourLastSymbolByPhoneNumber(phoneNumber);
    }

    /**
     * This method calculate last two digits of each parts of date
     *
     * @param array - array which consist of parts of date
     * @return combined converted digits
     */
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

    /**
     * This method calculate lats four digits of contains orderNumber
     *
     * @param phoneNumber - user's phone number
     * @return last four symbol user's phone number
     */
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