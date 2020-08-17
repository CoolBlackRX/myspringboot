package simplefactorypattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class CPlusPlusCourse implements Course{

    @Override
    public void recordVideo() {
        System.out.println("录制C++课程");
    }
}
