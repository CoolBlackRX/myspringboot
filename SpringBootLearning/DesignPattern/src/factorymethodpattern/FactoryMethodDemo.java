package factorymethodpattern;

import course.Course;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Course java = courseFactory.create();
        java.recordVideo();
        System.out.println("-------------------");
        courseFactory = new PythonCourseFactory();
        Course python = courseFactory.create();
        python.recordVideo();
    }
}
