package singletonpattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class ContainerSingleton {
    /**
     * 熟悉不?
     * 这不就是Spring里面的IOC容器吗?
     * 像不像?
     * --------------------
     * Spring 的 IOC容器设计就是容器式单例模式，线程安全。
     * --------------------
     */
    private ContainerSingleton() {
    }
    private static Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object object = null;
                try {
                    object = Class.forName(className).newInstance();
                    ioc.put(className,object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return ioc.get(className);
    }

}

