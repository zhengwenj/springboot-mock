package cn.bughub.exception;

import cn.bughub.enums.ErrorCode;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author zwj
 * @date 2025-03-11
 */
@Getter
public class BusinessException extends RuntimeException {
    
    private final Integer code;
    
    private final String message;
    
    private final Object[] args;
    
    public BusinessException(ErrorCode errorCode) {
        
        this.code = errorCode.getCode();
        this.message = errorCode.getMessageKey();
        this.args = null;
    }
    
    public BusinessException(ErrorCode errorCode, Object... args) {
        
        this.code = errorCode.getCode();
        this.message = errorCode.getMessageKey();
        this.args = args;
    }
}