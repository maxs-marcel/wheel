package fun.maxs.wheel.exception;

import fun.maxs.wheel.response.Response;
import fun.maxs.wheel.response.type.BusinessType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAop {

    @Around("execution(public * fun.maxs.wheel.controller.*.*(..))")
    public Response around(ProceedingJoinPoint pjp){
        try{
            return pjp.proceed() instanceof Response ? (Response) pjp.proceed() : Response.success(pjp.proceed());
        } catch (BusinessException e){
            return Response.error(e.getErrorCode(), e.getDetailMessage());
        } catch (IllegalArgumentException e){
            return Response.error(BusinessType.ERROR.getCode(), e.getMessage());
        } catch (Throwable e){
            return Response.error();
        }
    }
}
