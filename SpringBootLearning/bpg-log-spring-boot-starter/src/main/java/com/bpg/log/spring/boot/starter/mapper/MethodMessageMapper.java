package com.bpg.log.spring.boot.starter.mapper;

import com.bpg.log.spring.boot.starter.entity.MethodMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaohq
 * @date 2020/10/10
 **/
@Repository
public interface MethodMessageMapper extends ElasticsearchRepository<MethodMessage,Long> {
}
