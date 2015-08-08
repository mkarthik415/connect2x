package connect2x;

import com.vaadin.spring.internal.VaadinSessionScope;
import org.atmosphere.cpr.SessionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EnableVaadinEventBus;
import org.vaadin.spring.events.support.ApplicationContextEventBroker;

@SpringBootApplication
@EnableVaadinEventBus
public class Connect2xApplication {

    @Autowired
    EventBus.ApplicationEventBus applicationEventBus;


    @Bean
    ApplicationContextEventBroker applicationContextEventBroker() {
        return new ApplicationContextEventBroker(applicationEventBus);
    }

    @Bean
    public SessionSupport atmosphereSessionSupport() {
        return new SessionSupport();
    }

    @Bean
    static VaadinSessionScope vaadinSessionScope() {
        return new VaadinSessionScope();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(Connect2xApplication.class, args);
    }
}
