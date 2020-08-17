package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazySingleton {
    /**
     * ------------------
     * 懒汉式：被外部类调用时内部类才会加载
     * ------------------
     * 优点: 不浪费内存
     * 缺点: 效率低,线程不安全
     * ------------------
     */

    private LazySingleton(){}

    private static LazySingleton lazySingleton = null;

    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
