package abstractfactorypattern;

import course.Source;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class PythonSource implements Source {
    /**
     * 源码资源
     */
    @Override
    public void codeSource() {
        System.out.println("Python源码");
    }
}
