package se.test;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DroolsTest
{

    public static void main(String[] args) throws Exception {

        DroolsTest dt = new DroolsTest();
        dt.testWithHelper();
    }

    public void testWithHelper() throws IOException, DroolsParserException {
        KieHelper kieHelper = new KieHelper();
        KieBase kieBase = kieHelper
                .addResource(ResourceFactory.newClassPathResource("se/drools/test/helloWorld.drl"), ResourceType.DRL)
                .build();

        simpleTestForDrools(kieBase);
    }

    public void simpleTestForDrools(KieBase kieBase) throws IOException, DroolsParserException {

        final KieSession kieSession = kieBase.newKieSession();

        Message m1 = new Message();
        m1.setStatus(Message.GOOD_MORNING);
        m1.setMessage("Good Morning");

        Message m2 = new Message();
        m2.setStatus(Message.GOOD_DAY);
        m2.setMessage("Good Day");

        Message m3 = new Message();
        m3.setStatus(Message.GOOD_NIGHT);
        m3.setMessage("Good Night");

        kieSession.insert(m1);
        kieSession.insert(m2);
        kieSession.insert(m3);

        List<Message> result = new ArrayList<>();
        kieSession.setGlobal("messages", result);

        SomeService service = new SomeService();
        kieSession.setGlobal("service", service);

        kieSession.fireAllRules();

        kieSession.dispose();

        System.out.println("RESULT");
        for(Message m : result) {
            System.out.println(m.getMessage());
        }
    }

}