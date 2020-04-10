package spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PreDestroy;

/**
 * @description: bean 的销毁
 * api 、xml以及注解三种方式
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 23:23
 */
public class BeanDestroy {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDestroy.class);
        applicationContext.refresh();
        applicationContext.close();
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }



}
