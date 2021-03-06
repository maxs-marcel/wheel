package fun.maxs.wheel.response.type;

import lombok.Getter;

public enum BusinessType implements IBusinessType {

    SUCCESS(2000, "操作成功"),
    ERROR(5000, "操作失败"),
    PARAM_ERROR(6001, "参数异常, 操作失败"),
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
