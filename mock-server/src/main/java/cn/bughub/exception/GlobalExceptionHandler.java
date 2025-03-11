package cn.bughub.exception;

import cn.bughub.core.Result;
import cn.bughub.enums.ErrorCode;
import cn.bughub.util.MessageUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author zwj
 * @date 2025-03-11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @Resource
    private MessageUtils messageUtils;
    
    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        
        String message = e.getArgs() != null ? messageUtils.getMessage(e.getMessage(), e.getArgs())
                : messageUtils.getMessage(e.getMessage());
        log.error("业务异常：{}", message);
        return Result.error(e.getCode(), message);
    }
    
    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = message.substring(0, message.length() - 2);
        log.error("参数校验异常：{}", msg);
        return Result.error(400, msg);
    }
    
    /**
     * 处理其他未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error("系统异常：", e);
        return Result.error(ErrorCode.SYSTEM_ERROR.getCode(), messageUtils.getMessage(ErrorCode.SYSTEM_ERROR.getMessageKey()));
    }
}