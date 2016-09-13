package se.test;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.core.command.runtime.rule.AgendaGroupSetFocusCommand;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.command.Command;
import org.kie.api.definition.type.FactType;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.Match;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.command.CommandFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DroolsTest
{

    public static void main(String[] args) throws IntrospectionException {

        DroolsTest dt = new DroolsTest();
        dt.useDsl();
    }


    public void useDsl() {
        final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add(ResourceFactory.newClassPathResource("se/drools/test/helloWorld.dsl"), ResourceType.DSL);
        kbuilder.add(ResourceFactory.newClassPathResource("se/drools/test/helloWorld.drl"), ResourceType.DSLR);

        KieSession session = kbuilder.newKnowledgeBase().newKieSession();

        Message m1 = new Message();
        m1.setStatus(Message.GOOD_MORNING);
        m1.setMessage("Good Morning");

        Message m2 = new Message();
        m2.setStatus(Message.GOOD_DAY);
        m2.setMessage("Good Day");

        Message m3 = new Message();
        m3.setStatus(Message.GOOD_NIGHT);
        m3.setMessage("Good Night");

        session.insert(m1);
        session.insert(m2);
        session.insert(m3);

        session.fireAllRules();

        session.dispose();
    }

}