package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public enum EnumSingleton {
    /**
     * 单例创建对象
     */
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}

