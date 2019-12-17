package designPattern;

/**
 * DCL版单例模式
 */
public class DCLSingleton {


}

/**
 * 单线程版单例
 */
class SingletonOne {
    private static SingletonOne singletonOne = null;

    private SingletonOne(){
        System.out.println(Thread.currentThread().getName() + "创建了单例");
    }

    public static synchronized SingletonOne getSingletonOne(){
        if (singletonOne == null) {
            singletonOne = new SingletonOne();
        }
        return singletonOne;
    }

}

class Main{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonOne.getSingletonOne();
            },String.valueOf(i).toString()).start();
        }
    }

}
