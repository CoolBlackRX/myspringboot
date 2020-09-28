package Java8Sort;

import com.sun.istack.internal.NotNull;
import com.sun.tracing.dtrace.ModuleAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohq
 * @date 2020/9/25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;

    @NotNull
    public static List<User> initList() {
        List<User> list = new ArrayList<>();
        list.add(new User("lisa", 23));
        list.add(new User("tom", 11));
        list.add(new User("john", 16));
        list.add(new User("jens", 26));
        list.add(new User("tin", 26));
        list.add(new User("army", 26));
        list.add(new User("mack", 19));
        list.add(new User("jobs", 65));
        return list;
    }
}

