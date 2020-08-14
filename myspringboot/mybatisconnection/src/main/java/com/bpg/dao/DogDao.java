package com.bpg.dao;

import com.bpg.bean.Dog;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Repository
@Lazy
public interface DogDao {
    /**
     * 获取所有狗狗信息
     * @return
     */
    List<Dog> selectAllDog();

    /**
     * 添加一条狗
     * @param dog
     */
    void insertDog(Dog dog);
}
