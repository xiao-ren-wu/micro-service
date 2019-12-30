package org.yuwb.consts;

import lombok.Getter;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/30 7:38 上午
 * @since java 11
 */
@Getter
public enum OrderStatus {
    /**
     *
     */
    ORDER_CREATED("1"),
    ORDER_PAID("2"),
    ORDER_FAIL("3")
    ;
    private String code;

    OrderStatus(String code) {
        this.code = code;
    }

}
