package edu.javacourse.sales.db;

import edu.javacourse.sales.entity.SalesManager;
import edu.javacourse.sales.entity.SalesRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesDbFake implements SalesDb
{
    @Override
    public List<SalesManager> getSalesManagers(SalesRequest request) {
        List<SalesManager> list = new ArrayList<>();
        SalesManager sm = new SalesManager();
        sm.setManagerId(1L);
        sm.setFirstName("Anton");
        sm.setLastName("Petrov");

        list.add(sm);

        return list;
    }
}
