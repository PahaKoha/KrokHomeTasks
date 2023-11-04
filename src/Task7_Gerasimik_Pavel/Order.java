package Task7_Gerasimik_Pavel;

import java.time.LocalDateTime;

import Task5_Gerasimik_Pavel.*;


public class Order implements OrderManagement{
    private final String orderNumber;
    private final LocalDateTime orderReceiptDate;
    private LocalDateTime orderBuildDate;
    private LocalDateTime orderIssueDate;
    private final String userFullName;
    private final String userPhoneNumber;
    private final double price;
    private final Appliance[] productsListInOrder;
    private OrderStatus status;

    public Order(String userFullName, String userPhoneNumber, Appliance[] appliances) {
        this.orderReceiptDate = LocalDateTime.now();
        this.userFullName = userFullName;
        this.userPhoneNumber = userPhoneNumber;

        if (appliances.length <= 75) {
            this.productsListInOrder = appliances;
        } else {
            throw new OutOfOrderListException(75);
        }

        this.price = UsefulTools.getCalculatePrice(getProductsListInOrder());
        this.orderNumber = OrderNumberGenerator.createOrderNumber(getOrderReceiptDate(), getUserPhoneNumber());
        this.status = OrderStatus.CREATED;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderReceiptDate() {
        return orderReceiptDate;
    }

    public LocalDateTime getOrderBuildDate() {
        return orderBuildDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getOrderIssueDate() {
        return orderIssueDate;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public Appliance[] getProductsListInOrder() {
        return productsListInOrder;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void buildOrder() {
        if (this.status == OrderStatus.CREATED) {
            this.status = OrderStatus.COLLECTED;
            this.orderBuildDate = LocalDateTime.now();
        }
    }

    @Override
    public void issueOrder() {
        LocalDateTime currentTime = LocalDateTime.now();

        if (status == OrderStatus.COLLECTED && currentTime.isBefore(this.orderBuildDate.plusWeeks(2))) {
            this.status = OrderStatus.CLOSED;
            this.orderIssueDate = currentTime;
        }
    }

    @Override
    public void expiredOrder() {
        if (this.status == OrderStatus.COLLECTED && LocalDateTime.now().isAfter(this.orderBuildDate.plusWeeks(2))) {
            this.status = OrderStatus.EXPIRED;
        }
    }

}