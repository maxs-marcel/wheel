package fun.maxs.wheel.response.type;

import lombok.Getter;

public enum ActiveBusinessType implements IBusinessType {
    ACTIVE_EXPIRED(5001, "活动已过期"),
    ACTIVE_TYPE_NOT_EXISTS(5002, "活动类型不存在"),
    ;

    @Getter
    private final Integer code;
    @Getter
    private final String msg;

    ActiveBusinessType(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }
}
