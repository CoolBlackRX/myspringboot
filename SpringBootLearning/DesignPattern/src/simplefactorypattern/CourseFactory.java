package simplefactorypattern;

import com.sun.istack.internal.NotNull;

/**
 * @Description 简单工厂不易于扩展过于复杂的产品结构
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class CourseFactory {
    /**
     * @param courseType
     * @return --------
     * 如果要增加Go语言实例，
     * 工厂要添加相应的分支，
     * 所以会变的越来越大
     * ----
     */
    public static Course getCourse(CourseType courseType) {
        switch (courseType) {
            case JavaCourse:
                return new JavaCourse();
            case PythonCourse:
                return new PythonCourse();
            case CPlusPlusCourse:
                return new CPlusPlusCourse();
            default:
                break;
        }
        return null;
    }
    /**
     * ----
     * 使用类名反射，来创建实例
     * <p>
     * 但也有一个问题，如果不知道Course的实例化名称怎们办
     */
    public Course create(Class<? extends Course> clazz) {
        try {
            if (clazz != null) {
                Course course = clazz.newInstance();
                return course;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


enum CourseType {
    /**
     * Java语言
     */
    JavaCourse,
    /**
     * Python语言
     */
    PythonCourse,
    /**
     * C++语言
     */
    CPlusPlusCourse
}