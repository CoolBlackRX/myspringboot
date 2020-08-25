package proxypattern.bofore;

/**
 * @author zhaohq
 * @date 2020/8/25
 */
public class Customer implements Person {

    /**---------------
     * 大龄剩女想要找接盘,
     * 要求如下:
     * ---------------
     */
    @Override
    public void findLover() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }

    public static void main(String[] args) {
        try {
            Person object = (Person) new JdkMeiPo().getInstance(new Customer());
            object.findLover();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
