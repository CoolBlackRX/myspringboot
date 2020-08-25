package proxypattern.bofore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhaohq
 * @date 2020/8/25
 */
public class JdkMeiPo implements InvocationHandler {

    /**被代理的对象*/
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target,args);
        after();
        return null;
    }

    private void before() {
        System.out.println("我是媒婆，现在要给你物色对象，现在确认你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("如果合适的话就办事");
    }
}
