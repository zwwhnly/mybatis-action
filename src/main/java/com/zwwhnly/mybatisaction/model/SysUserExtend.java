package com.zwwhnly.mybatisaction.model;

import java.util.List;

public class SysUserExtend extends SysUser {
    /**
     * 用户角色
     */
    private SysRole sysRole;

    /**
     * 用户的角色集合
     */
    private List<SysRoleExtend> sysRoleList;

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public List<SysRoleExtend> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRoleExtend> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }
}
