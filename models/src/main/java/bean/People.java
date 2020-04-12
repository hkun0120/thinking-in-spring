package bean;

/**
 * @description: TODO
 * @author: H.K
 * @program: think-in-spring
 * @create: 2020-04-03 22:14
 */
public class People {
    private String name;
    private String age;

    public People() {
    }

    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public static People createUser() {
        return new People();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "bean.People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
