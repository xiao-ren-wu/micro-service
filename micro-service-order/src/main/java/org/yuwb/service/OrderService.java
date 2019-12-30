package org.yuwb.service;

import org.yuwb.model.vo.OrderVO;
import org.yuwb.model.vo.RequestOrder;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/30 7:27 上午
 * @since java 11
 */
public interface OrderService {
    /**
     * 创建订单
     * @param requestOrder
     * @return
     */
    boolean createOrder(RequestOrder requestOrder);
}
