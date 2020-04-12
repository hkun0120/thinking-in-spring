package com.think.in.spring.dependency.injection;

import bean.People;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: setter注入
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-12 14:13
 */
public class SetterInjection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SetterInjection.class);
        applicationContext.refresh();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        // bean definition resources
        String resource = "META-INF/dependency-injection-context.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        // 通过bean名称获取bean
        People people = (People) applicationContext.getBean("people");
        System.out.println(people);

    }
}
