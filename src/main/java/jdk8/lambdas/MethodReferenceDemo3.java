package jdk8.lambdas;

/**
 * 方法/函数引用演示.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-03-02  0:14
 */
public class MethodReferenceDemo3 {

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
    private interface PersonInterface {
        String get(Person person);
    }

    @FunctionalInterface
    private interface PersonInterface1 {
        void set(Person person , String name);
    }

    public static void main(String[] args) {
        //1.lambda中的对象的特殊方法引用
        Person person = new Person("Jack",100);

        // 使用 lambda中有一个对象, 仅仅是调用该对象的某个方法
        //PersonInterface labmda0 = x -> x.getName();
        PersonInterface labmda = Person::getName;

        PersonInterface1 labmda1 = Person::setName;



    }



}
