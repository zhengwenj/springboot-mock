package cn.bughub.core;

import lombok.Data;

/**
 * 结果
 *
 * @author zwj
 * @date 2025-03-11
 */
@Data
public class Result<T> {
    
    /**
     * 状态码
     */
    private Integer code;
    
    /**
     * 提示信息
     */
    private String message;
    
    /**
     * 数据
     */
    private T data;
    
    /**
     * 成功响应
     *
     * @return {@link Result }<{@link T }>
     */
    public static <T> Result<T> success() {
        
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }
    
    /**
     * 成功响应
     *
     * @param data 数据
     * @return {@link Result }<{@link T }>
     */
    public static <T> Result<T> success(T data) {
        
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }
    
    /**
     * 成功响应
     *
     * @param message 提示信息
     * @param data    数据
     * @return {@link Result }<{@link T }>
     */
    public static <T> Result<T> success(String message, T data) {
        
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    
    /**
     * 错误响应
     *
     * @return {@link Result }<{@link T }>
     */
    public static <T> Result<T> error() {
        
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage("操作失败");
        return result;
    }
    
    /**
     * 错误响应
     *
     * @param message 提示信息
     * @return {@link Result }<{@link T }>
     */
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
    
    /**
     * 错误响应
     *
     * @param code    响应编码
     * @param message 提示信息
     * @return {@link Result }<{@link T }>
     */
    public static <T> Result<T> error(Integer code, String message) {
        
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
