package com.zwwhnly.mybatisaction.model;

import java.util.List;

public class SysRoleExtend extends SysRole {
    private SysUser sysUser;
    /**
     * 角色包含的权限列表
     */
    private List<SysPrivilege> sysPrivilegeList;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<SysPrivilege> getSysPrivilegeList() {
        return sysPrivilegeList;
    }

    public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
        this.sysPrivilegeList = sysPrivilegeList;
    }
}
