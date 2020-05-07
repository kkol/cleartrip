package pl.com.phptravels.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Class is used to automatically append logs to methods,
 * which are invoked during test execution
 */
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * Defines that aspects will be supporting all public methods
     */
    @Pointcut("execution(public * *(..))")
    public void defineEntryPoint() {
    }

    /**
     * Used to log class, name and arguments of the method, which will be invoked
     *
     * @param joinPoint - stores information about the particular method
     */
    @Before("defineEntryPoint()")
    public void executedMethod(JoinPoint joinPoint) {
        logger.info(
                joinPoint.getSignature().getDeclaringType().getSimpleName() + "."
                        + joinPoint.getSignature().getName()
                        + "(" + Arrays.toString(joinPoint.getArgs()) + ")"
        );
    }
}
