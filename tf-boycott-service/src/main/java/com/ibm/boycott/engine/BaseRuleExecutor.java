package com.ibm.boycott.engine;

import javax.inject.Inject;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public abstract class BaseRuleExecutor {

    @Inject
    protected KieContainer kieContainer;

    protected KieSession createSession(String sessionName) {
        return kieContainer.newKieSession(sessionName);
    }

    protected void fire(KieSession kieSession) {
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
