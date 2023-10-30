package Task5_Gerasimik_Pavel.Fridges;

import Task5_Gerasimik_Pavel.Appliance;

public abstract class Fridge extends Appliance {
    protected int fridgeTemperature;
    public Fridge(String model, double price, String description, int dimensions, int power, int fridgeTemperature) {
        super(model, price, description, dimensions, power);
        this.fridgeTemperature = fridgeTemperature;
    }

    @Override
    public String toString() {
        return super.toString() +
                "fridgeTemperature=" + fridgeTemperature + ", ";
    }
}
