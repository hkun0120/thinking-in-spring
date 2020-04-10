package spring.bean.definition;

import ioc.overview.dependency.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @description: {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * 什么是Spring Bean Definition?
 *
 *  @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-07 13:41
 */
public class BeanDefinitionCreation {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(People.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("name","沙巴克");
        beanDefinitionBuilder.addPropertyValue("age","20");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition.getAttribute("name"));

        BeanNameGenerator beanNameGenerator = new DefaultBeanNameGenerator();
        BeanNameGenerator beanNameGenerator1 = new AnnotationBeanNameGenerator();

        BeanFactory beanFactory =new ClassPathXmlApplicationContext("META-INF/bean-definition-context.xml");
        People people = (People) beanFactory.getBean("people-big");
        People people1 = (People) beanFactory.getBean("people");
        System.out.println(people==people1);
        lookupByType(beanFactory);
    }

    private static void lookupByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, People> map = listableBeanFactory.getBeansOfType(People.class);
            System.out.println("查找到的集合对象People："+map);

        }

    }
}
