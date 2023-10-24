package Task5.Stoves;

import Task5.ImportProduct;

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

    @Override
    public String toString() {
        return "ElectricStove{" +
                "countOfBurners=" + countOfBurners +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dimensions=" + dimensions +
                ", power='" + power + '\'' +
                ", availabilityOfGuarantee='" + availabilityOfGuarantee() + "'" +
                ", manufacturerCountry='" + manufacturerCountry() + "'" +
                '}';
    }
}
