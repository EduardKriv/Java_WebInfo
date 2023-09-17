package krived.web.info.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Logger {

    @Around("execution(* krived.web.info.service.*.*(..))")
    public Object writeLog(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = pjp.proceed();
        log.info("User command start:");
        log.info("Command: {}", pjp.getSignature());
        log.info("Args: {}", pjp.getArgs());
        log.info("Output: {}", retVal);
        log.info("User command stop.");
        return retVal;
    }
}