package singletonpattern;

import java.lang.reflect.Constructor;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazyInnerStaticClassSingletonTest {
    /**
     * ----------------------------------------------
     * 因为单例模式的构造方法只加了private关键字，没有做任何处理,
     * 所以可以使用反射来调用其构造方法，再调用个体getInstance()方法,
     * 会出现两个不同的实例
     * 使用反射来破化
     * ----------------------------------------------
     * 解决办法：对LazyInnerStaticClassSingleton构造方法进行优化,
     *         一旦创建多次重复创建，抛出异常
     * ----------------------------------------------
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            //反射获取单例模式类
            Class<?> clazz = LazyInnerStaticClassSingletonPlus.class;
            //反射获取私有构造方法
            Constructor constructor = clazz.getDeclaredConstructor(null);
            //强制访问
            constructor.setAccessible(true);

            //暴力初始化
            Object object1 = constructor.newInstance();
            //调用两次初始化方法，相当于创建两次对象不同的对象，怕破坏单例模式的原则性问题
            Object object2 = constructor.newInstance();

            System.out.println(object1 == object2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
