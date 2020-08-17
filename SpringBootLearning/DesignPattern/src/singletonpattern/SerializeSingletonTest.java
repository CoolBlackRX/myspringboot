package singletonpattern;

import java.io.*;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class SerializeSingletonTest {
    /**
     * 测试反序列化破坏单例模式
     * @param args
     */
    public static void main(String[] args) {
        SerializeSingleton serializeSingleton1 = null;
        SerializeSingleton serializeSingleton2 = SerializeSingleton.getInstance();


        FileOutputStream fileOutputStream = null;
        try {
            //序列化
            fileOutputStream = new FileOutputStream("D:\\MyIDEAWorkSpace\\SpringBootLearning\\DesignPattern\\src\\singletonpattern\\SerializeSingleton.text");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializeSingleton2);
            objectOutputStream.flush();
            objectOutputStream.close();
            //反序列化
            FileInputStream fileInputStream = new FileInputStream("D:\\MyIDEAWorkSpace\\SpringBootLearning\\DesignPattern\\src\\singletonpattern\\SerializeSingleton.text");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            serializeSingleton1 = (SerializeSingleton) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(serializeSingleton1);
            System.out.println(serializeSingleton2);
            System.out.println(serializeSingleton1 == serializeSingleton2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class SerializeSingleton implements Serializable {
    private final static SerializeSingleton INSTANCE = new SerializeSingleton();

    public SerializeSingleton() {
    }

    public static SerializeSingleton getInstance() {
        return INSTANCE;
    }
}

