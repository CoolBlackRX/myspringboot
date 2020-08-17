package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazyInnerStaticClassSingleton {
    /**
     * --------------------
     * 使用时，默认会先初始化内部类
     * 如果没有使用，内部类就不会加载
     * --------------------
     */
    private LazyInnerStaticClassSingleton() {
    }

    /**
     * static 使单例的实体空间共享，final保证这个方法不会被重写、重载
     *
     * @return
     */
    public static final LazyInnerStaticClassSingleton getInstance() {
        /**
         * 返回结果之前，会先加载内部类
         */
        return LazyHolder.LAZY;
    }

    /**
     * 默认不加载
     */
    private static class LazyHolder {
        private static final LazyInnerStaticClassSingleton LAZY = new LazyInnerStaticClassSingleton();
    }

}
