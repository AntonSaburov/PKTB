package se.test;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import java.io.IOException;

public class DroolsTest
{

    public static void main(String[] args) throws Exception {
        DroolsTest dt = new DroolsTest();
        dt.testWithHelper(false);
    }

    public void testWithHelper(boolean forHot) throws IOException, DroolsParserException {
        KieHelper kieHelper = new KieHelper();
        KieBase kieBase = kieHelper
                .addResource(ResourceFactory.newClassPathResource("se/drools/test/helloWorld.drl"), ResourceType.DRL)
                .build();

        simpleTestForDrools(kieBase);
    }

    public void simpleTestForDrools(KieBase kieBase) throws IOException, DroolsParserException {

        final KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}