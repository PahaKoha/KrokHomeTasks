package Task7_Gerasimik_Pavel;

public class OutOfOrderListException extends RuntimeException {
    private final int orderListLength;

    public OutOfOrderListException(int orderListLength) {
        this.orderListLength = orderListLength;
    }

    public int getOrderListLength() {
        return orderListLength;
    }

    @Override
    public String getMessage() {
        return "Вы не можете добвлять больше чем " +  orderListLength + " товаров.";
    }
}
