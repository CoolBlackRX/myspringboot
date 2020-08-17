package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class ExecutorThread implements Runnable{
    /**
     * 线程加载懒汉式单例模式类
     */
    @Override
    public void run() {
        LazyInnerStaticClassSingleton lazySingleton = LazyInnerStaticClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+lazySingleton);
    }
}
