package spring.bean.definition;

import ioc.overview.dependency.bean.People;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;

/**
 * @description: Bean 初始化{@link org.springframework.beans.factory.InitializingBean}
 * 延迟初始化
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 16:21
 */
@Async
public class BeanInitialization {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitialization.class);
        applicationContext.refresh();
        applicationContext.close();
    }

    // 基于postconstructor注解实现
    @PostConstruct
    public void init(){
        People people = new People();
        people.setName("initialization ");
        people.setAge("20");
        System.out.println("bean init 初始化方法...."+people);
    }

    // 基于@Bean注解实现
    @Bean
    public void initBeanByAnnotation(){
        System.out.println("initBeanByAnnotation");
    }

    @Bean
    @Lazy
    public void initBeanByAnnotation1(){
        System.out.println("initBeanByAnnotation1");
    }

   public void lazyInitialization(){
        System.out.println("lazy....");
   }
}
