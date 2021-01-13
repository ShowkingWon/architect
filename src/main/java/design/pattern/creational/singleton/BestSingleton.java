package design.pattern.creational.singleton;


import design.pattern.annotation.Recommended;


/**
 * 单例模式第8种实现方式：
 *
 * 利用枚举来实现单例模式是最佳实践！！ 不近能避免多线程同步问题，还能防止反序列化重新创建新的对象！
 *
 * 总结： 在实际开发中，推荐使用！
 *
 * @author JerryWan
 * @date 2021-01-14  0:00
 */
@Recommended
public enum BestSingleton {
    INSTANCE;

    public void method(){
        System.out.println("利用枚举来实现单例模式是最佳实践！！！");

    }
}
