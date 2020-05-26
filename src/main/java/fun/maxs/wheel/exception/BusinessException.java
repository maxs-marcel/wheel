package fun.maxs.wheel.exception;

import fun.maxs.wheel.response.type.BusinessType;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一业务异常
 *
 * @author Maxs
 * @since 2020-3-31
 */
public class BusinessException extends RuntimeException {

    @Getter
    private Integer errorCode;

    @Getter
    private String detailMessage;

    @Getter
    private Throwable cause = this;

    public BusinessException(BusinessType type) {
        this.errorCode = type.getCode();
        this.detailMessage = type.getMsg();
    }

    private BusinessException(Throwable cause) {
        super(cause);
    }

    private BusinessException() {
        super();
    }
}
