package simplefactorypattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        //个人觉的还是这种方法比较好，因为下面的方法需要程序员知道Course的具体实例有那些，并且要知道他们的名字
        Course javaCourse = CourseFactory.getCourse(CourseType.JavaCourse);
        assert javaCourse != null;
        javaCourse.recordVideo();

        System.out.println("-----------------------");
        CourseFactory courseFactory = new CourseFactory();
        Course java = courseFactory.create(JavaCourse.class);
        java.recordVideo();
    }
}
