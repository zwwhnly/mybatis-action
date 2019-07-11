package com.zwwhnly.mybatisaction.model;

import java.util.List;

public class SysUserExtend extends SysUser {
    /**
     * 用户角色
     */
    private SysRole sysRole;

    private List<SysRole> sysRoleList;

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}
