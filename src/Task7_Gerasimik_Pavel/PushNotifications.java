package Task7_Gerasimik_Pavel;

import Task5_Gerasimik_Pavel.Appliance;

import java.time.LocalDateTime;


public record PushNotifications(String clientFullName, String orderNumber, Appliance[] productsListInOrder,
                                double price, LocalDateTime buildDate) {
    public PushNotifications(String clientFullName, String orderNumber, Appliance[] productsListInOrder, double price, LocalDateTime buildDate) {
        this.clientFullName = clientFullName;
        this.orderNumber = orderNumber;
        this.productsListInOrder = productsListInOrder;
        this.price = price;
        this.buildDate = buildDate;
        showPushNotifications();
    }

    /**
     * This method sends a message that the order is ready
     */
    public void showPushNotifications() {
        String message = "Уважаемый " + clientFullName() + "!\n" +
                "\n" +
                "Рады сообщить, что Ваш заказ " + orderNumber() + " готов к выдаче.\n" +
                "\n" +
                "Состав заказа:\n" +
                UsefulTools.getClearArrayOutput(productsListInOrder()) + "\n" +
                "\n" +
                "Сумма к оплате: " + UsefulTools.getFormatPrice(price()) + ".\n" +
                "\n" +
                "Срок хранения заказа до: " + UsefulTools.getClearOrderDate(buildDate.plusWeeks(2)) + ".\n" +
                "С наилучшими пожеланиями, магазин ''Кошки и картошки''!\n";
        System.out.println(message + "\n"
                + "---------------------------");
    }
}
