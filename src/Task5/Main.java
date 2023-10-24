package Task5;

import Task5.Stoves.ElectricStove;
import Task5.Stoves.GasStove;


public class Main {
    public static void main(String[] args) {
        Market market = new Market("SomeMarket", "SomeStreet");
        System.out.println(showProductList(market));
    }

    public static String showProductList (Market market){
        addProductList(market);
        return market.showProductList();
    }

    public static Market addProductList(Market market) {
        market.addNewProductInList(new ElectricStove("Some model", 600, "Some electric stove", 20, 340, 2));
        market.addNewProductInList(new GasStove("Sony", 340, "Sony's stove", 123, 780, 4));
        return market;
    }
}
