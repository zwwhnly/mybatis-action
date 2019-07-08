package com.zwwhnly.mybatisaction.model;

import java.util.List;

public class SysRoleExtend extends SysRole {
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
