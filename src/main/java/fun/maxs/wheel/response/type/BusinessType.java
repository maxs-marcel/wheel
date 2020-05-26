package fun.maxs.wheel.response.type;

import lombok.Getter;

public enum BusinessType implements IBusinessType {

    SUCCESS(2000, "操作成功"),
    ERROR(5000, "操作失败"),
    ACTIVE_EXPIRED(5001, "活动已过期"),
    ACTIVE_TYPE_NOT_EXISTS(5002, "活动类型不存在"),
    ;

    @Getter
    private final Integer code;
    @Getter
    private final String msg;

    BusinessType(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }
}
