package com.think.in.spring.dependency.injection;

import bean.People;
import com.sun.tools.javah.Gen;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Map;

/**
 * @description: 构造器注入
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-12 14:30
 */
public class ConstructorInjection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConstructorInjection.class);
        applicationContext.refresh();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        // bean definition resources
        String resource = "META-INF/dependency-injection-context.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        // 通过bean名称获取bean
        People people = (People) applicationContext.getBean("people-constructor");
        System.out.println(people);

        beanFactoryDI();
    }

    /**
     * 用spring framework api 构造器依赖注入并依赖查找
     */
    public static void beanFactoryDI(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/dependency-injection-context.xml");
        People people = (People) beanFactory.getBean("people-constructor");
        // getBean 类型不安全，昨天学习过。所以这边报错NoUniqueBeanDefinitionException
//        People people1 =  beanFactory.getBean(People.class);
        System.out.println(people);
//        System.out.println(people1);
        // 通过下面就能看出来构造器注入之后的空people对象
        Map<String,People> map = beanFactory.getBeansOfType(People.class);
        for(String key:map.keySet()){
            System.out.println("key:"+key);
            System.out.println(map.get(key));
        }
    }
}
