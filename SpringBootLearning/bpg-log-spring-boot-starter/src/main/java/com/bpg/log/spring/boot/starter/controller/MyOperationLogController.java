package com.bpg.log.spring.boot.starter.controller;

import com.bpg.common.kit.ApiResult;
import com.bpg.common.kit.DataAndTotal;
import com.bpg.log.spring.boot.starter.entity.MethodMessage;
import com.bpg.log.spring.boot.starter.entity.dto.MethodMessageDTO;
import com.bpg.log.spring.boot.starter.service.MethodMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohq
 * @date 2020/10/10
 **/
@RestController
@RequestMapping("/MyOperationLog")
@Api(value = "方法调用日志管理", tags = "方法调用日志管理接口")
public class MyOperationLogController {
    @Autowired
    MethodMessageService methodMessageService;


    @PostMapping(value = "/add")
    @ApiOperation(value = "新增方法调用日志", notes = "新增日志")
    public ApiResult<Object> addMyOperationLog(@RequestBody MethodMessage methodMessage) {
        return new ApiResult<>(methodMessageService.addMyOperationLog(methodMessage));
    }

    @PostMapping(value = "/show")
    @ApiOperation(value = "列表查询", notes = "列表查询")
    public ApiResult<DataAndTotal> showMyOperationLog(@RequestBody MethodMessageDTO messageDTO) {
        Page<MethodMessage> result = methodMessageService.show(messageDTO);
        return new ApiResult<>(new DataAndTotal(result.getContent(),result.getTotalElements()));
    }

    @PostMapping(value = "/getByUserName")
    @ApiOperation(value = "通过用户名查询日志信息", notes = "通过用户名查询日志信息")
    public ApiResult<DataAndTotal> getByUserName(@RequestBody String userName){
        Page<MethodMessage> result = methodMessageService.getByUserName(userName);
        return new ApiResult<>(new DataAndTotal(result.getContent(),result.getTotalElements()));
    }

    @PostMapping(value = "getByLogValue")
    @ApiOperation(value = "通过日志注解的value值查询日志信息",tags = "通过日志注解的value值查询日志信息")
    public ApiResult<DataAndTotal> getByLogValue(String logValue){
        Page<MethodMessage> result = methodMessageService.getByLogValue(logValue);
        return new ApiResult<>(new DataAndTotal(result.getContent(),result.getTotalElements()));
    }

}
