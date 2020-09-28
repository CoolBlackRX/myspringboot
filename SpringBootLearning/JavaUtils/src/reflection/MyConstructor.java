package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 练习Java反射里面的
 * Constructor构造器
 * @author zhaohq
 * @date 2020/8/28
 **/
public class MyConstructor {

    private int id;
    private String name;

    public MyConstructor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyConstructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void getConstructor(Object object)  {
        Class clazz = object.getClass();
        Constructor[] myConstructors = clazz.getConstructors();
        for (Constructor c : myConstructors) {
            System.out.println(c.getName());

        }

    }

    public static void main(String[] args) {
        MyConstructor myConstructor = new MyConstructor();
        myConstructor.getConstructor(myConstructor);
    }


}
