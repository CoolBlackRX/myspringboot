package com.bpg.mapper;

import com.bpg.bean.Dog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Repository
public interface DogMapper {
    /**
     * 展示列表
     * @return
     */
    List<Dog> listDog();

    /**
     * 根据ID获取对象--狗
     * @param id
     * @return
     */
    Dog getDogByID(Integer id );

    /**
     * 插入对象-狗
     * @param dog
     * @return
     */
    int insertDog(Dog dog);
}
