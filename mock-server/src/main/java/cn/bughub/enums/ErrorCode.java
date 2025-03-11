package cn.bughub.enums;

import lombok.Getter;

/**
 * 错误码枚举类
 *
 * @author zwj
 * @date 2025-03-11
 */
@Getter
public enum ErrorCode {
    // 通用错误码
    SUCCESS(200, "common.success"),
    SYSTEM_ERROR(500, "common.system.error"),
    PARAM_ERROR(400, "common.param.error"),
    
    // 用户模块错误码 (1001-1999)
    USER_NOT_FOUND(1001, "error.user.notfound"),
    USER_ALREADY_EXISTS(1002, "error.user.already.exists"),
    USER_PASSWORD_ERROR(1003, "error.user.password.error"),
    
    // 订单模块错误码 (2001-2999)
    ORDER_NOT_FOUND(2001, "error.order.notfound"),
    ORDER_STATUS_ERROR(2002, "error.order.status.error");
    
    private final Integer code;
    private final String messageKey;
    
    ErrorCode(Integer code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }
}