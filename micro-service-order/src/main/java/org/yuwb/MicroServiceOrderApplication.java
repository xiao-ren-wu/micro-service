package org.yuwb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author yuwenbo
 */
@MapperScan("org.yuwb.dao")
@SpringBootApplication
public class MicroServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceOrderApplication.class, args);
    }
}
