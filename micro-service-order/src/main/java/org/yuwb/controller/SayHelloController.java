package org.yuwb.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuwb.SayHello;

/**
 * @author yuwenbo1
 * @version v1.0.0
 * <p>
 * dubbo consumer demo
 * </p>
 * @since 2019/12/24 14:42
 */
@Slf4j
@RestController
public class SayHelloController {

    @Reference(version = "1.0.0")
    private SayHello sayHello;

    @GetMapping("/sayHello")
    public Object sayHello(String name) {
        return sayHello.sayHello(name);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> log.info(sayHello.sayHello("dubbo"));
    }

}
