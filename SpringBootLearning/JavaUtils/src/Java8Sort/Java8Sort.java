package Java8Sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaohq
 * @date 2020/9/25
 **/
public class Java8Sort {
    public static void main(String[] args) {
        List<User> list = User.initList();

        //sortBeforeJdk8(list);
        sortByLambda(list);
    }

    /**
     * JDK8 之前的排序方式
     *
     * @param list 要排序的对象列表
     * @return list 排过序的对象列表
     */
    public static List<User> sortBeforeJdk8(List<User> list) {
        // jdk8 之前的排序
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge()); // 升序
                //return o2.getAge().compareTo(o1.getAge()); // 降序
            }
        });
        list.forEach(System.out::println);
        return list;
    }

    /**
     * lambda 表达式排序
     *
     * @param list 要排序的对象列表
     * @return list 排过序的对象列表
     */
    public static List<User> sortByLambda(List<User> list) {
        list.sort((User u1, User u2) -> u1.getAge().compareTo(u2.getAge()));
        list.forEach(System.out::println);
        return list;
    }


}
