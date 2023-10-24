package Task5.WashingMachines;

public class WashingMachineWithDryer extends WashingMachine {
    public WashingMachineWithDryer(String model, double price, String description, int dimensions, int power, double numberOfRevolutionsPerMinute) {
        super(model, price, description, dimensions, power, numberOfRevolutionsPerMinute);
    }

    @Override
    public String toString() {
        return "WashingMachineWithDryer{" +
                "numberOfRevolutionsPerMinute=" + numberOfRevolutionsPerMinute +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power=" + power +
                '}';
    }
}
