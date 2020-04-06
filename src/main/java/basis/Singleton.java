package basis;

/**
 * 利用双锁检测来实现单例模式
 * 		JDK1.5以后 才可以安全使用DCL(双锁检测)来实现单例模式。
 * @author JerryWan
 *
 */
public class Singleton {
	/**
	 * 私有构造器。
	 */
	private Singleton(){}

	/**
	 * 私有静态域
	 */
	private volatile static Singleton instance;

	/**
	 * 共有的获取实例的方法。
	 * @return
	 */
	public static Singleton getInstance(){
		if(instance == null ){
			synchronized (Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println(new Singleton());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
	}

}
