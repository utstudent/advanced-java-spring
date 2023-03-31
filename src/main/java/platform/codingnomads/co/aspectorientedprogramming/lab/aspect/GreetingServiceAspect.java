package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.*(..))")
    private void allGreetingServiceMethods() { }

    @Pointcut(value="execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.salute())")
    private void saluteMethod(){}

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void printBeforeGreeting() {
        // write any custom logic according to business requirement
        System.out.println("Before");
    }

    @After("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void printAfterGreeting() {
        // write any custom logic according to business requirement
        System.out.println("After");
    }

    @Before("saluteMethod()")
    public void printBeforeSalute(){
        System.out.println("Before salute");
    }

}
