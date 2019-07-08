package com.zwwhnly.mybatisaction.model;

import java.util.List;

public class SysUserExtend extends SysUser {
    private List<SysRole> sysRoleList;

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }
}
