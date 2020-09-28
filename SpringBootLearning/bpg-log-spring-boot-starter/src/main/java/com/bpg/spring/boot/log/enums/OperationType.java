package com.bpg.spring.boot.log.enums;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
public enum OperationType {
    /**
     * 被操作的单元
     */
    UNKNOWN("unknown"),
    DELETE("delete"),
    SELECT("select"),
    UPDATE("update"),
    INSERT("insert");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String s) {
        this.value = s;
    }
}
