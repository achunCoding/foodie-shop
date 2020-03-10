package top.wycfight.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: wycfight@163.com
 * @description: 日志监控时间
 * @create: 2020-03-06 10:14
 * @modify By:
 **/
@Component
@Aspect
public class ServiceLogAspect {

    private static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * AOP通知：
     * 1.前置通知：在方法执行之前执行
     * 2.后置通知：在方法正常调用之后执行
     * 3.环绕通知：在方法调用之前和之后，都可以执行的通知
     * 4.异常通知：方法出现异常时通知
     * 5.最终通知：在方法调用之后执行
     */
    @Around("execution(* top.wycfight.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=======开始执行{}.{}======", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        // 记录开始时间
        long begin = System.currentTimeMillis();

        // 执行目标service
        Object result = joinPoint.proceed();

        // 记录结束实现
        long endTime = System.currentTimeMillis();
        long takeTime = endTime - begin;
        if (takeTime > 3000) {
            log.error("=======执行结束 耗时 ：{} 毫秒=======",takeTime);
        } else if (takeTime > 2000) {
            log.warn("=======执行结束 耗时 ：{} 毫秒=======",takeTime);
        } else {
            log.info("=======执行结束 耗时 ：{} 毫秒=======",takeTime);
        }
        return result;
    }

}
