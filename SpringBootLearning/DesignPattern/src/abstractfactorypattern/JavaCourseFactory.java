package abstractfactorypattern;

import course.Note;
import course.Source;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class JavaCourseFactory implements CourseFactory {
    /**
     * 添加笔记
     *
     * @return
     */
    @Override
    public Note createNote() {
        return new JavaNote();
    }

    /**
     * 添加源码
     *
     * @return
     */
    @Override
    public Source createSource() {
        return new JavaSource();
    }
}
