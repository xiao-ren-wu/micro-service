package org.yuwb.provider;

import org.apache.dubbo.config.annotation.Service;
import org.yuwb.SayHello;

/**
 * @author yuwenbo
 * @version v1.0.0
 * <p>
 * dubbo provider demo
 * </p>
 * @since 2019/12/24 14:17
 */
@Service(version = "1.0.0")
public class SayHelloProvider implements SayHello {

    @Override
    public String sayHello(String name) {
        return name + ",hello";
    }

}
