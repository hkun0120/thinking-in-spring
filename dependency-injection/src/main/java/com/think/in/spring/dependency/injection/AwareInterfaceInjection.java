package com.think.in.spring.dependency.injection;

import bean.BusinessMan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: Aware接口回调注入 {@link org.springframework.beans.factory.Aware}
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-12 19:29
 */
public class AwareInterfaceInjection implements BeanFactoryAware, ApplicationContextAware {
    private static BeanFactory beanFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareInterfaceInjection.class);
        applicationContext.refresh();

        // 通过spring 里面的bean找到@Autowired的注入对象，从spring容器里找才可以，直接调用不行
        AwareInterfaceInjection fieldInjection = applicationContext.getBean(AwareInterfaceInjection.class);
        System.out.println(fieldInjection.beanFactory ==beanFactory);

    }


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
