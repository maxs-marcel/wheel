package fun.maxs.wheel.response;

import fun.maxs.wheel.response.type.BusinessType;
import fun.maxs.wheel.response.type.IBusinessType;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Response<T> implements Serializable {
    private String msg;
    private Integer code;
    private T data;
    private Response(){}

    /**
     * 创建默认操作成功响应体
     */
    public static <T> Response<T> success() {
        return buildSimple(BusinessType.SUCCESS);
    }

    /**
     * 创建默认成功的带data的响应体
     */
    public static <T> Response<T> success(T data){
        return buildData(BusinessType.SUCCESS, data);
    }

    /**
     * 创建默认操作失败响应体
     */
    public static <T> Response<T> error() {
        return buildSimple(BusinessType.ERROR);
    }

    /**
     * 创建默认操作失败响应体
     */
    public static <T> Response<T> error(Integer errorCode, String errorMsg) {
        Response<T> response = new Response<>();
        response.code = errorCode;
        response.msg = errorMsg;
        return response;
    }

    /**
     * 创建默认操作失败响应体
     */
    public static <T> Response<T> error(IBusinessType type) {
        return buildSimple(type);
    }

    /**
     * 创建Type类型的响应体
     */
    public static <T> Response<T> buildSimple(IBusinessType type) {
        Response<T> response = new Response<>();
        response.code = type.getCode();
        response.msg = type.getMsg();
        return response;
    }

    /**
     * 创建Type类型带data的响应体
     */
    public static <T> Response<T> buildData(IBusinessType type, T data) {
        Response<T> response = new Response<>();
        response.code = type.getCode();
        response.msg = type.getMsg();
        response.data = data;
        return response;
    }
}
