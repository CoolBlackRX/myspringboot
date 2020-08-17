package abstractfactorypattern;

import course.Note;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class PythonNote implements Note {
    /**
     * 记笔记
     */
    @Override
    public void note() {
        System.out.println("Python笔记");
    }
}
