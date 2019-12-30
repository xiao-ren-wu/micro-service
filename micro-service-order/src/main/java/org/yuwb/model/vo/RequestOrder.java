package org.yuwb.model.vo;

import lombok.Data;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 *     请求创建订单对象
 * </p>
 * @version v1.0.0
 * @date 2019/12/27 8:33 上午
 * @since java 11
 */
@Data
public class RequestOrder {
    private String cityId;
    private String platformId;
    private String userId;
    private String suppliedId;
    private String goodsId;
}
