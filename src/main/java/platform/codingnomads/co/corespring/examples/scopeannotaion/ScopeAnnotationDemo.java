package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        SimpleClass1 simpleClass1_1 = ctx.getBean(SimpleClass1.class);
        SimpleClass1 simpleClass1_2 = ctx.getBean(SimpleClass1.class);
        System.out.println("-----Hashcode of Simple Class 1-----");
        System.out.println(simpleClass1_1.hashCode());
        System.out.println(simpleClass1_2.hashCode());

        final SimpleClass2 simpleClass2_1 = ctx.getBean(SimpleClass2.class);
        final SimpleClass2 simpleClass2_2 = ctx.getBean(SimpleClass2.class);
        System.out.println("-----Hashcode of Simple Class 2-----");
        System.out.println(simpleClass2_1.hashCode());
        System.out.println(simpleClass2_2.hashCode());
        ctx.close();
    }
}
