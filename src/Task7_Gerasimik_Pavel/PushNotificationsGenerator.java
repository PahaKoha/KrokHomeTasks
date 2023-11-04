package Task7_Gerasimik_Pavel;


public class PushNotificationsGenerator implements NotificationManagement{
    @Override
    public String notificationGeneration(Order order) {
        return "Уважаемый " + order.getUserFullName() + "!\n" +
                "\n" +
                "Рады сообщить, что Ваш заказ " + order.getOrderNumber() + " готов к выдаче.\n" +
                "\n" +
                "Состав заказа:\n" +
                UsefulTools.getClearArrayOutput(order.getProductsListInOrder()) + "\n" +
                "\n" +
                "Сумма к оплате: " + UsefulTools.getFormatPrice(order.getPrice()) + ".\n" +
                "\n" +
                "Срок хранения заказа до: " + UsefulTools.getClearOrderDate(order.getOrderBuildDate().plusWeeks(2)) + ".\n" +
                "С наилучшими пожеланиями, магазин ''Кошки и картошки''!\n";
    }
}
