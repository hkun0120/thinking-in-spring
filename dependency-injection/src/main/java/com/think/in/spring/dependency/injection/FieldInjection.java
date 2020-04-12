package com.think.in.spring.dependency.injection;

import bean.BusinessMan;
import bean.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 字段注入，通过autowired注解和resource注解进行字段注入
 * autowired注入会忽略static字段
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-12 19:29
 */
public class FieldInjection {
    @Autowired
    BusinessMan businessMan;
    @Resource
    BusinessMan businessMan1;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FieldInjection.class);
        applicationContext.refresh();
//        applicationContext.
        // 通过bean名称获取bean
        Map<String,BusinessMan> map =  applicationContext.getBeansOfType(BusinessMan.class);
        for(String key:map.keySet()){
            System.out.println("key:"+key);
            System.out.println(map.get(key));
        }
        // 通过spring 里面的bean找到@Autowired的注入对象，从spring容器里找才可以，直接调用不行
        FieldInjection fieldInjection = applicationContext.getBean(FieldInjection.class);
        System.out.println(fieldInjection.businessMan1);
        System.out.println(fieldInjection.businessMan);
        System.out.println(fieldInjection.businessMan.getIndustry());
        new FieldInjection().out();
//        BusinessMan businessMan = new BusinessMan();
//        businessMan.setIndustry("IT");
//        businessMan.setIndustry("60%");
//        System.out.println(businessMan);

    }

    @Bean
    public BusinessMan initBusinessMan(){
        // 构造器注入
        return new BusinessMan("oo","11","IT","90");
    }

    /**
     * 这里全是空,不能这么访问,要通过spring容器,即application context
     */
    private void out(){
//        System.out.println(businessMan);
//        System.out.println(businessMan1);
//        System.out.println(businessMan1==businessMan);
    }


}
