package com.bpg.log.spring.boot.starter.enums;

/**
 * @author zhaohq
 * @date 2020/10/9
 **/
public enum OperationType {
    /**
     * 入库
     */
    IN_STORAGE("入库"),
    /**
     * 出库
     */
    OUT_STORAGE("出库"),
    /**
     * 基础数据
     */
    BASE_DATA("基础数据"),
    /**
     * 库内管理
     */
    STORAGE_MANAGEMENT("库内管理"),
    /**
     * NULL
     */
    DEFAULT("");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String string) {
        this.value = string;
    }
}
