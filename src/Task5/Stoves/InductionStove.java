package Task5.Stoves;

public class InductionStove extends Stove{
    public InductionStove(String model, double price, String description, int dimensions, int power, int countOfBurners) {
        super(model, price, description, dimensions, power, countOfBurners);
    }
    @Override
    public String toString() {
        return "InductionStove{" +
                "countOfBurners=" + countOfBurners +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power=" + power +
                '}';
    }
}
