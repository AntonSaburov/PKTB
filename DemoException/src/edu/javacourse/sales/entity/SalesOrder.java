package edu.javacourse.sales.entity;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesOrder
{
    private Long orderId;
    private String orderName;

    public SalesOrder(Long orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
