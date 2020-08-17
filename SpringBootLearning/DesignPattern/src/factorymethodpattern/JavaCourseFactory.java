package factorymethodpattern;

import simplefactorypattern.Course;
import simplefactorypattern.JavaCourse;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Course create() {
        return new JavaCourse();
    }
}
