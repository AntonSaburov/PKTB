package edu.javacourse.generic;

import java.util.*;

/**
 * Created by antonsaburov on 20.06.16.
 */
public class Main
{
    public static void main(String[] args) {
        String t = "1235";
        Date d = new Date();

        Builder<String> b1 = new Builder<>();
        b1.setObject(t);
        String str = b1.getObject();

        Builder<Date> b2 = new Builder<>();
        b2.setObject(d);
        Date date = b2.getObject();

        demoGeneric();
    }

    private static void demoGeneric() {
        List<String> list = new ArrayList<>();
        list.add("String");

        for(Iterator<String> it = list.iterator(); it.hasNext();) {
            String next = it.next();
        }

        for(String g : list) {

        }


        Map<Integer, Long> map = new HashMap<>();
        map.put(10, 30L);

    }
}
