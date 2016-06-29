package edu.javacourse.sales.business;

import edu.javacourse.sales.db.SalesDb;
import edu.javacourse.sales.entity.SalesManager;
import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.entity.SalesRequest;
import edu.javacourse.sales.exception.SalesSystemException;
import edu.javacourse.sales.external.SalesSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesProcess
{
    private SalesDb db;
    private List<SalesSystem> salesSys;

    public void setDb(SalesDb db) {
        this.db = db;
    }

    public void setSaleSys(List<SalesSystem> salesSys) {
        this.salesSys = salesSys;
    }

    public List<SalesManager> getSalesManagers(SalesRequest req) {
        List<SalesManager> result = db.getSalesManagers(req);

        for(µ sm : result) {
            List<Future<List<SalesOrder>>> tasks = new ArrayList<>();
            ExecutorService es = Executors.newFixedThreadPool(salesSys.size());

            for(SalesSystem s : salesSys) {
                Future<List<SalesOrder>> submit = es.submit(new SalesSystemExecutor(s, sm.getManagerId()));
                tasks.add(submit);
            }

            List<SalesOrder> orders = new ArrayList<>();
            for(Future<List<SalesOrder>> f : tasks) {
                try {
                    List<SalesOrder> t = f.get();
                    orders.addAll(t);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            sm.setSalesOrders(orders);
            es.shutdown();
        }

        return result;
    }
}
