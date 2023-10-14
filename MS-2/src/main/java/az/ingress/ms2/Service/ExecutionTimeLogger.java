package az.ingress.ms2.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ExecutionTimeLogger {

    @Pointcut("execution( * az.ingress.ms2.Service.HelloServiceImpl.sayHello1(..))")
    public void logExecutionTimePc(){
    }
    @Around(value = "logExecutionTimePc()")
    @SneakyThrows
    public void logExecutionTime(ProceedingJoinPoint pc){
        long started =System.currentTimeMillis();
        log.info("Our aspect in action");
        pc.proceed();
        long ended = System.currentTimeMillis();
        log.info("Elapsed time {}", ended-started);
    }
    @SneakyThrows
    @Before(value = "logExecutionTimePc()")
    public void logExecutionTime(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs())
                .forEach((arg) -> log.info("arguments are {}", arg));
    }

}
