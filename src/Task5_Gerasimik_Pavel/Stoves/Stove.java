package Task5_Gerasimik_Pavel.Stoves;

import Task5_Gerasimik_Pavel.Appliance;

public abstract class Stove extends Appliance {
    protected int countOfBurners;

    public Stove(String model, double price, String description, int dimensions, int power, int countOfBurners) {
        super(model, price, description, dimensions, power);
        this.countOfBurners = countOfBurners;
    }

    public int getCountOfBurners() {
        return countOfBurners;
    }

    @Override
    public String toString() {
        return super.toString() +
                "countOfBurners=" + countOfBurners + ", ";
    }
}
