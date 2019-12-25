package org.yuwb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Micro Service Store Application BootStrap
 *
 * @author yuwenbo
 */
@MapperScan("org.yuwb.dao")
@SpringBootApplication
public class MicroServiceStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceStoreApplication.class, args);
    }
}
