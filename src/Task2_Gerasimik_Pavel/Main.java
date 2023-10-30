package Task2_Gerasimik_Pavel;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String fizzBuzz = (i % 5 == 0 && i % 3 == 0) ? "FizzBuzz"
                    : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz"
                    : Integer.toString(i);
            System.out.println(fizzBuzz);
        }
    }
}
