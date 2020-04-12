package com.think.in.spring.dependency.injection;

import bean.BusinessMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 方法注入，@Resource @Autowired @Bean 注入,对象通过new 或者xml配置写入属性值
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-12 19:29
 */
public class MethodInjection {
    private BusinessMan businessMan;
    @Resource
    public void initBusinessMan1(BusinessMan businessMan){
        this.businessMan = businessMan;
    }

    @Autowired
    public void initBusinessMan2(BusinessMan businessMan){
        businessMan.setIndustry("kkkkkk");
        this.businessMan = businessMan;
        System.out.println(this.businessMan);
    }
//    @Bean
    public BusinessMan initBusinessMan(){
        BusinessMan businessMan = new BusinessMan("oo","11","IT","90");
        return  businessMan;
    }
    @Bean
    public BusinessMan initBusinessMan2(){
        BusinessMan businessMan = new BusinessMan();
        businessMan.setProfitRate("50");
//        this.businessMan = businessMan;
        return businessMan;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MethodInjection.class);
        applicationContext.refresh();
        // 通过bean名称获取bean
        Map<String,BusinessMan> map =  applicationContext.getBeansOfType(BusinessMan.class);
        for(String key:map.keySet()){
            System.out.println("key:"+key);
            System.out.println("value:"+map.get(key));
        }
        // 通过spring 里面的bean找到@Autowired的注入对象，从spring容器里找才可以，直接调用不行
        MethodInjection fieldInjection = applicationContext.getBean(MethodInjection.class);
        System.out.println(fieldInjection.businessMan);
        System.out.println(fieldInjection.businessMan.getIndustry());

    }




}
