package Task12_Gerasimik_Pavel;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Red car", 2);
        Car car2 = new Car("Blue car", 4);
        Car car3 = new Car("Red car", 2);
        String result1 = customTernaryOperator("Привет",
                str -> str.contains("Пока"),
                str -> "true",
                str -> "false"
        );
        System.out.println(result1);

        boolean result2 = customTernaryOperator(car1,
                car -> car.equals(car3),
                car -> true,
                car -> false
        );
        System.out.println(result2);

        int number = 7;
        int result3 = customTernaryOperator(
                number,
                n -> n % 2 == 0,
                n -> n / 2,
                n -> n * 2
        );
        System.out.println(result3);

        String test = "Hello";
        Number result4 = customTernaryOperator(
                test,
                String::isBlank,
                String::length,
                String::hashCode
        );
        System.out.println(result4);

    }

    public static <T, R> R customTernaryOperator(T value, Predicate<T> predicate,
                                                 Function<T, R> trueResult, Function<T, R> falseResult) {
        return predicate.test(value) ? trueResult.apply(value) : falseResult.apply(value);
    }
}
