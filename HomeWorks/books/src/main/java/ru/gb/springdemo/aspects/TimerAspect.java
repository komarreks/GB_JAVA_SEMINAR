package ru.gb.springdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Aspect
@Component
public class TimerAspect {

    @Pointcut("@annotation(ru.gb.springdemo.aspects.TimerAnnotation)")
    public void getTimerAnno(){}

    @Around("getTimerAnno()")
    public Object countTime(ProceedingJoinPoint pjp){
        long start = System.currentTimeMillis();

        String className = pjp.getSignature().getDeclaringTypeName();
        String method = pjp.getSignature().getName();

        try {
            return pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            double duration = System.currentTimeMillis() - start;

            log.info("Class: " + className +
                    " - method: " + method + " #(" + duration/1000 + " c.)");
        }
    }

}
