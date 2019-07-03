package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class SysPrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysPrivilegeMapper sysPrivilegeMapper = sqlSession.getMapper(SysPrivilegeMapper.class);
            SysPrivilege sysPrivilege = sysPrivilegeMapper.selectById(1L);

            Assert.assertNotNull(sysPrivilege);
            Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());
        } finally {
            sqlSession.close();
        }
    }
}
