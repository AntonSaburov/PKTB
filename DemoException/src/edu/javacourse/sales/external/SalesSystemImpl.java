package edu.javacourse.sales.external;

import com.remote.system.RemoteException;
import com.remote.system.RemoteOrder;
import com.remote.system.SuperSystem;
import edu.javacourse.sales.entity.SalesOrder;
import edu.javacourse.sales.exception.SalesSystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesSystemImpl implements SalesSystem
{
    public List<SalesOrder> getSalesOrders(Long managerId) throws SalesSystemException {
        SuperSystem ss = new SuperSystem();
        try {
            List<RemoteOrder> orders = ss.getOrders(managerId);

            ArrayList<SalesOrder> result = new ArrayList<>();
            for (RemoteOrder ro : orders) {
                SalesOrder so = new SalesOrder(ro.getOrderId(), ro.getOrderName());
                result.add(so);
            }

            return result;
        } catch (RemoteException re) {
            throw new SalesSystemException(re);
        }
    }
}
