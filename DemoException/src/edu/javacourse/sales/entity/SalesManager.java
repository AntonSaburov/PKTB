package edu.javacourse.sales.entity;

import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesManager
{
    private Long managerId;
    private String firstName;
    private String lastName;
    private List<SalesOrder> salesOrders;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(List<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }
}
