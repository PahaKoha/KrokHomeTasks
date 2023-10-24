package Task5.Fridges;

import Task5.Fridges.Fridge;

public class MiniFridge extends Fridge {
    public MiniFridge(String model, double price, String description, int dimensions, int power, int fridgeTemperature) {
        super(model, price, description, dimensions, power, fridgeTemperature);
    }

    @Override
    public String toString() {
        return "MiniFridge{" +
                "fridgeTemperature=" + fridgeTemperature +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power=" + power +
                '}';
    }
}