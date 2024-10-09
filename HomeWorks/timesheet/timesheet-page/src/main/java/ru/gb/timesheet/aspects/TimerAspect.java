package ru.gb.timesheet.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimerAspect {

    @Pointcut("@annotation(ru/gb/timesheet/aspects/TimerAnno.java)")
    public void timerPoint(){}

    @Around(value = "timerPoint()")
    public Object timeCount(ProceedingJoinPoint jp){
        long start = System.currentTimeMillis();

        try{
            return jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            //log.info();
        }
    }

}
