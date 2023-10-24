package Task5.WashingMachines;

import Task5.Appliance;

public abstract class WashingMachine extends Appliance {
    protected double numberOfRevolutionsPerMinute;

    public WashingMachine(String model, double price, String description, int dimensions, int power, double numberOfRevolutionsPerMinute) {
        super(model, price, description, dimensions, power);
        this.numberOfRevolutionsPerMinute = numberOfRevolutionsPerMinute;
    }

    public double getNumberOfRevolutionsPerMinute() {
        return numberOfRevolutionsPerMinute;
    }
}
