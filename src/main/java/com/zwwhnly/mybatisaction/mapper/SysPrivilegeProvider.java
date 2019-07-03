package com.zwwhnly.mybatisaction.mapper;

import org.apache.ibatis.jdbc.SQL;

public class SysPrivilegeProvider {
    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id,privilege_name,privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
