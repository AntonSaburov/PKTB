package edu.javacourse.sales.db;

import edu.javacourse.sales.entity.SalesManager;
import edu.javacourse.sales.entity.SalesRequest;

import java.util.List;

/**
 * Created by antonsaburov on 06.06.16.
 */
public interface SalesDb
{
    List<SalesManager> getSalesManagers(SalesRequest request);
}
