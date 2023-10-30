package Task7_Gerasimik_Pavel;

import java.time.LocalDateTime;

public class ActionsWithOrder {
    private final Order order;

    public ActionsWithOrder(Order order) {
        this.order = order;
    }

    /**
     * This method build order
     */
    public void buildOrder() {
        if (order.getStatus() == OrderStatus.CREATED) {
            order.setStatus(OrderStatus.COLLECTED);
            order.setOrderBuildDate(LocalDateTime.now());
            new PushNotifications(order.getClientFullName(), order.getOrderNumber(), order.getProductsListInOrder(), order.getPrice(), order.getOrderBuildDate());
        } else {
            System.out.println("Товар уже собран." + "\n"
                    + "---------------------------");
        }
    }

    /**
     * This method issues order
     */
    public void issueOrder() {
        LocalDateTime currentTime = LocalDateTime.now();

        if (order.getStatus() == OrderStatus.COLLECTED && currentTime.isBefore(order.getOrderBuildDate().plusWeeks(2))) {
            order.setStatus(OrderStatus.CLOSED);
            order.setOrderIssueDate(currentTime);
            System.out.println("Заказ был успешно выдан! Дата выдачи: " + UsefulTools.getClearOrderDate(order.getOrderIssueDate()) + "\n"
                    + "---------------------------");
        } /*else if (currentTime.isAfter(order.getOrderIssueDate())) {
            expiredOrder(); // Тут очень спорный момент, так как по факту, вы этой программе срок выдачи заказа истечь не может, ведь программа не работает в реальном времени, а только единажды.
        }*/ else {
            System.out.println("Заказ еще не был собран, мы обязательно оповестим вас, когда сможете забрать заказ" + "\n"
                    + "---------------------------");
        }
    }

    /**
     * This method expired order when storage drain will expire
     */
    public void expiredOrder() { // Опять же, я не знаю где его можно использовать, так как этот метод должен сработать через недели после сборки
        if (order.getStatus() == OrderStatus.COLLECTED && LocalDateTime.now().isAfter(order.getOrderIssueDate())) {
            order.setStatus(OrderStatus.EXPIRED);
            System.out.println("К сожалению срок выдачи заказа истек.");
        }
    }
}
