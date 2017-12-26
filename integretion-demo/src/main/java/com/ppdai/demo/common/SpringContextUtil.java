package com.ppdai.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 获取springcontext
 */
@Component("springContextUtil")
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static BeanFactory beanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(Class<T> clazz, String name) {
        return applicationContext.getBean(name, clazz);
    }

    public static String getProperty(String key){
        String propertyValue = null;

        try {
            AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext)applicationContext;
            propertyValue=abstractApplicationContext.getBeanFactory().resolveEmbeddedValue("${"+key+"}");
        } catch (Exception e) {
        }

        return propertyValue;
    }
}
