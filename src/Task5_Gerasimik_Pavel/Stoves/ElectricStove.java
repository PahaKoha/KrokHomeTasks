package Task5_Gerasimik_Pavel.Stoves;

import Task5_Gerasimik_Pavel.ImportProduct;

public class ElectricStove extends Stove implements ImportProduct {
    public ElectricStove(String model, double price, String description, int dimensions, int power, int countOfBurners) {
        super(model, price, description, dimensions, power, countOfBurners);
    }

    @Override
    public String availabilityOfGuarantee() {
        return "Quality guarantee for " + model +  " - 10 years";
    }

    @Override
    public String manufacturerCountry() {
        return "Country of origin - China";
    }
}
