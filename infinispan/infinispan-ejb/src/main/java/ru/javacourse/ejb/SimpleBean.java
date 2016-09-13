package ru.javacourse.ejb;

import org.infinispan.AdvancedCache;
import org.infinispan.commons.util.concurrent.NotifyingFuture;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.TransactionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by antonsaburov on 13.09.16.
 */
@Singleton
@Startup
public class SimpleBean
{
    public static final int COUNT = 5;

    @Resource(lookup = "java:jboss/infinispan/Test")
    private AdvancedCache<String, String> cache;

    @PostConstruct
    public void demoCache() {
        System.out.println("Start BEAN for test");
        putToCache();
        checkCache();
        clearCache();
        checkCache();
    }

    public void putToCache() {
        for(int i=0; i<COUNT; i++) {
            cache.put("" + i, "" + i);
        }
    }

    public void checkCache() {
        for(int i=0; i<COUNT; i++) {
            String answer = cache.get("" + i);
            System.out.println("Answer:" + answer);
        }
    }

    public void clearCache() {
        System.out.println("Async demo =======");
        List<NotifyingFuture<String>> list = new ArrayList<>();
        for(int i=0; i<COUNT; i++) {
            NotifyingFuture<String> f = cache.removeAsync("" + i);
            list.add(f);
        }
        for(NotifyingFuture<String> f : list) {
            try {
                String s = f.get();
                System.out.println("Remove:" + s);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
