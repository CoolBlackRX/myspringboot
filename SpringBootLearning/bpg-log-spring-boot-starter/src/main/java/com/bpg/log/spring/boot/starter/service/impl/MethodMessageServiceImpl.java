package com.bpg.log.spring.boot.starter.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.bpg.log.spring.boot.starter.entity.MethodMessage;
import com.bpg.log.spring.boot.starter.entity.dto.MethodMessageDTO;
import com.bpg.log.spring.boot.starter.mapper.MethodMessageMapper;
import com.bpg.log.spring.boot.starter.service.MethodMessageService;
import com.bpg.log.spring.boot.starter.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

/**
 * @author zhaohq
 * @date 2020/9/29
 **/
@Slf4j
@Service
public class MethodMessageServiceImpl implements MethodMessageService {
    @Autowired
    MethodMessageMapper messageMapper;

    @Override
    public boolean addMyOperationLog(MethodMessage methodMessage) {
        // 记录用户是注解属性注入进来的，不是获取当前的登录用户
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
        methodMessage.setId(snowflakeIdWorker.nextId());
        methodMessage.setCreateTime(DateUtil.now());
        return ObjectUtil.isNull(messageMapper.save(methodMessage));
    }

    @Override
    public Page<MethodMessage> show(MethodMessageDTO messageDTO) {
        // 高亮查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        //创建查询条件生成器
        String userName = messageDTO.getMethodMessage().getUserName();
        String type = messageDTO.getMethodMessage().getType();
        String value = messageDTO.getMethodMessage().getValue();
        String startTime = messageDTO.getStartTime();
        String endTime = messageDTO.getEndTime();
        BoolQueryBuilder builder = QueryBuilders.boolQuery();


        // QueryStringQuery会把中文拆分到最小粒度 比如"张三"会拆成"张"、"三"，进行查询，可以视为模糊查询
        // 不是进行唯一匹配
        // must方法拼接查询语句
        if (StrUtil.isNotEmpty(userName)) {
            builder.must(QueryBuilders.queryStringQuery(userName).field("userName"));
        }
        if (StrUtil.isNotEmpty(userName)) {
            builder.must(QueryBuilders.queryStringQuery(type).field("type"));
        }
        if (StrUtil.isNotEmpty(userName)) {
            builder.must(QueryBuilders.queryStringQuery(value).field("value"));
        }
        // RangeQuery
        if (StrUtil.isNotEmpty(startTime) && StrUtil.isNotEmpty(endTime)) {
            builder.must(QueryBuilders.rangeQuery("createTime").from(startTime).to(endTime));
        }

        nativeSearchQueryBuilder.withQuery(builder);
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(messageDTO.getPage() - 1, messageDTO.getLimit()));

        // 在查询条件生成器中生成查询对象，去build构建

        return messageMapper.search(nativeSearchQueryBuilder.build());
    }

    @Override
    public Page<MethodMessage> getByUserName(String userName) {
        //创建查询条件生成器
        NativeSearchQueryBuilder nativeSearchQueryBuilder =  new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("userName",userName));
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC));
        return messageMapper.search(nativeSearchQueryBuilder.build());
    }

    @Override
    public Page<MethodMessage> getByLogValue(String logValue) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder =  new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("value",logValue));
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC));
        return messageMapper.search(nativeSearchQueryBuilder.build());
    }
}
