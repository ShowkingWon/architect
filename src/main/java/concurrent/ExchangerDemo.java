package concurrent;

import java.util.concurrent.Exchanger;

/**
 * java.util.concurrent包中的Exchanger类可用于两个线程之间交换信息。可简单地将Exchanger对象理解为一个包含两个格子的容器，
 * 通过exchanger方法可以向两个格子中填充信息。当两个格子中的均被填充时，该对象会自动将两个格子的信息交换，然后返回给线程，从而实现两个线程的信息交换。
 *
 * 另外需要注意的是，Exchanger类仅可用作两个线程的信息交换，当超过两个线程调用同一个exchanger对象时，
 * 得到的结果是随机的，exchanger对象仅关心其包含的两个“格子”是否已被填充数据，当两个格子都填充数据完成时，
 * 该对象就认为线程之间已经配对成功，然后开始执行数据交换操作。
 *
 * <p>
 * Exchanger可以在两个线程之间交换数据，只能是2个线程，他不支持更多的线程之间互换数据。
 * <p>
 * 当线程A调用Exchange对象的exchange()方法后，他会陷入阻塞状态，直到线程B也调用了exchange()方法，然后以线程安全的方式交换数据，之后线程A和B继续运行
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-03-17  22:06
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Exchanger1 test1 = new Exchanger1(exchanger, "message 1 .... ",
                "thread-1");
        Exchanger2 test2 = new Exchanger2(exchanger, "message 2 .... ",
                "thread-2");

        test1.start();
        test2.start();

        //
        // thread-2: message 1 ....
        // thread-1: message 2 ....

    }


}


class Exchanger1 extends Thread {
    private Exchanger<String> exchanger;
    private String msg;
    private String threadName;

    public Exchanger1(Exchanger<String> exchanger, String msg,
                      String threadName) {
        this.exchanger = exchanger;
        this.msg = msg;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + ": " + exchanger.exchange(msg));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


class Exchanger2 extends Thread {
    private Exchanger<String> exchanger;
    private String msg;
    private String threadName;

    public Exchanger2(Exchanger<String> exchanger, String msg,
                      String threadName) {
        this.exchanger = exchanger;
        this.msg = msg;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + ": " + exchanger.exchange(msg));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}