package Task7_Gerasimik_Pavel;

import Task5_Gerasimik_Pavel.Appliance;
import Task5_Gerasimik_Pavel.Fridges.FridgeWithFreezer;
import Task5_Gerasimik_Pavel.Stoves.GasStove;


public class Main {
    public static void main(String[] args) {
        Order order = new Order("Gerasimik Pavel", "+79142132176", new Appliance[]{
                new GasStove("Modern gas stove", 45700.50, "This new gas stove is very cool!", 450, 345, 4),
                new FridgeWithFreezer("Modern fridge with freezer", 34500.60, "Super modern fridge", 230, 780, 2, 20)
        });
        OrderStatusChecker checkStatusOfOrder = new OrderStatusChecker(order);
        System.out.println(checkStatusOfOrder.showStatus());
        order.buildOrder();
        System.out.println(checkStatusOfOrder.showStatus());
        order.issueOrder();
        System.out.println(checkStatusOfOrder.showStatus());
        order.expiredOrder();
    }

}
