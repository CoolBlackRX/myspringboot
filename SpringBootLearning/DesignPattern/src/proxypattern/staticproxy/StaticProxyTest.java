package proxypattern.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaohq
 * @date 2020/8/21
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = simpleDateFormat.parse("2020/08/25");
            order.setCreateTime(date.getTime());
            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
