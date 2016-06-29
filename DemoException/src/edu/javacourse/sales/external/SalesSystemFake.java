package edu.javacourse.sales.external;

import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.exception.SalesSystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesSystemFake implements SalesSystem
{
    @Override
    public List<SalesOrder> getSalesOrders(Long managerId) throws SalesSystemException {
        List<SalesOrder> result = new ArrayList<>();
        long orderId = (long)(Math.random()* 1000000);
        SalesOrder so = new SalesOrder(orderId, "ORDER:" + orderId);
        result.add(so);
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
        }
        return result;
    }
}
