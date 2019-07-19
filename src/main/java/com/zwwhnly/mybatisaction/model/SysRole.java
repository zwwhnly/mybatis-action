package com.zwwhnly.mybatisaction.model;

import com.zwwhnly.mybatisaction.type.Enabled;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色表
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;

    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 有效标志
     */
    private Integer enabled;

    /**
     * 有效标志
     */
    //private Enabled enabled;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建信息
     */
    private CreateInfo createInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /*public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }*/

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public CreateInfo getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(CreateInfo createInfo) {
        this.createInfo = createInfo;
    }
}
