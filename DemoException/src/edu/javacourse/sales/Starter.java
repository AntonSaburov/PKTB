package edu.javacourse.sales;

import edu.javacourse.sales.business.SalesProcess;
import edu.javacourse.sales.db.SalesDbFake;
import edu.javacourse.sales.entity.SalesManager;
import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.entity.SalesRequest;
import edu.javacourse.sales.external.SalesSystem;
import edu.javacourse.sales.external.SalesSystemFake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class Starter
{
    public static void main(String[] arg) {
        SalesProcess sp = new SalesProcess();

        sp.setDb(new SalesDbFake());
        List<SalesSystem> list = new ArrayList<>();
        for(int i=0; i<50; i++) {
            list.add(new SalesSystemFake());
        }
        sp.setSaleSys(list);

        SalesRequest req = new SalesRequest();
        req.setFirstName("Anton");
        req.setFrom(null);

        System.out.println(new Date());
        List<SalesManager> managers = sp.getSalesManagers(req);
        System.out.println(new Date());
        for(SalesManager m : managers) {
            System.out.println(m.getFirstName());
            for(SalesOrder so : m.getSalesOrders()) {
                System.out.println(so.getOrderName());
            }
        }

    }

}
