package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceAnnotationConfig.class);
        ctx.refresh();
        final App app = ctx.getBean(App.class);
        final Table table = ctx.getBean(Table.class);
        System.out.println("Values from myapp.properties: " +
                "App Name: " + app.getAppName() + ", App Version: " + app.getAppVersion());
        System.out.println("Values from mytable.properties: " +
                "Table Height: " + table.getHeight() + ", Table Width: " + table.getWidth());
        ctx.close();
    }
}
