package designPattern;

/**
 * DCL（Double Check Lock) 双端检锁机制 版单例模式
 */

public class DCLSingleton {
    // 禁止指令重排
    private static volatile DCLSingleton singletonOne = null;

    private DCLSingleton(){
        System.out.println(Thread.currentThread().getName() + "创建了单例");
    }

    public static DCLSingleton getSingletonOne(){
        if (singletonOne == null) {
            synchronized (DCLSingleton.class) {
                if (singletonOne == null) {
                    singletonOne = new DCLSingleton();
                }
            }
        }
        return singletonOne;
    }

}

class Main{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                DCLSingleton.getSingletonOne();
            },String.valueOf(i).toString()).start();
        }
    }

}
