package com.zwwhnly.mybatisaction.type;

public enum Enabled {
    /*disabled, // 禁用
    enabled;  // 启用*/
    enabled(1), // 启用
    disabled(0); // 禁用

    private final int value;

    private Enabled(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
