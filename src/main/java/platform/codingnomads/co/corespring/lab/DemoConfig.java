package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import platform.codingnomads.co.corespring.examples.application_context.xml.JDK;

@Configuration
@ImportResource({"classpath*:xml-config/codingnomad_configuration.xml"})

public class DemoConfig {


    @Bean
    public Car car(){
        return new Car("Honda","Pilot","2022");
    }

    @Bean
    public House house() {
        return new House(2040,"2020",3,2);
    }


}
