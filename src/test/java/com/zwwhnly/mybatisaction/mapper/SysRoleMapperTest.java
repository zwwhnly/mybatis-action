package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SysRoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            SysRole sysRole = sysRoleMapper.selectById(1L);

            Assert.assertNotNull(sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdUseResults() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            SysRole sysRole = sysRoleMapper.selectByIdUseResults(1L);

            Assert.assertNotNull(sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRole> sysRoleList = sysRoleMapper.selectAll();

            Assert.assertNotNull(sysRoleList);
            Assert.assertTrue(sysRoleList.size() > 0);
            Assert.assertNotNull(sysRoleList.get(0).getRoleName());
        } finally {
            sqlSession.close();
        }
    }
}
