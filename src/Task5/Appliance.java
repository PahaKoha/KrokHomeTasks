package Task5;

public abstract class Appliance {
    protected String model;
    protected double price;
    protected String description;
    protected int dimensions;
    protected int power;

    public Appliance(String model, double price, String description, int dimensions, int power) {
        this.model = model;
        this.price = price;
        this.description = description;
        this.dimensions = dimensions;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getDimensions() {
        return dimensions;
    }

    public int getPower() {
        return power;
    }

}
