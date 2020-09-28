package reflection;

/**
 * @author zhaohq
 * @date 2020/8/28
 **/
public class Method {

    public static void main(String[] args) throws Exception {
        Book book = new Book();
        Method method = new Method();
        method.invokeMethod2(book,"Test");
    }

    public void invokeMethod(Object Book, String methodName, Object[] args) throws Exception {
        Class book = Book.getClass();

        Class[] argsClass = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            argsClass[i] = args[i].getClass();
        }

        java.lang.reflect.Method method = book.getMethod(methodName, argsClass);

        method.invoke(Book, args);

    }

    public void invokeMethod2(Object Book, String methodName) throws Exception {
        Class book = Book.getClass();
        //如果是该类的实例，就返回True
        System.out.println(book.isInstance(Book));
        //getMethod(String name) 获取指定名称的方法
        java.lang.reflect.Method method = book.getMethod(methodName);
        method.invoke(Book);
        //getMethods()和getFields()一样，都只是获取public方法，包括当前类和父类中的方法
        System.out.println("===================");
        java.lang.reflect.Method[] methods = book.getMethods();
        for (java.lang.reflect.Method m : methods) {
            System.out.println(m.getName());
        }
        System.out.println("===================");
        java.lang.reflect.Method[] declaredMethods = book.getDeclaredMethods();
        for (java.lang.reflect.Method m : declaredMethods) {
            System.out.println(m.getName());
        }


    }
}
