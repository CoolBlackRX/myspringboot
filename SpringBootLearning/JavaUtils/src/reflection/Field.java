package reflection;

import java.lang.reflect.Method;

/**
 * 学习了解Java的反射Method
 *
 * @author zhaohq
 * @date 2020/8/27
 */
public class Field {

    /**
     * 这个方法主要是测试getField()和getDeclaredField()
     * 使用反射来获取Class的成员变量
     *
     * @param Book      测试的class对象
     * @param fieldName 想要获取的成员变量的名称
     * @return 输入的成员变量名称的值
     * @throws Exception getField()如果获取的不是public属性的成员变量，
     *                   就会抛出IllegalArgumentException
     */
    public Object getProperty(Object Book, String fieldName) throws Exception {
        Class book = Book.getClass();

        java.lang.reflect.Field field = book.getField(fieldName);
        /*getField(String name)只能获取public属性成员，
         * 而且也可以获取父类的public成员
         * 如果获取private 或 protected 属性成员
         * 那么就会抛出IllegalArgumentException 异常信息
         * */
        java.lang.reflect.Field[] fields = book.getFields();
        /*getFields()同上*/
        for (java.lang.reflect.Field f : fields) {
            System.out.println(f.getName());
            System.out.println(f.get(Book));
            System.out.println(f);
            System.out.println("----------");
        }
        System.out.println("#################");
        /*getDeclaredFields()只能获取当前类的本身的属性成员，包括private public protected
         * 无法获取父类的成员变量
         * 那么如果想获取父类成员的private protected 变量怎么办？
         * 要通过getSuperClass()之后再使用getDeclaredFields()获取
         * */
        java.lang.reflect.Field declaredField = book.getDeclaredField(fieldName);
        java.lang.reflect.Field[] declaredFields = book.getDeclaredFields();
        for (java.lang.reflect.Field f : declaredFields) {
            System.out.println(f.getName());
            System.out.println(f.get(Book));
            System.out.println(f);
            System.out.println("----------");
        }
        /*getDeclaredField(String name) 同上*/
        Object property1 = field.get(Book);
        Object property2 = declaredField.get(Book);
        System.out.println("----------");
        System.out.println(property1);
        System.out.println(property2);
        return property1;
    }



    public static void main(String[] args) throws Exception {
        Book book = new Book();
        Field field = new Field();
        field.getProperty(book, "name");
    }
}
