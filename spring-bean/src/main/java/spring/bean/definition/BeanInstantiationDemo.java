package spring.bean.definition;

import ioc.overview.dependency.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: bean的实例化
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 14:56
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-creation.xml");
        // 通过静态方法
        People people = beanFactory.getBean("people-by-static-method", People.class);
        //factory bean
        People peopleFB = beanFactory.getBean("people-by-factory-bean", People.class);
        System.out.println(people);
        System.out.println(peopleFB);

    }
}
