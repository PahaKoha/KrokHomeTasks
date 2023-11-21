package Task13_Gerasimik_Pavel;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UsefulTools {
    public static String getFormatPrice (double price) {
        BigDecimal prize = new BigDecimal(price);
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return format.format(prize);
    }

    public static String getClearOutputTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh.mm.ss");
        return time.format(formatter);
    }
}
