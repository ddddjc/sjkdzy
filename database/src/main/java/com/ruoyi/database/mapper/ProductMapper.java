package com.ruoyi.database.mapper;

import java.util.List;
import com.ruoyi.database.domain.Product;

/**
 * 物品信息管理Mapper接口
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public interface ProductMapper 
{
    /**
     * 查询物品信息管理
     * 
     * @param productId 物品信息管理主键
     * @return 物品信息管理
     */
    public Product selectProductByProductId(Long productId);

    /**
     * 查询物品信息管理列表
     * 
     * @param product 物品信息管理
     * @return 物品信息管理集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增物品信息管理
     * 
     * @param product 物品信息管理
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改物品信息管理
     * 
     * @param product 物品信息管理
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除物品信息管理
     * 
     * @param productId 物品信息管理主键
     * @return 结果
     */
    public int deleteProductByProductId(Long productId);

    /**
     * 批量删除物品信息管理
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByProductIds(Long[] productIds);
}
