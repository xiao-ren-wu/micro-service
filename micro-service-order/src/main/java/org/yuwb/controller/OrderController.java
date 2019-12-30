package org.yuwb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuwb.ResultEnum;
import org.yuwb.model.vo.OrderVO;
import org.yuwb.model.vo.RequestOrder;
import org.yuwb.service.OrderService;
import org.yuwb.utils.ResultVO;

import javax.annotation.Resource;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/27 8:13 上午
 * @since java 11
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

//    @HystrixCommand(
//            commandKey = "createOrder",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.timeout.enabled",value = "true"),
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
//                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
//            },
//            fallbackMethod = "createOrderFallback4Timeout",
//            threadPoolKey = "createOrderThreadPool",
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize",value = "10"),
//                    @HystrixProperty(name = "maxQueueSize", value = "2000"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold",value = "30")
//            }
//    )
    @PostMapping("createOrder")
    public ResultVO<OrderVO> createOrder(@RequestBody RequestOrder requestOrder){
        if(!orderService.createOrder(requestOrder)){
            ResultVO.createBySuccess(ResultEnum.SYSTEM_ERROR);
        }
        return ResultVO.createBySuccess(new OrderVO());
    }

    public ResultVO<OrderVO> createOrderFallback4Timeout(@RequestBody RequestOrder requestOrder){
        log.error("超时降级");
        return ResultVO.create(ResultEnum.SYSTEM_ERROR);
    }

}
