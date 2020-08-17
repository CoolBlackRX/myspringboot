package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazyInnerStaticClassSingletonPlus {
    /**
     * --------------------
     * 使用时，默认会先初始化内部类
     * 如果没有使用，内部类就不会加载
     * --------------------
     */
    private LazyInnerStaticClassSingletonPlus() {

        /**
         * --------------
         * 优化部分：不允许创建多个实例
         * 抛出异常，表示解决了Java反射带来的破坏问题
         */
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * static 使单例的实体空间共享，final保证这个方法不会被重写、重载
     *
     * @return
     */
    public static final LazyInnerStaticClassSingletonPlus getInstance() {
        /**
         * 返回结果之前，会先加载内部类
         */
        return LazyHolder.LAZY;
    }

    /**
     * 默认不加载
     */
    private static class LazyHolder {
        private static final LazyInnerStaticClassSingletonPlus LAZY = new LazyInnerStaticClassSingletonPlus();
    }

}
