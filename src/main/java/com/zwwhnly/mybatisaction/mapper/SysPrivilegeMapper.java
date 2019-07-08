package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SysPrivilegeMapper {
    @SelectProvider(type = SysPrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);

    /**
     * 获取角色包含的所有权限信息
     *
     * @param roleId
     * @return
     */
    List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}
