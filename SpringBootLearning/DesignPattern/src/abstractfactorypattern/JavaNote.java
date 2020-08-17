package abstractfactorypattern;

import course.Note;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class JavaNote implements Note {

    /**
     * 记笔记
     */
    @Override
    public void note() {
        System.out.println("Java笔记");
    }
}
