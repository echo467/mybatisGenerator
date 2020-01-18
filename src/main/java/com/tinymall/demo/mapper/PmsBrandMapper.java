package com.tinymall.demo.mapper;

import com.tinymall.demo.model.PmsBrand;

import java.util.List;

public interface PmsBrandMapper {
    List<PmsBrand> getBrandList();

    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}