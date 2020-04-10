package spring.bean.definition;

import ioc.overview.dependency.bean.People;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;
import java.util.Map;

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

        System.out.println("applicationContext已启动");
        applicationContext.getBean("dd");
        applicationContext.getBean("dd1");
        // 依赖查找
        Map map = applicationContext.getBeansOfType(BeanInitialization.class);
//        System.out.println(map.get);
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

    @Bean(name = "dd1")
    @Lazy
    public void lazyInitialization(){
        System.out.println("lazy....");
    }
    /**
     * lazy 加载的时候，如果value=false，其实这个bean是在应用上下文初始化之后才执行的，但是没有lazy或者
     * lazy=false的时候，是在application初始化之前就已经加载了
     * 分析源码 {@link org.springframework.context.support.AbstractApplicationContext}
     * finishBeanFactoryInitialization 方法
     * // Instantiate all remaining (non-lazy-init) singletons.
     * 		beanFactory.preInstantiateSingletons();
     */
    @Bean(name = "dd")
    @Lazy(value = false)
    public void initBeanByAnnotation1(){
        System.out.println("initBeanByAnnotation1");
    }
    // 基于@Bean注解实现
    @Bean
    public void initBeanByAnnotation(){
        System.out.println("initBeanByAnnotation");
    }


}
