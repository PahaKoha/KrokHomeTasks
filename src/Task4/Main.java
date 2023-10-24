package Task4;

public class Main {
    public static void main(String[] args) {
        double sum = arithmeticProgressionSum(args);
        System.out.println("Arithmetic progression sum = " + sum);

    }

    public static double arithmeticProgressionSum(String[] args) {
        if (args.length != 3) {
            System.out.println("Пожалуйста, введите три аргумента: начальный элемент, разность и количество членов прогрессии.");
            return 0;
        }
        double initialNumber = Double.parseDouble(args[0]);
        double difference = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += initialNumber + i * difference;
        }
        return sum;
    }
}
