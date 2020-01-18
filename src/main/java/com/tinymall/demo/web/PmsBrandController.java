package com.tinymall.demo.web;

import com.tinymall.demo.model.PmsBrand;
import com.tinymall.demo.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(tags = "PmsBrandController" )
@RestController
@RequestMapping("/PmsBrand")
public class PmsBrandController {
   @Autowired
    private PmsBrandService pmsBrandService;

   @ApiOperation("获取品牌列表")
   @RequestMapping(value = "/ListAllBrand",method = RequestMethod.GET)
    private Map<String,Object>ListAllBrand(Integer pageNum,Integer pageSize){
       Map<String,Object> modelMap = new HashMap<String, Object>();
       List<PmsBrand> brandList=new ArrayList<>();

       brandList=pmsBrandService.getAllBrand(pageNum, pageSize);
       modelMap.put("brandList",brandList);
       return modelMap;
   }

   @ApiOperation("通过id获取品牌")
   @RequestMapping(value = "/getBrandById",method = RequestMethod.GET)
    private Map<String,Object> getBrandById(Long Id){
       Map<String,Object> modelMap=new HashMap<String, Object>();
       modelMap.put("success",pmsBrandService.getBrandById(Id));
       return modelMap;
   }

   @ApiOperation("添加品牌")
   @RequestMapping(value = "/addBrand",method = RequestMethod.POST)
    private Map<String,Object> addBrand(PmsBrand pmsBrand){
       Map<String,Object> modelMap=new HashMap<String, Object>();
       modelMap.put("success",pmsBrandService.addBrand(pmsBrand));
       return modelMap;
   }

   @ApiOperation("删除品牌")
   @RequestMapping(value = "/deleteBrandById",method = RequestMethod.POST)
    private Map<String, Object>deleteBrandById(Long Id){
       Map<String,Object>modelMap=new HashMap<String, Object>();
       modelMap.put("success",pmsBrandService.deleteBrandById(Id));
       return modelMap;
   }

   @ApiOperation("更新品牌")
   @RequestMapping(value = "/updateBrand",method = RequestMethod.POST)
    private  Map<String,Object>updateBrand(PmsBrand pmsBrand){
       Map<String,Object>modelMap=new HashMap<String, Object>();
       modelMap.put("success",pmsBrandService.updateBrand(pmsBrand));
       return modelMap;
   }
}
