package Task7_Gerasimik_Pavel;

import Task5_Gerasimik_Pavel.Appliance;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UsefulTools {
    public static double getCalculatePrice(Appliance[] appliances) {
        double sum = 0;
        for (Appliance appliance : appliances) {
            sum += appliance.getPrice();
        }
        return sum;
    }

    public static String getClearOrderDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }

    public static String getClearArrayOutput(Appliance[] appliances) {
        StringBuilder result = new StringBuilder();
        for (Appliance appliance: appliances) {
            result.append(appliance.toString()).append("\n");
        }
        return result.toString();
    }

    public static String getFormatPrice (double price) {
        BigDecimal prize = new BigDecimal(price);
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return format.format(prize);
    }
}
