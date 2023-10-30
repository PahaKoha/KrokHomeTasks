package Task5_Gerasimik_Pavel.Fridges;

public class FridgeWithFreezer extends Fridge {
    private final int temperatureOfFreezer;

    public FridgeWithFreezer(String model, double price, String description, int dimensions, int power, int fridgeTemperature, int temperatureOfFreezer) {
        super(model, price, description, dimensions, power, fridgeTemperature);
        this.temperatureOfFreezer = temperatureOfFreezer;
    }

    public int getTemperatureOfFreezer() {
        return temperatureOfFreezer;
    }

    @Override
    public String toString() {
        return super.toString() +
                "temperatureOfFreezer=" + temperatureOfFreezer +
                '}';
    }
}
