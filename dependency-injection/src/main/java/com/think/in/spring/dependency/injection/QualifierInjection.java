package com.think.in.spring.dependency.injection;

import bean.BusinessMan;
import bean.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @description: 限定注入，使用{@link org.springframework.beans.factory.annotation.Qualifier}
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-14 17:06
 */
public class QualifierInjection {
//    @Autowired
//    People people;
//
//    @Autowired
//    People business;

    @Autowired
//    @Qualifier("businessMan")
    BusinessMan businessMan;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("META-INF/dependency-injection-context.xml");
        applicationContext.register(QualifierInjection.class);

        applicationContext.refresh();
        Map<String,People> map = applicationContext.getBeansOfType(People.class);
        for(String key:map.keySet()){
            System.out.println("key:"+key);
            System.out.println(map.get(key));
        }
        System.out.println(applicationContext.getBean(QualifierInjection.class).businessMan);
    }
}

