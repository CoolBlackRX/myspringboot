package com.bpg.freemarker.Test;

import com.bpg.freemarker.model.MyReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaohq
 * @date 2020/9/23
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class UnqualifiedTest {
    @Test
    public void Unqualified() {
        System.out.println(new MyReport());
    }

    @Test
    public void name() {
        System.out.println("\uF0FE A □ B □ C ");
        System.out.println("□ A \uF0FE B □ C ");
        System.out.println("□ A □ B \uF0FE C ");
    }
}
