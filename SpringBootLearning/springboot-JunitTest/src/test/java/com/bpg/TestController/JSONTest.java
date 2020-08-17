package com.bpg.TestController;

import com.bpg.pojo.Book;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JSONTest {

    @Autowired
    JacksonTester<Book> jacksonTester;
    //Json文件要放在resource下和测试类的路径一直

    @Test
    public void testSerialize() throws Exception{
        Book book = new Book();
        book.setId(1);
        book.setName("西游记");
        book.setAuthor("吴承恩");
        Assertions.assertThat(jacksonTester.write(book))
                .isEqualToJson("book.json");
        Assertions.assertThat(jacksonTester.write(book))
                .hasJsonPathStringValue("@.name");
        Assertions.assertThat(jacksonTester.write(book))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("西游记");
    }

    @Test
    public void testDeserialize() throws Exception{
        String content = "{\"id\":1,\"name\":\"西游记\",\"author\":\"吴承恩\"}";
        Assertions.assertThat(jacksonTester.parseObject(content).getName())
                .isEqualTo("西游记");
    }

}
