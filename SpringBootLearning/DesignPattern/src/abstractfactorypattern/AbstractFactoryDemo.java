package abstractfactorypattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CourseFactory java = new JavaCourseFactory();
        java.createNote().note();
        java.createSource().codeSource();

        CourseFactory python = new PythonCourseFactory();
        python.createNote().note();
        python.createSource().codeSource();

    }


}
