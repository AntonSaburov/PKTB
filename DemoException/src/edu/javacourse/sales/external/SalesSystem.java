package edu.javacourse.sales.external;

import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.exception.SalesSystemException;

import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public interface SalesSystem
{
    List<SalesOrder> getSalesOrders(Long managerId) throws SalesSystemException;
}
