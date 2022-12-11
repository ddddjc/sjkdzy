package com.ruoyi.database.service;

import java.util.List;
import com.ruoyi.database.domain.Brand;

/**
 * 品牌管理Service接口
 * 
 * @author Tinaliasd
 * @date 2022-12-05
 */
public interface IBrandService 
{
    /**
     * 查询品牌管理
     * 
     * @param brandId 品牌管理主键
     * @return 品牌管理
     */
    public Brand selectBrandByBrandId(Long brandId);

    /**
     * 查询品牌管理列表
     * 
     * @param brand 品牌管理
     * @return 品牌管理集合
     */
    public List<Brand> selectBrandList(Brand brand);

    /**
     * 新增品牌管理
     * 
     * @param brand 品牌管理
     * @return 结果
     */
    public int insertBrand(Brand brand);

    /**
     * 修改品牌管理
     * 
     * @param brand 品牌管理
     * @return 结果
     */
    public int updateBrand(Brand brand);

    /**
     * 批量删除品牌管理
     * 
     * @param brandIds 需要删除的品牌管理主键集合
     * @return 结果
     */
    public int deleteBrandByBrandIds(Long[] brandIds);

    /**
     * 删除品牌管理信息
     * 
     * @param brandId 品牌管理主键
     * @return 结果
     */
    public int deleteBrandByBrandId(Long brandId);
}
