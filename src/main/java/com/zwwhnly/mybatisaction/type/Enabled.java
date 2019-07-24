package com.zwwhnly.mybatisaction.type;

public enum Enabled {

    /**
     * 启用
     */
    enabled(1),

    /**
     * 禁用
     */
    disabled(0);

    private final int value;

    private Enabled(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
