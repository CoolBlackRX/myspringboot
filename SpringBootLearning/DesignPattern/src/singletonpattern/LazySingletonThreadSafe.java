package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazySingletonThreadSafe {
    /**
     * --------
     * 原先的懒汉式单例模式类是多线程不安全，
     * 因为有可能被实例化两次
     * -----------
     * 解决办法：加监视锁，使用关键字 synchronized
     *
     * 缺点：虽然解决了线程安全问题，
     * 但是当线程数量过多时，就会是程序的性能下降，
     * 因为加锁后。在当前线程执行完之前，其它线程是阻塞的
     * 所以，线程越多，其他的都会被阻塞，拖慢程序性能
     *
     * 解决办法：既兼顾线程安全，又保证程序性能
     *         双重检查所的单例模式
     */
    private LazySingletonThreadSafe(){}

    private static LazySingletonThreadSafe lazySingletonThreadSafe = null;

    public synchronized static LazySingletonThreadSafe getInstance(){
        if (lazySingletonThreadSafe == null){
            lazySingletonThreadSafe = new LazySingletonThreadSafe();
        }
        return lazySingletonThreadSafe;
    }

}
