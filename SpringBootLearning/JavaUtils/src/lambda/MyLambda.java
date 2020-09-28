package lambda;

import com.sun.javafx.scene.layout.region.Margins;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;

/**
 * 练习lambda表达式
 *
 * @author zhaohq
 * @date 2020/8/28
 **/
public class MyLambda {
    final static String SALUTATION = "Hello! ";

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        MyLambda myLambda = new MyLambda();
        //数学相加的操作，有参数类型
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation addition2 = Integer::sum;
        //没有参数类型
        MathOperation subtraction = (a, b) -> a - b;

        //有大括号return语句
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };
        //没有大括号和返回语句
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + myLambda.operate(10, 5, addition));
        System.out.println("10 + 5 = " + myLambda.operate(10, 5, addition2));
        System.out.println("10 - 5 = " + myLambda.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + myLambda.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + myLambda.operate(10, 5, division));


        //不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);

        //用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");

        /**
         * ------------------------------------
         * lambda 表达式对用final标记了的变量只能引用，
         * 不能在lambda内部修改定义在域外的局部变量
         * -------------------------------------
         */
        GreetingService greetingService3 = message -> System.out.println(SALUTATION + message);
        greetingService3.sayMessage("zhaohq");

        //可以直接在lambda表达式中访问外层的局部变量
        final int num = 1;


    }

}

interface MathOperation {
    /**
     * 数学操作
     *
     * @param a 数字
     * @param b 数字
     * @return int类型
     */
    int operation(int a, int b);
}

interface GreetingService {
    /**
     * 叫床服务
     *
     * @param message 问候语
     */
    void sayMessage(String message);
}