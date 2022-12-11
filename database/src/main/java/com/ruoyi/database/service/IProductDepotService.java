package com.ruoyi.database.service;

import java.util.List;
import com.ruoyi.database.domain.ProductDepot;

/**
 * 仓库物品数量管理Service接口
 * 
 * @author 张旭
 * @date 2022-12-05
 */
public interface IProductDepotService 
{
    /**
     * 查询仓库物品数量管理
     * 
     * @param productDepotId 仓库物品数量管理主键
     * @return 仓库物品数量管理
     */
    public ProductDepot selectProductDepotByProductDepotId(Long productDepotId);

    /**
     * 查询仓库物品数量管理列表
     * 
     * @param productDepot 仓库物品数量管理
     * @return 仓库物品数量管理集合
     */
    public List<ProductDepot> selectProductDepotList(ProductDepot productDepot);

    /**
     * 新增仓库物品数量管理
     * 
     * @param productDepot 仓库物品数量管理
     * @return 结果
     */
    public int insertProductDepot(ProductDepot productDepot);

    /**
     * 修改仓库物品数量管理
     * 
     * @param productDepot 仓库物品数量管理
     * @return 结果
     */
    public int updateProductDepot(ProductDepot productDepot);

    /**
     * 批量删除仓库物品数量管理
     * 
     * @param productDepotIds 需要删除的仓库物品数量管理主键集合
     * @return 结果
     */
    public int deleteProductDepotByProductDepotIds(Long[] productDepotIds);

    /**
     * 删除仓库物品数量管理信息
     * 
     * @param productDepotId 仓库物品数量管理主键
     * @return 结果
     */
    public int deleteProductDepotByProductDepotId(Long productDepotId);
}
