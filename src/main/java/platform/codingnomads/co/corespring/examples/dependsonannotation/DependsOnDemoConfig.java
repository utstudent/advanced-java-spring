package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependsOnDemoConfig {

    @Bean
    @DependsOn(value = "jdk")
    public SpringDeveloper springDeveloper() {
        return new SpringDeveloper();
    }

    @Bean
    @DependsOn(value = "jdk")
    public IDE ide() {
        return new IDE();
    }
    @Bean("jdk")
    public JDK jdk() {
        return new JDK();
    }
}
