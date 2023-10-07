package Task2;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String FizzBuzz = (i % 5 == 0 && i % 3 == 0) ? "FizzBuzz"
                    : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz"
                    : Integer.toString(i);
            System.out.println(FizzBuzz);
        }
    }
}
