package edu.javacourse.sales.external;

import edu.javacourse.sales.entity.SalesOrder;

import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesSystemFake implements SalesSystem
{
    @Override
    public List<SalesOrder> getSalesOrders(Long managerId) {
        return null;
    }
}