package com.ruoyi.database.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.ProductMapper;
import com.ruoyi.database.domain.Product;
import com.ruoyi.database.service.IProductService;

/**
 * 物品信息管理Service业务层处理
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 查询物品信息管理
     * 
     * @param productId 物品信息管理主键
     * @return 物品信息管理
     */
    @Override
    public Product selectProductByProductId(Long productId)
    {
        return productMapper.selectProductByProductId(productId);
    }

    /**
     * 查询物品信息管理列表
     * 
     * @param product 物品信息管理
     * @return 物品信息管理
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增物品信息管理
     * 
     * @param product 物品信息管理
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setProductId(snowFlakeUtil.nextId());

        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改物品信息管理
     * 
     * @param product 物品信息管理
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除物品信息管理
     * 
     * @param productIds 需要删除的物品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductIds(Long[] productIds)
    {
        return productMapper.deleteProductByProductIds(productIds);
    }

    /**
     * 删除物品信息管理信息
     * 
     * @param productId 物品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductId(Long productId)
    {
        return productMapper.deleteProductByProductId(productId);
    }
}
