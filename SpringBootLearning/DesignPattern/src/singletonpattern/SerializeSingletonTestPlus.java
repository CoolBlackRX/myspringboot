package singletonpattern;

import java.io.*;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class SerializeSingletonTestPlus {
    /**
     * 解决反序列化破坏单例模式:
     * 增加readResolve()方法
     *
     * why: 源码看不懂
     * 大致上是readResolve() 只是把实例化的两次对象，
     * 只返回了最先创建的那个，新创建的没有返回，所以还是有内存损耗
     * 如果创建活动加频率快，内存开销就会随之增大
     *
     */
    public static void main(String[] args) {
        SerializeSingletonPlus serializeSingletonPlus1 = null;
        SerializeSingletonPlus serializeSingletonPlus2 = SerializeSingletonPlus.getInstance();


        FileOutputStream fileOutputStream = null;
        try {
            //序列化
            fileOutputStream = new FileOutputStream("D:\\MyIDEAWorkSpace\\SpringBootLearning\\DesignPattern\\src\\singletonpattern\\SerializeSingletonPlus.text");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializeSingletonPlus2);
            objectOutputStream.flush();
            objectOutputStream.close();
            //反序列化
            FileInputStream fileInputStream = new FileInputStream("D:\\MyIDEAWorkSpace\\SpringBootLearning\\DesignPattern\\src\\singletonpattern\\SerializeSingletonPlus.text");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            serializeSingletonPlus1 = (SerializeSingletonPlus) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(serializeSingletonPlus1);
            System.out.println(serializeSingletonPlus2);
            System.out.println(serializeSingletonPlus1 == serializeSingletonPlus2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class SerializeSingletonPlus implements Serializable {
    private final static SerializeSingletonPlus INSTANCE = new SerializeSingletonPlus();

    public SerializeSingletonPlus() {
    }

    public static SerializeSingletonPlus getInstance() {
        return INSTANCE;
    }
    private Object readResolve(){
        return INSTANCE;
    }
}

