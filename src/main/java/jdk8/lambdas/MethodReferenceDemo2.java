package jdk8.lambdas;

/**
 * 方法/函数引用演示.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-03-02  0:14
 */
public class MethodReferenceDemo2 {

    private static class Person{
        private String name;

        private int age;

        public Person() {
            System.out.println("Person 无参构造..." );
        }

        public Person(String name) {
            this.name = name;
            System.out.println("Person 一个参数的构造..." );
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("Person 两个个参数的构造..." );
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @FunctionalInterface
    private interface PersonFactory0 {
        Person nextPerson();
    }

    @FunctionalInterface
    private interface PersonFactory1 {
        Person nextPerson(String name);
    }

    @FunctionalInterface
    private interface PersonFactory2 {
        Person nextPerson(String name, int age);
    }

    public static void main(String[] args) {
        //1.构造方法引用
        PersonFactory0 factory0 = Person::new;
        PersonFactory1 factory1 = Person::new;
        PersonFactory2 factory2 = Person::new;

        // 使用
        Person person = factory0.nextPerson();
        Person person1 = factory1.nextPerson("张三");
        Person person2 = factory2.nextPerson("张三", 20);


    }



}
