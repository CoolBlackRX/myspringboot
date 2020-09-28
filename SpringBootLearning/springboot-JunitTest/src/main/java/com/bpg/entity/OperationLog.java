package com.bpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {

    /**
     * 日志id
     */
    private String logId;
    /**
     * 日志记录时间
     */
    private LocalDateTime createTime;
    /**
     * 日志等级
     */
    private String level;
    /**
     * 被操作的对象
     */
    private String operationUnit;
    /**
     * 方法名
     */
    private String method;
    /**
     * 参数
     */
    private String args;
    /**
     * 操作人id
     */
    private String userId;
    /**
     * 操作人
     */
    private String userName;
    /**
     * 日志描述
     */
    private String describe;
    /**
     * 操作类型
     */
    private String operationType;
    /**
     * 方法运行时间
     */
    private Long runTime;
    /**
     * 方法返回值
     */
    private String returnValue;
}
