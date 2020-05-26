package fun.maxs.wheel.response.type;

public interface IBusinessType {
    Integer code = 2000;
    String msg = "操作成功";

    default String getMsg(){
        return msg;
    }
    default Integer getCode(){
        return code;
    }
}
