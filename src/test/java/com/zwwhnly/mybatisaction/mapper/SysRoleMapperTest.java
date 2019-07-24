package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysPrivilege;
import com.zwwhnly.mybatisaction.model.SysRole;
import com.zwwhnly.mybatisaction.model.SysRoleExtend;
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

            List<SysRoleExtend> sysRoleExtendList = sysRoleMapper.selectAllRoleAndPrivileges();

            Assert.assertNotNull(sysRoleExtendList);
            Assert.assertTrue(sysRoleExtendList.size() > 0);
            Assert.assertNotNull(sysRoleExtendList.get(0).getRoleName());
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

            // 获取用户id为1的角色
            List<SysRoleExtend> sysRoleExtendList = sysRoleMapper.selectRoleByUserIdChoose(1L);
            for (SysRoleExtend item : sysRoleExtendList) {
                System.out.println("角色名：" + item.getRoleName());
                if (item.getId().equals(1L)) {
                    // 第一个角色是启用的，所以存在权限信息
                    Assert.assertNotNull(item.getSysPrivilegeList());
                } else if (item.getId().equals(2L)) {
                    // 第二个角色是禁用的，所以权限为null
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

            // 先查询出id=2的角色，然后修改角色的enabled值为disabled
            SysRole sysRole = sysRoleMapper.selectById(2L);
            Assert.assertEquals(Enabled.enabled, sysRole.getEnabled());

            // 修改角色的enabled为disabled
            sysRole.setEnabled(Enabled.disabled);

            if (sysRole.getEnabled() == Enabled.disabled || sysRole.getEnabled() == Enabled.enabled) {
                sysRoleMapper.updateById(sysRole);
            } else {
                throw new Exception("无效的enabled值");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
