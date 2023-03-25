package platform.codingnomads.co.aspectorientedprogramming.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class PracticeAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodExecutionTimeTrackerAspect.class);

    @Before("executePractice()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("*** Party Name : ");
        message.append(message.append(joinPoint.getKind()));

        final Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            message.append("method args=|");
            Arrays.asList(args).forEach(arg -> {
                message.append("arg=").append(arg).append("|");
            });
        }
        LOGGER.info(message.toString());
    }

    @Pointcut("@annotation(Practice)")
    public void executePractice() { }
}
