package proxypattern;

import lombok.Data;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/18
 */
@Data
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;
}

class OrderDao {
    public int insert(Order order) {
        System.out.println("OrderDao成功把order插入数据库");
        return 1;
    }
}

