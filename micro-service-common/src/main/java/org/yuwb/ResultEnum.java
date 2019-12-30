package org.yuwb;

import lombok.Getter;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/27 8:22 上午
 * @since java 11
 */
@Getter
public enum ResultEnum {
    /**
     * success
     */
    SUCCESS("200","success"),
    /**
     * system error
     */
    SYSTEM_ERROR("500","system error")
    ;
    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
