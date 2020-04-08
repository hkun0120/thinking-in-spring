package ioc.overview.dependency;

import ioc.overview.dependency.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: TODO
 * @author: H.K
 * @program: think-in-spring
 * @create: 2020-04-03 22:09
 */
public class DependencyInjection {
    private static void whoIsIocContainer(){
//        People
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        People people = (People) beanFactory.getBean("people",People.class);
        System.out.println(people.getAge());
        System.out.println(beanFactory);
        System.out.println(applicationContext.getParentBeanFactory());
    }
}
