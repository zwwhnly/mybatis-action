package com.zwwhnly.mybatisaction.model;

public class SysRoleExtend extends SysRole {
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
