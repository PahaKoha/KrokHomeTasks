package Task7_Gerasimik_Pavel;

public class CheckStatusOfOrder {
    private final Order order;

    public CheckStatusOfOrder(Order order) {
        this.order = order;
    }

    /**
     * This method returns order status information
     *
     * @return - order status information
     */
    private String isExpired() {
        return switch (order.getStatus()) {
            case CREATED -> "Заказ еще не был собран, мы отправим вам сообщение, когда все будет готово." + "\n"
                    + "---------------------------";
            case COLLECTED ->
                    "Заказ собран, вы можете получить его до " + UsefulTools.getClearOrderDate(order.getOrderBuildDate()) + "\n"
                            + "---------------------------";
            case CLOSED ->
                    "Товар был успешно получен. Дата получения: " + UsefulTools.getClearOrderDate(order.getOrderIssueDate()) + "\n"
                            + "---------------------------";
            default -> "Срок хранения товара истек" + "\n"
                    + "---------------------------";
        };
    }

    /**
     * This method show status of order
     */
    public void showStatus() {
        System.out.println("Статус заказа: " + isExpired());
    }
}


