package com.bpg.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author zhaohq
 */
@SpringBootApplication
public class MyspringbootApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new myViewResolver();
    }

    private static class myViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception{
            return null;
        }
    }
}
