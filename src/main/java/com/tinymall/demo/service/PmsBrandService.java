package com.tinymall.demo.service;

import com.tinymall.demo.model.PmsBrand;


import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> getAllBrand(Integer pageNum, Integer pageSize);

    PmsBrand getBrandById(Long Id);

    boolean addBrand(PmsBrand pmsBrand);

    boolean deleteBrandById(Long Id);

    boolean updateBrand(PmsBrand pmsBrand);


}
