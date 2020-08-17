package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class HungrySingleton {
    /**
     * -----------------------
     * 饿汉式单例模式：
     * 在类加载时就立即初始化，
     * 并且创建单例对象。
     * 不管你用不用，它就在那里
     * -----------------------
     * 优点：没有加锁，效率高，体验比懒汉式好
     * 缺点：浪费内存，占着茅坑不拉屎
     */
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
