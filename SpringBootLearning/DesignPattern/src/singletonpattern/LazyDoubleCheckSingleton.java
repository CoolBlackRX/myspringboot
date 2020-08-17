package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazyDoubleCheckSingleton {
    /**
     * ---------------------
     * 双重检测锁的单例模式
     * 使用关键字 volatile 和 synchronized
     * ---------------------
     * 但是使用关键字 synchronized 总归要上锁，性能就会有所影响
     * 解决办法，采用静态内部类的方法
     */
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton(){}

    public  static LazyDoubleCheckSingleton getInstance(){
        if (lazyDoubleCheckSingleton == null){
            synchronized(LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

}
