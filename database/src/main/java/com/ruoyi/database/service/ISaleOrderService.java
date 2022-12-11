package com.ruoyi.database.service;

import java.util.List;
import com.ruoyi.database.domain.SaleOrder;

/**
 * 出售订单Service接口
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public interface ISaleOrderService 
{
    /**
     * 查询出售订单
     * 
     * @param saleOrderId 出售订单主键
     * @return 出售订单
     */
    public SaleOrder selectSaleOrderBySaleOrderId(Long saleOrderId);

    /**
     * 查询出售订单列表
     * 
     * @param saleOrder 出售订单
     * @return 出售订单集合
     */
    public List<SaleOrder> selectSaleOrderList(SaleOrder saleOrder);

    /**
     * 新增出售订单
     * 
     * @param saleOrder 出售订单
     * @return 结果
     */
    public int insertSaleOrder(SaleOrder saleOrder);

    /**
     * 修改出售订单
     * 
     * @param saleOrder 出售订单
     * @return 结果
     */
    public int updateSaleOrder(SaleOrder saleOrder);

    /**
     * 批量删除出售订单
     * 
     * @param saleOrderIds 需要删除的出售订单主键集合
     * @return 结果
     */
    public int deleteSaleOrderBySaleOrderIds(Long[] saleOrderIds);

    /**
     * 删除出售订单信息
     * 
     * @param saleOrderId 出售订单主键
     * @return 结果
     */
    public int deleteSaleOrderBySaleOrderId(Long saleOrderId);
}
