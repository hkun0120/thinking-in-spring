package spring.bean.factory;

import ioc.overview.dependency.bean.People;
import org.springframework.beans.factory.FactoryBean;

/**
 * @description: 通过factorybean的方式构建bean
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 15:28
 */
public class PeopleFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        People people = new People();
        people.setName("people factory bean ");
        return new People();
    }

    @Override
    public Class<?> getObjectType() {
        return People.class;
    }
}
