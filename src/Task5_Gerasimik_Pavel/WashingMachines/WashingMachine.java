package Task5_Gerasimik_Pavel.WashingMachines;

import Task5_Gerasimik_Pavel.Appliance;

public abstract class WashingMachine extends Appliance {
    protected double numberOfRevolutionsPerMinute;

    public WashingMachine(String model, double price, String description, int dimensions, int power, double numberOfRevolutionsPerMinute) {
        super(model, price, description, dimensions, power);
        this.numberOfRevolutionsPerMinute = numberOfRevolutionsPerMinute;
    }

    public double getNumberOfRevolutionsPerMinute() {
        return numberOfRevolutionsPerMinute;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numberOfRevolutionsPerMinute=" + numberOfRevolutionsPerMinute + ", ";
    }
}
