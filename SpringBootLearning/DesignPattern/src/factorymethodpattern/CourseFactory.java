package factorymethodpattern;

import course.Course;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public interface CourseFactory {
    /**
     * 创建课程
     * @return
     */
    Course create();
}

