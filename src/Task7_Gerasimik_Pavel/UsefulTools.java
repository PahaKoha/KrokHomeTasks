package Task7_Gerasimik_Pavel;

import Task5_Gerasimik_Pavel.Appliance;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UsefulTools {
    /**
     * This method calculate the sum of all appliances in the list
     * @param appliances - array which consist of appliances in order
     * @return - sum of all products in the list
     */
    public static double getCalculatePrice(Appliance[] appliances) {
        double sum = 0;
        for (Appliance appliance : appliances) {
            sum += appliance.getPrice();
        }
        return sum;
    }

    /**
     * This method changes the date format making it more readable
     * @param date - some date
     * @return - formatted date
     */
    public static String getClearOrderDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    /**
     * This method makes the appliances array output more readable
     * @param appliances - array which consist of appliances in order
     * @return - string consisting of all array elements
     */
    public static String getClearArrayOutput(Appliance[] appliances) {
        StringBuilder result = new StringBuilder();
        for (Appliance appliance: appliances) {
            result.append(appliance.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * This method formats the currency
     * @param price - price for appliance
     * @return - formatted price
     */
    public static String getFormatPrice (double price) {
        BigDecimal prize = new BigDecimal(price);
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(prize);
    }
}
