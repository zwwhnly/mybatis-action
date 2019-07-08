package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysPrivilege;
import com.zwwhnly.mybatisaction.model.SysRole;
import com.zwwhnly.mybatisaction.type.Enabled;
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

    @Test
    public void testSelectAllRoleAndPrivileges() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRole> sysRoleList = sysRoleMapper.selectAllRoleAndPrivileges();

            Assert.assertNotNull(sysRoleList);
            Assert.assertTrue(sysRoleList.size() > 0);
            Assert.assertNotNull(sysRoleList.get(0).getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserId() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRole> sysRoleList = sysRoleMapper.selectRoleByUserId(1L);

            Assert.assertNotNull(sysRoleList);
            Assert.assertTrue(sysRoleList.size() > 0);
            Assert.assertNotNull(sysRoleList.get(0).getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserIdChoose() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            // 将id=2的角色的enabled赋值为0
            SysRole sysRole = sysRoleMapper.selectById(2L);
            sysRole.setEnabled(Enabled.disabled);
            sysRoleMapper.updateById(sysRole);

            List<SysRole> sysRoleList = sysRoleMapper.selectRoleByUserIdChoose(1L);
            for (SysRole item : sysRoleList) {
                System.out.println("角色名：" + item.getRoleName());
                if (item.getId().equals(1L)) {
                    Assert.assertNotNull(item.getSysPrivilegeList());
                } else if (item.getId().equals(2L)) {
                    Assert.assertNull(item.getSysPrivilegeList());
                    continue;
                }
                for (SysPrivilege sysPrivilege : item.getSysPrivilegeList()) {
                    System.out.println("权限名：" + sysPrivilege.getPrivilegeName());
                }
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);

            SysRole sysRole = sysRoleMapper.selectById(2L);
            Assert.assertEquals(Enabled.enabled, sysRole.getEnabled());

            // 修改角色的enabled为disabled
            sysRole.setEnabled(Enabled.disabled);
            sysRoleMapper.updateById(sysRole);

            sysRole = sysRoleMapper.selectById(2L);
            Assert.assertEquals(Enabled.disabled, sysRole.getEnabled());
        } finally {
            sqlSession.close();
        }
    }
}
