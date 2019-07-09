package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysRole;
import com.zwwhnly.mybatisaction.model.SysUser;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class CacheTest extends BaseMapperTest {
    @Test
    public void testL1Cache() {
        SqlSession sqlSession = getSqlSession();
        SysUser sysUser1 = null;

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            sysUser1 = sysUserMapper.selectById(1L);
            sysUser1.setUserName("New Name");
            SysUser sysUser2 = sysUserMapper.selectById(1L);

            Assert.assertEquals("New Name", sysUser2.getUserName());
            Assert.assertEquals(sysUser1, sysUser2);
        } finally {
            sqlSession.close();
        }

        System.out.println("开启新的sqlSession");
        sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser2 = sysUserMapper.selectById(1L);

            Assert.assertNotEquals("New Name", sysUser2.getUserName());
            Assert.assertNotEquals(sysUser1, sysUser2);

            sysUserMapper.deleteById(2L);
            SysUser sysUser3 = sysUserMapper.selectById(1L);
            Assert.assertNotEquals(sysUser2, sysUser3);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testL2Cache() {
        SqlSession sqlSession = getSqlSession();
        SysRole sysRole1 = null;

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            sysRole1 = sysRoleMapper.selectById(1L);
            sysRole1.setRoleName("New Name");
            SysRole sysRole2 = sysRoleMapper.selectById(1L);

            Assert.assertEquals("New Name", sysRole2.getRoleName());
            Assert.assertEquals(sysRole1, sysRole2);
        } finally {
            sqlSession.close();
        }

        System.out.println("开启新的sqlSession");
        sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            SysRole sysRole2 = sysRoleMapper.selectById(1L);

            Assert.assertEquals("New Name", sysRole2.getRoleName());
            Assert.assertNotEquals(sysRole1, sysRole2);

            SysRole sysRole3 = sysRoleMapper.selectById(1L);
            Assert.assertNotEquals(sysRole2, sysRole3);
        } finally {
            sqlSession.close();
        }
    }
}
