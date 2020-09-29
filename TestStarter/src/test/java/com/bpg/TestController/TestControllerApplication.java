package com.bpg.TestController;

import com.bpg.SpringbootApplication;

import com.bpg.service.HelloSerivice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class TestControllerApplication {
    @Autowired
    HelloSerivice helloSerivice;

    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void test1() throws Exception{
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                    .get("/hello")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("name","Michael"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void test2() throws Exception{
        ObjectMapper om = new ObjectMapper();
        src.main.java.com.bpg.pojo.Book book = new src.main.java.com.bpg.pojo.Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setId(1);

        String str = om.writeValueAsString(book);
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                .post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(str))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
