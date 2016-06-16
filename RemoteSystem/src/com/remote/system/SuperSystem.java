package com.remote.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SuperSystem
{
    public List<RemoteOrder> getOrders(Long managerId) throws RemoteException {
        List<RemoteOrder> list = new ArrayList<>();

        list.add(new RemoteOrder(1L, "Order 1"));
        list.add(new RemoteOrder(2L, "Order 2"));
        list.add(new RemoteOrder(3L, "Order 3"));
        list.add(new RemoteOrder(4L, "Order 4"));

        return list;
    }
}
