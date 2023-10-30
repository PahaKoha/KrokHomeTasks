package Task5_Gerasimik_Pavel;

import Task5_Gerasimik_Pavel.Fridges.FridgeWithFreezer;
import Task5_Gerasimik_Pavel.Stoves.ElectricStove;
import Task5_Gerasimik_Pavel.Stoves.GasStove;


public class Main {
    public static void main(String[] args) {
        Market market = new Market("SomeMarket", "SomeStreet");
        addProductList(market);
        System.out.println(market.showProductList());
    }
    public static void addProductList(Market market) {
        market.addNewProductInList(new ElectricStove("Some model", 600, "Some electric stove", 20, 340, 2));
        market.addNewProductInList(new GasStove("Sony", 340, "Sony's stove", 123, 780, 4));
        market.addNewProductInList(new FridgeWithFreezer("Some", 34000, "Yes", 456, 789, 67,67));
    }
}
