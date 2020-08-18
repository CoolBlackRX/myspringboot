package proxypattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/18
 */
public class FatherTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
