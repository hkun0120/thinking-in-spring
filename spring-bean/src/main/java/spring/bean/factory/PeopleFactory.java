package spring.bean.factory;

import ioc.overview.dependency.bean.People;

/**
 * @description: People 工厂类
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-08 15:00
 */
public class PeopleFactory {
    public static People createPeople(){
        return new People();
    }
}
