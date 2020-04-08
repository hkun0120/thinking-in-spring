package spring.bean.definition;

import ioc.overview.dependency.bean.People;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 用注解的方式搞beandefinition
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 13:21
 */
@Import(AnnotationBeanDefinition.Config.class)
public class AnnotationBeanDefinition {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config.class);
        applicationContext.refresh();
        // 依赖查找
        Map<String,Config> map = applicationContext.getBeansOfType(Config.class);
        Map<String,People> map1 = applicationContext.getBeansOfType(People.class);
        System.out.println(map1);
        System.out.println(map);
        // 通过@Bean方式进行定义
        applicationContext.close();
    }
    @Component
    public static class Config{
        @Bean
        public People people(){
            People people = new People();
            people.setAge("20");
            people.setName("kk");
            return people;
        }
    }

}
