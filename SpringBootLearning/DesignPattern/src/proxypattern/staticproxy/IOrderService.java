package proxypattern.staticproxy;

/**
 * @author zhaohq
 * @date 2020/8/21
 */
public interface IOrderService{
    /**
     * 创建订单
     * @param order
     * @return
     */
    int createOrder(Order order);
}
