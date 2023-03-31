package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    @Pointcut("@annotation(Printable)")
    public void executePractice() { }

    @Before("executePractice()")
    public void beforePrintToConsole(){
        System.out.println("This is the custom printable annotation before");
    }
    @After("executePractice()")
    public void afterPrintToConsole(){
        System.out.println("This is the custom printable annotation after");
    }
}
