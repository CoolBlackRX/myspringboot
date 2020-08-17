package factorymethodpattern;

import simplefactorypattern.Course;
import simplefactorypattern.PythonCourse;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class PythonCourseFactory implements CourseFactory {
    /**
     * 创建课程
     *
     * @return
     */
    @Override
    public Course create() {
        return new PythonCourse();
    }
}
