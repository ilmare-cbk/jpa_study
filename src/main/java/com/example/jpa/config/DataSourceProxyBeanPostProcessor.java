package com.example.jpa.config;

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceProxyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            DataSource dataSource = (DataSource) bean;
            return ProxyDataSourceBuilder.create(dataSource)
                    .logQueryBySlf4j(SLF4JLogLevel.INFO)
                    .build();
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
