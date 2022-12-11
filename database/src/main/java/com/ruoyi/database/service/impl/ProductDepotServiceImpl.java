package com.ruoyi.database.service.impl;

import java.util.List;

import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.ProductDepotMapper;
import com.ruoyi.database.domain.ProductDepot;
import com.ruoyi.database.service.IProductDepotService;

/**
 * 仓库物品数量管理Service业务层处理
 * 
 * @author 张旭
 * @date 2022-12-05
 */
@Service
public class ProductDepotServiceImpl implements IProductDepotService 
{
    @Autowired
    private ProductDepotMapper productDepotMapper;


    @Autowired
    private SnowFlakeUtil snowFlakeUtil;
    /**
     * 查询仓库物品数量管理
     * 
     * @param productDepotId 仓库物品数量管理主键
     * @return 仓库物品数量管理
     */
    @Override
    public ProductDepot selectProductDepotByProductDepotId(Long productDepotId)
    {
        return productDepotMapper.selectProductDepotByProductDepotId(productDepotId);
    }

    /**
     * 查询仓库物品数量管理列表
     * 
     * @param productDepot 仓库物品数量管理
     * @return 仓库物品数量管理
     */
    @Override
    public List<ProductDepot> selectProductDepotList(ProductDepot productDepot)
    {
        return productDepotMapper.selectProductDepotList(productDepot);
    }

    /**
     * 新增仓库物品数量管理
     * 
     * @param productDepot 仓库物品数量管理
     * @return 结果
     */
    @Override
    public int insertProductDepot(ProductDepot productDepot)
    {
        productDepot.setProductDepotId(snowFlakeUtil.nextId());
        return productDepotMapper.insertProductDepot(productDepot);
    }

    /**
     * 修改仓库物品数量管理
     * 
     * @param productDepot 仓库物品数量管理
     * @return 结果
     */
    @Override
    public int updateProductDepot(ProductDepot productDepot)
    {
        return productDepotMapper.updateProductDepot(productDepot);
    }

    /**
     * 批量删除仓库物品数量管理
     * 
     * @param productDepotIds 需要删除的仓库物品数量管理主键
     * @return 结果
     */
    @Override
    public int deleteProductDepotByProductDepotIds(Long[] productDepotIds)
    {
        return productDepotMapper.deleteProductDepotByProductDepotIds(productDepotIds);
    }

    /**
     * 删除仓库物品数量管理信息
     * 
     * @param productDepotId 仓库物品数量管理主键
     * @return 结果
     */
    @Override
    public int deleteProductDepotByProductDepotId(Long productDepotId)
    {
        return productDepotMapper.deleteProductDepotByProductDepotId(productDepotId);
    }
}
