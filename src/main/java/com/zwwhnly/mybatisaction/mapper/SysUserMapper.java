package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.SysRole;
import com.zwwhnly.mybatisaction.model.SysUser;
import com.zwwhnly.mybatisaction.model.SysUserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户id获取角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 新增用户-使用useGeneratedKeys方式
     *
     * @param sysUser
     * @return
     */
    int insertUseGeneratedKeys(SysUser sysUser);

    /**
     * 新增用户-使用selectKey方式
     *
     * @param sysUser
     * @return
     */
    int insertUseSelectKey(SysUser sysUser);

    /**
     * 根据主键更新
     *
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据对象的主键删除
     *
     * @param sysUser
     * @return
     */
    int deleteBySysUser(SysUser sysUser);

    /**
     * 根据用户id和角色的enabled状态获取用户的角色
     *
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);

    /**
     * 根据用户id和角色的enabled状态获取用户的角色
     *
     * @param user
     * @param role
     * @return
     */
    List<SysRole> selectRolesByUserAndRole(@Param("user") SysUser user, @Param("role") SysRole role);

    /**
     * 根据动态条件查询用户信息
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUser(SysUser sysUser);

    /**
     * 根据动态条件查询用户信息(使用Where标签)
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUserWhere(SysUser sysUser);

    /**
     * 根据主键选择性更新用户信息
     *
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);

    /**
     * 根据主键选择性更新用户信息(使用Set标签)
     *
     * @param sysUser
     * @return
     */
    int updateByIdSelectiveSet(SysUser sysUser);

    /**
     * 根据传入的参数值动态插入列
     *
     * @param sysUser
     * @return
     */
    int insertSelective(SysUser sysUser);

    /**
     * 根据用户id或用户名查询
     *
     * @param sysUser
     * @return
     */
    SysUser selectByIdOrUserName(SysUser sysUser);

    /**
     * 根据用户id集合查询用户
     *
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(@Param("idList") List<Long> idList);

    /**
     * 根据用户id数组查询用户
     *
     * @param idArray
     * @return
     */
    List<SysUser> selectByIdArray(@Param("idArray") Long[] idArray);

    /**
     * 批量插入用户信息
     *
     * @param userList
     * @return
     */
    int insertList(List<SysUser> userList);

    /**
     * 通过Map更新列
     *
     * @param map
     * @return
     */
    int updateByMap(@Param("userMap") Map<String, Object> map);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     *
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleById(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     *
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdResultMap(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息，嵌套查询方式
     *
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdSelect(Long id);

    /**
     * 获取所有的用户以及对应的所有角色
     *
     * @return
     */
    List<SysUserExtend> selectAllUserAndRoles();

    /**
     * 通过嵌套查询获取指定用户的信息以及用户的角色和权限信息
     *
     * @param id
     * @return
     */
    SysUserExtend selectAllUserAndRolesSelect(Long id);

    /**
     * 使用存储过程查询用户信息
     *
     * @param sysUser
     */
    void selectUserById(SysUser sysUser);

    /**
     * 使用存储过程分页查询
     *
     * @param params
     * @return
     */
    List<SysUser> selectUserPage(Map<String, Object> params);

    /**
     * 保存用户信息和角色关联信息
     *
     * @param sysUser
     * @param roleIds
     * @return
     */
    int insertUserAndRoles(@Param("sysUser") SysUser sysUser, @Param("roleIds") String roleIds);

    /**
     * 根据用户id删除用户和用户的角色信息
     *
     * @param id
     * @return
     */
    int deleteUserById(Long id);
}
