package dependency.lookup.delay;

import bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 非延迟初始化bean也能实现延迟查找吗？
 * getBeanProvider 方法的说明有：Return a provider for the specified bean, allowing for lazy on-demand retrieval
 * 	 * of instances, including availability and uniqueness options. 允许延迟按需检索
 * 	 people这个bean是非延迟创建的，所以，答案是肯定的
 * 	 安全依赖查找
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-11 13:46
 */
public class Lookup {
    public static void main(String[] args) {
        String xml = "META-INF/dependency-injection-context.xml";
        BeanFactory beanFactory =new  ClassPathXmlApplicationContext(xml);
        ObjectProvider<People> objectProvider = beanFactory.getBeanProvider(People.class);
        for (People people:objectProvider
             ) {
            System.out.println(people);
        }
        secureDenpendencyLookup();
    }

    /**
     * 类型安全依赖查找
     */
    public static  void secureDenpendencyLookup(){
        AnnotationConfigApplicationContext beanFactory =new AnnotationConfigApplicationContext();
        beanFactory.refresh();
//        beanFactory.getBean(People.class);
        // objectProvider.getIfAvailable 说明是类型安全的依赖查找
        // beanFactory.getBean和objectProvider.getObject() 不安全
        // 集合类的都是类型安全的，比如ObjectProvider<People> objectProvider
        // ObjectProvider这个不能单独说类型安全或者不安全 ，主要看其方法的具体实现，
        // 总体来说：单一查找安全性低，复合查找类型安全性高
        ObjectProvider<People> objectProvider = beanFactory.getBeanProvider(People.class);
        objectProvider.getIfAvailable();
        System.out.println(" objectProvider.getObject()"+objectProvider.getObject());
        for (People people:objectProvider
        ) {
            System.out.println(people);
        }
    }
}
