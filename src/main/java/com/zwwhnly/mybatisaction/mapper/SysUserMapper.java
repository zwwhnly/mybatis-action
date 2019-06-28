package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     *
     * @return
     */
    List<SysUser> selectAll();
}
