package com.zwwhnly.mybatisaction.mapper;

import com.zwwhnly.mybatisaction.model.Country;

import java.util.List;

public interface CountryMapper {
    /**
     * 查询全部用户
     *
     * @return
     */
    List<Country> selectAll();
}
