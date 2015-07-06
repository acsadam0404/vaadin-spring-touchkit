package org.vaadin.tkspring;

import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.boot.internal.VaadinServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// Make config here (vaadinServlet) override stuff in VaadinServletConfiguration
@Import(VaadinServletConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public VaadinServlet vaadinServlet() {
        return new SpringAwareTouchKitServlet();
    }

    // Stuff needed for widgetset CDN, not needed if using std widgetset
    @Bean
    public in.virit.WidgetSet viritinCdnInitializer() {
        return new in.virit.WidgetSet();
    }

}
