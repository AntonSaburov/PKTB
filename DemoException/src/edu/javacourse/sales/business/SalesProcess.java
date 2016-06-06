package edu.javacourse.sales.business;

import edu.javacourse.sales.db.SalesDb;
import edu.javacourse.sales.entity.SalesManager;
import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.entity.SalesRequest;
import edu.javacourse.sales.external.SalesSystem;

import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesProcess
{
    private SalesDb db;
    private SalesSystem salesSys;

    public void setDb(SalesDb db) {
        this.db = db;
    }

    public void setSaleSys(SalesSystem salesSys) {
        this.salesSys = salesSys;
    }

    public List<SalesManager> getSalesManagers(SalesRequest req) {
        List<SalesManager> result = db.getSalesManagers(req);

        for(SalesManager sm : result) {
            Long managerId = sm.getManagerId();
            List<SalesOrder> orders = salesSys.getSalesOrders(managerId);
            sm.setSalesOrders(orders);
        }

        return result;
    }
}
