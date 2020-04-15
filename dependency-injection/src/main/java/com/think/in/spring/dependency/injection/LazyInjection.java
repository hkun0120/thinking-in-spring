package com.think.in.spring.dependency.injection;

import bean.BusinessMan;
import bean.People;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @description: 延迟依赖注入，使用{@link org.springframework.beans.factory.ObjectProvider}
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-14 17:06
 */
public class LazyInjection {
    @Autowired
    People people;
//
    @Autowired
    ObjectProvider<People> objectProvider;

    @Autowired
//    @Qualifier("businessMan")
    BusinessMan businessMan;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("META-INF/dependency-injection-context.xml");
        applicationContext.register(LazyInjection.class);

        applicationContext.refresh();
        Map<String,People> map = applicationContext.getBeansOfType(People.class);
        for(String key:map.keySet()){
            System.out.println("key:"+key);
            System.out.println(map.get(key));
        }
        System.out.println(applicationContext.getBean(LazyInjection.class).businessMan);
        System.out.println(applicationContext.getBean(LazyInjection.class).people);// 先找类型匹配，再找id匹配，若都有多个直接报错
        System.out.println("objectProvider:  "+applicationContext.getBean(LazyInjection.class).objectProvider.getObject());
        applicationContext.getBean(LazyInjection.class).objectProvider.forEach(System.out::println);
    }
}

