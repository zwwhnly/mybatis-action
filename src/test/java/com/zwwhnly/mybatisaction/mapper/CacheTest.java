package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysUser;
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
}
