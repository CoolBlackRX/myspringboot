package string;

import java.text.MessageFormat;
import java.util.Map;

/**
 * @author zhaohq
 * @date 2020/9/10
 **/
public class MyStringTest {
    public static void main(String[] args) {
        // 测试输出字符串换行
        String str = new String("测试" + "\n");
        System.out.print(str);
        System.out.println("===========================================");
        String a = "aaa";
        String b = "bb";
        String c = "c";
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b).append(c);
        System.out.println(MessageFormat.format(" {0} ,{1}, {2} ,{3}", a, b, "", sb));
        System.out.println(MessageFormat.format(" ''{0}'' '{1}' {2} {3}", a, b, "", sb.toString()));



        String s = "异常处理通知： #{expCategory} #{creationTime}";
        System.out.println(s);
        System.out.println(s.replace("#",""));
        System.out.println(s.replaceAll("#\\{expCategory}","zhaohq"));

    }
}
