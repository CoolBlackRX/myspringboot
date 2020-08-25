package proxypattern.bofore;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/18
 */
public class Son implements Person {
    /**
     * ------------------
     * 儿子现在是个肥宅，
     * 不愿意自己找女朋友
     * 所以爸妈很着急，
     * 要给他介绍相亲对象，
     * 得到儿子的相亲对象要求
     * ------------------
     */
    @Override
    public void findLover() {
        System.out.println("儿子要求：白富美");
    }
}
