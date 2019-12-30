package org.yuwb.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.yuwb.consts.OrderStatus;
import org.yuwb.dao.OrderMapper;
import org.yuwb.model.Order;
import org.yuwb.model.vo.RequestOrder;
import org.yuwb.service.OrderService;
import org.yuwb.store.StoreServiceApi;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/30 7:28 上午
 * @since java 11
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0.0", check = false)
    private StoreServiceApi storeServiceApi;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public boolean createOrder(RequestOrder requestOrder) {
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .orderType("1")
                .cityId(requestOrder.getCityId())
                .platformId(requestOrder.getPlatformId())
                .goodsId(requestOrder.getGoodsId())
                .orderStatus(OrderStatus.ORDER_CREATED.getCode())
                .supplierId(requestOrder.getSuppliedId())
                .createTime(LocalDateTime.now())
                .createBy("Order")
                .build();
        int currentVersion = storeServiceApi.selectVersion(requestOrder.getSuppliedId(), requestOrder.getGoodsId());
        int updateCount = storeServiceApi.updateStoreCountByVersion(currentVersion, requestOrder.getSuppliedId(), requestOrder.getGoodsId(), "order", LocalDateTime.now());
        if (updateCount == 1) {
            orderMapper.insert(order);
            return true;
        }else if(updateCount==0){
            int storeCount = storeServiceApi.selectStoreCount(requestOrder.getSuppliedId(), requestOrder.getGoodsId());
            if(storeCount==0){
                log.error("当前库存不足");
            }else{
                log.info("乐观锁生效");
            }
        }
        return false;
    }
}
