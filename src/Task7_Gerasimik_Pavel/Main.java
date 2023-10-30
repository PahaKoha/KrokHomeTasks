package Task7_Gerasimik_Pavel;

import Task5_Gerasimik_Pavel.Appliance;
import Task5_Gerasimik_Pavel.Fridges.FridgeWithFreezer;
import Task5_Gerasimik_Pavel.Stoves.GasStove;


public class Main {
    public static void main(String[] args) {
        Order order = new Order("test comp", "Gerasimik Pavel Olegovich", "+79142132176", new Appliance[]{
                new GasStove("Modern gas stove", 45700.50, "This new gas stove is very cool!", 450, 345, 4),
                new FridgeWithFreezer("Modern fridge with freezer", 34500.60, "Super modern fridge", 230, 780, 2, 20)
        });
        CheckStatusOfOrder checkStatusOfOrder = new CheckStatusOfOrder(order);
        ActionsWithOrder actionsWithOrder = new ActionsWithOrder(order);
        checkStatusOfOrder.showStatus();
        actionsWithOrder.buildOrder();
        checkStatusOfOrder.showStatus();
        actionsWithOrder.issueOrder();
        checkStatusOfOrder.showStatus();
    }

}
