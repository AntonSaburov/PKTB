package edu.javacourse.sales.business;

import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.external.SalesSystem;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class SalesSystemExecutor implements Callable<List<SalesOrder>>
{
    private SalesSystem system;
    private Long managerId;

    public SalesSystemExecutor(SalesSystem system, Long managerId) {
        this.system = system;
        this.managerId = managerId;
    }
    @Override
    public List<SalesOrder> call() throws Exception {
        return system.getSalesOrders(managerId);
    }
}
