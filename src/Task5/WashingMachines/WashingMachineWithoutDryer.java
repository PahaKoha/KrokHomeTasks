package Task5.WashingMachines;

public class WashingMachineWithoutDryer extends WashingMachine {
    public WashingMachineWithoutDryer(String model, double price, String description, int dimensions, int power, double numberOfRevolutionsPerMinute) {
        super(model, price, description, dimensions, power, numberOfRevolutionsPerMinute);
    }

    @Override
    public String toString() {
        return "WashingMachineWithoutDryer{" +
                "numberOfRevolutionsPerMinute=" + numberOfRevolutionsPerMinute +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power=" + power +
                '}';
    }
}
