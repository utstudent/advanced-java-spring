package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import platform.codingnomads.co.corespring.examples.scopeannotaion.ScopeAnnotationDemoConfig;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(DemoConfig.class);
        ctx.refresh();

        House house = ctx.getBean(House.class);
        Car car = ctx.getBean(Car.class);

        System.out.println(car);
        System.out.println(house);


    }

}
