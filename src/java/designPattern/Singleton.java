package designPattern;

/**
 * 单例模式：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。
 * 单例模式的实现方式有多重，分别对应着考虑的环境不同而设计的。
 */
public class Singleton {

    // 懒汉式
    private static volatile Singleton lazyInstance = null;
    // 饿汉式
    private static final Singleton hungrySingleton = new Singleton();
    private Singleton(){}

    /**
     * 采用懒汉式
     * 如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
     * 如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
     * @return
     */
    public static synchronized Singleton getLazyInstance(){
        if (lazyInstance == null) {
            lazyInstance = new Singleton();
        }
        return lazyInstance;
    }

    /**
     * 饿汉式单例
     * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
     */
    public static Singleton getHungrySingleton(){
        return hungrySingleton;
    }


}
