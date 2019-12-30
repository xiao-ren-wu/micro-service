package org.yuwb.configuration;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/27 8:01 上午
 * @since java 11
 */
@Configuration
public class HystrixConfig {
    /**
     * 用于处理HystrixCommand注解
     *
     * @return {@link HystrixCommandAspect}
     */
    @Bean
    public HystrixCommandAspect hystrixCommandAspect() {
        return new HystrixCommandAspect();
    }

    /**
     * 用来像监控中心DashBoard发送stream信息
     *
     * @return {@link ServletRegistrationBean}
     */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixMetricsStreamServlet() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }

}
