package abstractfactorypattern;

import course.Note;
import course.Source;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public interface CourseFactory {
    /**
     * 添加笔记
     * @return
     */
    Note createNote();

    /**
     * 添加源码
     * @return
     */
    Source createSource();
}
