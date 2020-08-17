package simplefactorypattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public interface Course {
    /**
     * 录制视频
     */
    void recordVideo();
}
class JavaCourse implements Course{

    @Override
    public void recordVideo() {
        System.out.println("录制Java课程");
    }
}
class PythonCourse implements Course{

    @Override
    public void recordVideo() {
        System.out.println("录制Python课程");
    }
}
class CPlusPlusCourse implements Course{

    @Override
    public void recordVideo() {
        System.out.println("录制C++课程");
    }
}
