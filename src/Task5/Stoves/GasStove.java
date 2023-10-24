package Task5.Stoves;

public class GasStove extends Stove{
    public GasStove(String model, double price, String description, int dimensions, int power, int countOfBurners) {
        super(model, price, description, dimensions, power, countOfBurners);
    }

    @Override
    public String toString() {
        return "GasStove{" +
                "countOfBurners=" + countOfBurners +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power=" + power +
                '}';
    }
}
