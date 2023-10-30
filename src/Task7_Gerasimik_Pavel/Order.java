package Task7_Gerasimik_Pavel;

import java.time.LocalDateTime;

import Task5_Gerasimik_Pavel.*;

/**
 * order entity
 */
public class Order {
    private final String orderNumber;
    private final LocalDateTime orderReceiptDate;
    private LocalDateTime orderBuildDate;
    private LocalDateTime orderIssueDate;
    private final String orderCompound;
    private final String clientFullName;
    private final String clientPhoneNumber;
    private final double price;
    private final Appliance[] productsListInOrder;
    private OrderStatus status;

    public Order(String orderCompound, String clientFullName, String clientPhoneNumber, Appliance[] appliances) {
        this.orderReceiptDate = LocalDateTime.now();
        this.orderCompound = orderCompound;
        this.clientFullName = clientFullName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.productsListInOrder = appliances;
        this.price = UsefulTools.getCalculatePrice(getProductsListInOrder());
        this.orderNumber = OrderNumberGenerator.createOrderNumber(getOrderReceiptDate(), clientPhoneNumber);
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

    public String getOrderCompound() {
        return orderCompound;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public Appliance[] getProductsListInOrder() {
        return productsListInOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setOrderBuildDate(LocalDateTime orderBuildDate) {
        this.orderBuildDate = orderBuildDate;
    }

    public void setOrderIssueDate(LocalDateTime orderIssueDate) {
        this.orderIssueDate = orderIssueDate;
    }
}