package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void testSelectPrivilegeByRoleId() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysPrivilegeMapper sysPrivilegeMapper = sqlSession.getMapper(SysPrivilegeMapper.class);
            List<SysPrivilege> sysPrivilegeList = sysPrivilegeMapper.selectPrivilegeByRoleId(1L);

            Assert.assertTrue(sysPrivilegeList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
}
