package edu.javacourse.collection;

import java.util.*;

/**
 * Created by antonsaburov on 20.06.16.
 */
public class Main
{
    public static void main(String[] args) {
        //demoList();
        //demoSet();

        //demoSortedSet();

        demoMap();
    }

    private static void demoMap() {
        Map map = new HashMap();

        for(int i=0; i<10; i++) {
            map.put(i, "String_" + i);
        }
//        for(Object key : map.keySet()) {
//            System.out.println(key.getClass().getSimpleName());
//            Object value = map.get(key);
//            System.out.println(value.getClass().getCanonicalName());
//            System.out.println(key + ":" +value);
//        }
//        System.out.println();
        for(Object value : map.values()) {
//            System.out.println(value);
        }
        System.out.println();
        for(Object e : map.entrySet()) {
            Map.Entry entry = (Map.Entry)e;
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    private static void demoSortedSet() {
//        SortedSet srs = new TreeSet();
//
//        srs.add("String 30");
//        srs.add("String 20");
//        srs.add("String 50");
//        srs.add("String 10");
//
//        for(Object d : srs) {
//            System.out.println(d);
//        }
//        System.out.println();

        SortedSet srs2 = new TreeSet();
        srs2.add(new MyClass("30"));
        srs2.add(new MyClass("20"));
        srs2.add(new MyClass("50"));
        srs2.add(new MyClass("10"));

        for(Object d : srs2) {
            System.out.println(d);
        }
    }

    private static void demoList() {
        List l = new ArrayList(100);
        l.add("String 1");
        l.add("String 2");
        l.add("String 1");

        Object o = l.get(0);

        Iterator it = l.iterator();
        while(it.hasNext()) {
            String f = (String)it.next();
            System.out.println(f);
            //it.remove();
        }
        System.out.println();
        for(Iterator it2 = l.iterator(); it2.hasNext(); ) {
            String f = (String)it2.next();
            System.out.println(f);
        }
        System.out.println();
        for(Object obj : l) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("Size:" + l.size());
    }

    private static void demoSet() {
        Set s = new HashSet();

        boolean s1 = s.add("String 1");
        boolean s2 = s.add("String 2");
        boolean s3 = s.add("String 1");
        System.out.println(s1 + ", " + s2 + ", " + s3);

        System.out.println();
        for(Object obj : s) {
            System.out.println(obj);
        }

    }
}
