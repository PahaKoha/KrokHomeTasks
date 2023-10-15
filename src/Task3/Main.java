package Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long minRange = 2;
        long maxRange = 10_000_000_000L;

        System.out.print("Введите число в диапазоне [" + minRange + ", " + maxRange + "]: ");
        long number = in.nextLong();

        if (isValidNumber(number, minRange, maxRange)) {
            classifyNumber(number);
        } else {
            System.out.println("Вы ввели некорректное число, пожалуйста, повторите попытку еще раз");
        }
    }

    public static boolean isValidNumber(long number, long minRange, long maxRange) {
        return (number >= minRange && number <= maxRange);
    }

    public static void classifyNumber(long number) {
        if (isTwinPrime(number)) {
            System.out.println("Число " + number + " является простым и числом-близнецом");
        } else if (checkingNumberForPrimality(number)) {
            System.out.println("Число " + number + " является простым, но не числом-близнецом");
        } else {
            System.out.println("Число " + number + " является составным");
        }
    }

    public static boolean checkingNumberForPrimality(long n) {
        if (n < 2) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        long squareRootOfNumber = (long) Math.sqrt(n);
        for (long i = 2; i <= squareRootOfNumber; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTwinPrime(long n) {
        if (n == 2) {
            return false;
        }
        return checkingNumberForPrimality(n) &&
                (checkingNumberForPrimality(n + 2) || checkingNumberForPrimality(n - 2));
    }
}

