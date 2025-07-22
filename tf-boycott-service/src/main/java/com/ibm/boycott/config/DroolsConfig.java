package com.ibm.boycott.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

@ApplicationScoped
public class DroolsConfig {

    @Produces
    public KieContainer kieContainer() {
        return KieServices.get().newKieClasspathContainer();
    }
}
