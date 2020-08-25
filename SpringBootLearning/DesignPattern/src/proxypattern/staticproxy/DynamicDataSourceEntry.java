package proxypattern.staticproxy;

/**
 * @author zhaohq
 * @date 2020/8/21
 */
public class DynamicDataSourceEntry {
    /**默认数据源*/
    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public DynamicDataSourceEntry() {
    }

    /**
     * 清空数据源
     */
    public static void clear(){
        LOCAL.remove();
    }

    /**
     * 获取当前的数据源
     */
    public static String get(){
        return LOCAL.get();
    }

    /**
     * 还原当前设置的数据源
     */
    public static void restore(){
        LOCAL.set(DEFAULT_SOURCE);
    }

    /**
     * 设置已知数据源的名字
     * @param source
     * @return
     */
    public static void set(String source){
        LOCAL.set(source);
    }

    /**
     * 根据年份动态设置数据源
     * @param year
     */
    public static void set(int year){
        LOCAL.set("DB"+year);
    }
}
