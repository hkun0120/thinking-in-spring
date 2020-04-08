package spring.bean.factory;

import ioc.overview.dependency.bean.People;

/**
 * @description: TODO
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 15:12
 */
public interface IPeopleFactory {
    default People createPeople(){
        return PeopleFactory.createPeople();
    }
}
