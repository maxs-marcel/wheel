package fun.maxs.wheel.exception;

import fun.maxs.wheel.consts.SystemConst;
import fun.maxs.wheel.response.Response;
import fun.maxs.wheel.response.type.BusinessType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAop.class);

    @Around(SystemConst.AOP_POINTCUT_EXCEPTION)
    public Response around(ProceedingJoinPoint pjp){
        try{
            return pjp.proceed() instanceof Response ? (Response) pjp.proceed() : Response.success(pjp.proceed());
        } catch (BusinessException e){
            Integer errorCode = e.getErrorCode();
            String detailMessage = e.getDetailMessage();
            Throwable cause = e.getCause();
            Object[] objs = e.getObjs();
            LOGGER.error("【BEGIN】------------------------------------------------------------------------------");
            LOGGER.error("------【业务异常】：errorCode: " + errorCode + ", detailMessage: " + detailMessage);
            if(objs != null) {
                for (int i = 0; i < objs.length; i++) {
                    Object obj = objs[i];
                    LOGGER.error("------【" + (obj == null ? "param[" + i + "]" : obj.getClass().getSimpleName()) + "】：" + (obj == null ? "null" : obj));
                }
            }
            LOGGER.error("------【堆栈信息】：", cause);
            LOGGER.error("【END】--------------------------------------------------------------------------------");
            return Response.error(e.getErrorCode(), e.getDetailMessage());
        } catch (IllegalArgumentException e){
            LOGGER.error("【BEGIN】------------------------------------------------------------------------------");
            LOGGER.error("------【参数异常】：errorCode: " + BusinessType.PARAM_ERROR.getCode() + ", detailMessage: " + ("".equals(e.getMessage()) ? BusinessType.PARAM_ERROR.getMsg() : e.getMessage()));
            LOGGER.error("------【堆栈信息】：", e);
            LOGGER.error("【END】--------------------------------------------------------------------------------");
            return Response.error(BusinessType.PARAM_ERROR.getCode(), "".equals(e.getMessage()) ? BusinessType.PARAM_ERROR.getMsg() : e.getMessage());
        } catch (Throwable e){
            LOGGER.error("【BEGIN】------------------------------------------------------------------------------");
            LOGGER.error("------【全局异常】：errorCode: " + BusinessType.ERROR.getCode() + ", detailMessage: " + BusinessType.ERROR.getMsg());
            LOGGER.error("------【堆栈信息】：", e);
            LOGGER.error("【END】--------------------------------------------------------------------------------");
            return Response.error();
        }
    }
}
