package Task5.Fridges;

import Task5.Appliance;

public abstract class Fridge extends Appliance {
    protected int fridgeTemperature;
    public Fridge(String model, double price, String description, int dimensions, int power, int fridgeTemperature) {
        super(model, price, description, dimensions, power);
        this.fridgeTemperature = fridgeTemperature;
    }
}
