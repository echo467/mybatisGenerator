package com.tinymall.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.tinymall.demo.mapper.PmsBrandMapper;
import com.tinymall.demo.model.PmsBrand;
import com.tinymall.demo.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Transactional
    @Override
    public List<PmsBrand> getAllBrand(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.getBrandList();
    }

    @Transactional
    @Override
    public PmsBrand getBrandById(Long Id) {
        return pmsBrandMapper.selectByPrimaryKey(Id);
    }

    @Transactional
    @Override
    public boolean addBrand(PmsBrand pmsBrand) {
      if(pmsBrand.getId()!=null) {
          try {
              int effectedNum = pmsBrandMapper.insertSelective(pmsBrand);
              if (effectedNum > 0) {
                  return true;
              } else {
                  throw new RuntimeException("添加失败");
              }
          } catch (Exception e) {
              throw new RuntimeException("添加失败:" + e.toString());
          }
      }else{
              throw  new RuntimeException("主键不能为空");
          }
    }

    @Transactional
    @Override
    public boolean deleteBrandById(Long Id) {
        if(Id>0) {
            try {
                int effectedNum = pmsBrandMapper.deleteByPrimaryKey(Id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败:" + e.toString());
            }
        }else{
            throw  new RuntimeException("主键不能为空");
        }
    }

    @Transactional
    @Override
    public boolean updateBrand(PmsBrand pmsBrand) {
        if(pmsBrand.getId()!=null) {
            try {
                int effectedNum = pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败:" + e.toString());
            }
        }else{
            throw  new RuntimeException("主键不能为空");
        }
    }
}
