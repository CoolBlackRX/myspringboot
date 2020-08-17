package singletonpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        try {
            EnumSingleton enumSingleton1 = null;
            EnumSingleton enumSingleton2 = EnumSingleton.getInstance();
            enumSingleton2.setData(new Date());

            FileOutputStream fileOutputStream = null;
            FileInputStream fileInputStream = null;

            //序列化
            fileOutputStream = new FileOutputStream("D:\\MyIDEAWorkSpace\\SpringBootLearning\\DesignPattern\\src\\singletonpattern\\EnumSingleton.text");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(enumSingleton2);
            objectOutputStream.flush();
            objectOutputStream.close();
            //反序列化
            fileInputStream = new FileInputStream("D:\\MyIDEAWorkSpace\\SpringBootLearning\\DesignPattern\\src\\singletonpattern\\EnumSingleton.text");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            enumSingleton1 = (EnumSingleton) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(enumSingleton1.getData());
            System.out.println(enumSingleton2.getData());
            System.out.println(enumSingleton1.getData() == enumSingleton2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
