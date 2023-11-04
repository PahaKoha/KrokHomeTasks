package Task7_Gerasimik_Pavel;

public class OrderStatusChecker implements OrderStatusManagement{
    private final Order order;

    public OrderStatusChecker(Order order) {
        this.order = order;
    }

    @Override
    public boolean isExpired() {
        return switch (order.getStatus()) {
            case COLLECTED -> true;
            case EXPIRED ->
                throw new OrderReceiptDatIsOverdueException();
            default -> false;
        };
    }

    public String showStatus() {
        return ("Заказ уже/еще можно получить?: " + isExpired());
    }
}


