package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysRoleMapper {
    @Select("SELECT id,role_name,enabled,create_by,create_time FROM sys_role WHERE id = #{id}")
    SysRole selectById(Long id);

    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT id,role_name,enabled,create_by,create_time FROM sys_role WHERE id = #{id}")
    SysRole selectByIdUseResults(Long id);

    @ResultMap("roleResultMap")
    @Select("SELECT * FROM sys_role")
    List<SysRole> selectAll();

    @Insert({"INSERT INTO sys_role(id, role_name, enabled, create_by, create_time) ",
            "VALUES (#{id},#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    int insert(SysRole sysRole);

    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) ",
            "VALUES (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUseGeneratedKeys(SysRole sysRole);

    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) ",
            "VALUES (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyColumn = "id", keyProperty = "id", resultType = Long.class, before = false)
    int insertUseSelectKey(SysRole sysRole);

    @Update({"UPDATE sys_role ", "SET role_name = #{roleName},enabled = #{enabled},create_by=#{createBy}, ",
            "create_time=#{createTime,jdbcType=TIMESTAMP} ", " WHERE id=#{id}"})
    int updateById(SysRole sysRole);

    @Delete("DELETE FROM sys_role WHERE id = #{id}")
    int deleteById(Long id);

    List<SysRole> selectAllRoleAndPrivileges();
}
