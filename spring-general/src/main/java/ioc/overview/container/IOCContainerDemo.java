package ioc.overview.container;

import ioc.overview.dependency.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Map;

/**
 * @description: IOC日期实例 {@link org.springframework.beans.factory.BeanFactory}
 * 通过BeanFactory和ApplicationContext 查找bean
 * @author: H.K
 * @program: think-in-spring
 * @create: 2020-04-05 14:57
 */
public class IOCContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        // 资源路径
        String location = "META-INF/dependency-injection-context.xml";
        int numberOfBeanDefinitions = reader.loadBeanDefinitions(location);
        System.out.println(numberOfBeanDefinitions);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(IOCContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        lookupByType(applicationContext);
        //关闭应用上下文
        applicationContext.close();
//        AbstractApplicationContext
    }

    @Bean
    public People people(){
        People people = new People();
        people.setAge("30");
        return people;
    }

    private static void lookupByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, People> map = listableBeanFactory.getBeansOfType(People.class);
            System.out.println("查找到的集合对象People："+map);

        }

    }
}
