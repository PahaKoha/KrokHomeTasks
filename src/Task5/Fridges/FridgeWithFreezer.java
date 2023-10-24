package Task5.Fridges;

import Task5.Fridges.Fridge;

public class FridgeWithFreezer extends Fridge {
    private int temperatureOfFreezer;

    public FridgeWithFreezer(String model, double price, String description, int dimensions, int power, int fridgeTemperature, int temperatureOfFreezer) {
        super(model, price, description, dimensions, power, fridgeTemperature);
        this.temperatureOfFreezer = temperatureOfFreezer;
    }

    public int getTemperatureOfFreezer() {
        return temperatureOfFreezer;
    }

    @Override
    public String toString() {
        return "FridgeWithFreezer{" +
                "temperatureOfFreezer=" + temperatureOfFreezer +
                ", fridgeTemperature=" + fridgeTemperature +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power=" + power +
                '}';
    }
}
