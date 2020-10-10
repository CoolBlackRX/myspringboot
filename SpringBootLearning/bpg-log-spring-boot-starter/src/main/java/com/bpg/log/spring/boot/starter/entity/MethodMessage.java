package com.bpg.log.spring.boot.starter.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhaohq
 * @date 2020/9/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "operation-log",type = "log")
@ApiModel(value = "方法操作注解日志对象")
public class MethodMessage {

    @Id
    private Long id;

    @ApiModelProperty(value = "请求路径")
    @Field(type = FieldType.text)
    private String url;

    @ApiModelProperty(value = "方法执行时长")
    @Field(type = FieldType.keyword)
    private String useTime;

    @ApiModelProperty(value = "注解位置")
    @Field(type = FieldType.text)
    private String joinPoint;

    @ApiModelProperty(value = "该方法上的所有注解")
    @Field(type = FieldType.text)
    private String annotations;

    @ApiModelProperty(value = "参数值")
    @Field(type = FieldType.keyword)
    private String args;

    @ApiModelProperty(value = "方法的返回值")
    @Field(type = FieldType.keyword)
    private String methodResultValue;

    @ApiModelProperty(value = "返回值类型")
    @Field(type = FieldType.keyword)
    private String methodRequestType;

    @ApiModelProperty(value = "异常信息")
    @Field(type = FieldType.keyword)
    private MyException exception;

    @ApiModelProperty(value = "操作描述")
    @Field(type = FieldType.text)
    private String value;

    @ApiModelProperty(value = "类别")
    @Field(type = FieldType.keyword)
    private String type;

    @ApiModelProperty(value = "操作用户")
    @Field(type = FieldType.text)
    private String userName;

    @ApiModelProperty(value = "模块名称")
    @Field(type = FieldType.text)
    private String moduleName;

    @ApiModelProperty(value = "界面名称")
    @Field(type = FieldType.text)
    private String pageName;

    @ApiModelProperty(value = "操作时间")
    @Field( type = FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    @Override
    public String toString() {
        return  "======================================================================================" + '\n' +
                "    MethodMessage:" + value + '\n' +
                "======================================================================================" + '\n' +
                "          UseTime: " + useTime + '\n' +
                "         Location: " + joinPoint + '\n' +
                "      Annotations: " + annotations + '\n' +
                "       RequestUrl: " + url + '\n' +
                "             Args: " + args + '\n' +
                "MethodResultValue: " + methodResultValue + '\n' +
                "MethodRequestType: " + methodRequestType + '\n' +
                "      MyException: " + exception + '\n' +
                "======================================================================================" + '\n' +
                "    OperationType: " + type + '\n' +
                "         UserName: " + userName + '\n' +
                "       ModuleName: " + moduleName + '\n' +
                "         PageName: " + pageName + '\n' +
                "======================================================================================";
    }
}
