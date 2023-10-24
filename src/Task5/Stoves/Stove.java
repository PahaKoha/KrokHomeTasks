package Task5.Stoves;

import Task5.Appliance;

public abstract class Stove extends Appliance {
    protected int countOfBurners;

    public Stove(String model, double price, String description, int dimensions, int power, int countOfBurners) {
        super(model, price, description, dimensions, power);
        this.countOfBurners = countOfBurners;
    }

    public int getCountOfBurners() {
        return countOfBurners;
    }
}
