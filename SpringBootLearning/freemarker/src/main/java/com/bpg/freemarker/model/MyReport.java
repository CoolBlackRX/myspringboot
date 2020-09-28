package com.bpg.freemarker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhaohq
 * @date 2020/9/23
 **/
@Data
@AllArgsConstructor
public class MyReport {
    private String workOrderNumber;
    private String productCategoryCode;
    private String projectUser;
    private String unQualifiedItem;
    private String notifiedUnit;
    private String unQualifiedReportDescription;
    private String qualityInspector;
    private String inspectTime;
    private String responsiblePerson;
    private String verifyTime;
    private String unQualifiedReason;
    private String unQualifiedReasonSign;
    private String unQualifiedReasonSignDate;
    private String suggestionsAndProgrammes;
    private String suggestionSign;
    private String suggestionSignDate;

    public MyReport(){
        this.workOrderNumber = "MyQQ:1718539208";
        this.productCategoryCode = "RepairTools";
        this.projectUser = "BPG";
        this.unQualifiedItem = "卫生检查";
        this.notifiedUnit = "后勤集团";
        this.unQualifiedReportDescription = "赵汉青座位底下有垃圾";
        this.qualityInspector = "zhaohq Inspector";
        this.inspectTime = getDate();
        this.responsiblePerson = "zhaohq Verify";
        this.verifyTime = getDate();
        this.unQualifiedReason = "zhaohq乱丢垃圾，拖出去铡了";
        this.unQualifiedReasonSign = "zhaohq ReasonSign";
        this.unQualifiedReasonSignDate = getDate();
        this.suggestionsAndProgrammes = "zhaohq快来清理垃圾";
        this.suggestionSign = "zhaohq Sign";
        this.suggestionSignDate = getDate();
    }


    public String getDate(){
        return LocalDateTime.now().toString();
    }
}
