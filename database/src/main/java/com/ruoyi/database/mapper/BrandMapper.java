package com.ruoyi.database.mapper;

import java.util.List;
import com.ruoyi.database.domain.Brand;
import com.ruoyi.database.domain.Product;

/**
 * 品牌管理Mapper接口
 * 
 * @author Tinaliasd
 * @date 2022-12-05
 */
public interface BrandMapper 
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
     * 删除品牌管理
     * 
     * @param brandId 品牌管理主键
     * @return 结果
     */
    public int deleteBrandByBrandId(Long brandId);

    /**
     * 批量删除品牌管理
     * 
     * @param brandIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBrandByBrandIds(Long[] brandIds);

    /**
     * 批量删除物品信息管理
     * 
     * @param brandIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByBrandIds(Long[] brandIds);
    
    /**
     * 批量新增物品信息管理
     * 
     * @param productList 物品信息管理列表
     * @return 结果
     */
    public int batchProduct(List<Product> productList);
    

    /**
     * 通过品牌管理主键删除物品信息管理信息
     * 
     * @param brandId 品牌管理ID
     * @return 结果
     */
    public int deleteProductByBrandId(Long brandId);
}
