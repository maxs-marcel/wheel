package fun.maxs.wheel.exception;

import fun.maxs.wheel.response.type.IBusinessType;
import lombok.Getter;

/**
 * 统一业务异常
 *
 * @author Maxs
 * @since 2020-05-29
 */
public class BusinessException extends RuntimeException {

    @Getter
    private Integer errorCode;

    @Getter
    private String detailMessage;

    @Getter
    private Object[] objs;

    @Getter
    private Throwable cause;

    /**
     * 业务异常，按实现IBusinessType的枚举类型的code，msg进行输出json结果
     * @param type 实现IBusinessType的枚举类型
     */
    public BusinessException(IBusinessType type) {
        this.errorCode = type.getCode();
        this.detailMessage = type.getMsg();
    }

    /**
     * 业务异常，按实现IBusinessType的枚举类型的code，msg进行输出json结果
     * @param type 实现IBusinessType的枚举类型
     * @param cause 实际捕获到的异常
     */
    public BusinessException(IBusinessType type, Throwable cause) {
        this.errorCode = type.getCode();
        this.detailMessage = type.getMsg();
        this.cause = cause;
    }

    /**
     * 业务异常，按实现IBusinessType的枚举类型的code，msg进行输出json结果
     * @param type 实现IBusinessType的枚举类型
     * @param cause 实现IBusinessType的枚举类型
     * @param objs 可变参, 用于日志打印入参
     */
    public BusinessException(IBusinessType type, Throwable cause, Object... objs) {
        this.errorCode = type.getCode();
        this.detailMessage = type.getMsg();
        this.objs = objs;
        this.cause = cause;
    }

    private BusinessException() {
        super();
    }
}
