package com.ahmad.dockerclass.firstchallenge.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggerAspect {

    private static final String Status= "Status: ";

    @Pointcut("execution(* com.ahmad.dockerclass.firstchallenge.controller.*.*(..))")
    public void Controllers() {

    }

    @Around(value = "Controllers()")
    public Object loggingController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var logger = LoggerFactory.getLogger(ControllerLoggerAspect.class);
        logRequest(logger, proceedingJoinPoint);
        try {
            Object result = proceedingJoinPoint.proceed();
            logResponse(logger, proceedingJoinPoint, result);
            return result;
        } catch (Throwable exception) {
            logException(logger, proceedingJoinPoint, exception);
            throw exception;
        }

    }

    private void logRequest(Logger logger, ProceedingJoinPoint proceedingJoinPoint) {
        StringBuilder stringBuilder = new StringBuilder("Request: {");
        appendInNewLine(stringBuilder, "Service Name: " + proceedingJoinPoint.getSignature().getName());
        Object[] methodParameters = proceedingJoinPoint.getArgs();
        for (var param : methodParameters) {
            appendParamInNewLine(stringBuilder, param);
        }

        appendInNewLine(stringBuilder,"}");
        logger.info(stringBuilder.toString());
    }

    private void logResponse(Logger logger, ProceedingJoinPoint proceedingJoinPoint, Object result) {
        StringBuilder stringBuilder = new StringBuilder("Response: {");
        appendInNewLine(stringBuilder, getServiceName( proceedingJoinPoint));
        appendInNewLine(stringBuilder, "Status: Ok ");
        appendParamInNewLine(stringBuilder, result);
        appendInNewLine(stringBuilder,"}");
        logger.info(stringBuilder.toString());
    }

    private void logException(Logger logger, ProceedingJoinPoint proceedingJoinPoint, Throwable exception) {
        StringBuilder stringBuilder = new StringBuilder("Response Exception: {");
        appendInNewLine(stringBuilder, getServiceName( proceedingJoinPoint));
        appendInNewLine(stringBuilder, Status + "500");
        appendInNewLine(stringBuilder, "Message Exception:" + exception.getMessage());
        appendInNewLine(stringBuilder,"}");
        logger.error(stringBuilder.toString(), exception);
    }

    private String getServiceName(ProceedingJoinPoint proceedingJoinPoint) {
        return "Service Name: " + proceedingJoinPoint.getSignature().getName();
    }

    private void appendParamInNewLine(StringBuilder stringBuilder, Object input) {
        if (stringBuilder == null || input == null) {
            return;
        }

        appendInNewLine(stringBuilder, input.getClass().getSimpleName() + ": " +input.toString());
    }

    private void appendInNewLine(StringBuilder stringBuilder, Object input) {
        if (stringBuilder == null || input == null) {
            return;
        }

        stringBuilder.append("\n");
        stringBuilder.append(input.toString());
    }
}
