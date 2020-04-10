package dependency.lookup.delay;

import bean.People;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @description: 依赖查找中的延迟查找:单一类型依赖查找，查找已知名称或者类型的bean
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-10 22:06
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        lookUp(applicationContext);
        applicationContext.close();

    }
    @Bean
    public String hello(){
        return "hello,world!";
    }

    @Bean
    public int one(){
        return 1;
    }
    @Bean
    public String say(){
        return "你好！";
    }
    @Bean
    public People getPeople(){
        People people = new People();
        people.setAge("20");
        people.setName("kk");
        return people;
    }
    public static void lookUp(AnnotationConfigApplicationContext applicationContext){
//        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
//        System.out.println(objectProvider.getObject());
        ObjectProvider<Integer> objectProvider1 = applicationContext.getBeanProvider(Integer.class);
        System.out.println(objectProvider1.getObject());
        ObjectProvider<People> objectProvider2 = applicationContext.getBeanProvider(People.class);
        System.out.println(objectProvider2.getObject());
//        String x = applicationContext.getBean(String.class);
        Map<String,String> map = applicationContext.getBeansOfType(String.class);
        for(String key:map.keySet()){
            System.out.println("key:"+key);
            System.out.println("value:"+map.get(key));

        }
    }
}
