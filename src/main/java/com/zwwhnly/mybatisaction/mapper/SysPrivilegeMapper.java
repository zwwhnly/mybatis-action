package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

public interface SysPrivilegeMapper {
    @SelectProvider(type = SysPrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
