package com.ruoyi.database.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.SaleOrderMapper;
import com.ruoyi.database.domain.SaleOrder;
import com.ruoyi.database.service.ISaleOrderService;

/**
 * 出售订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-11
 */
@Service
public class SaleOrderServiceImpl implements ISaleOrderService 
{
    @Autowired
    private SaleOrderMapper saleOrderMapper;

    /**
     * 查询出售订单
     * 
     * @param saleOrderId 出售订单主键
     * @return 出售订单
     */
    @Override
    public SaleOrder selectSaleOrderBySaleOrderId(Long saleOrderId)
    {
        return saleOrderMapper.selectSaleOrderBySaleOrderId(saleOrderId);
    }

    /**
     * 查询出售订单列表
     * 
     * @param saleOrder 出售订单
     * @return 出售订单
     */
    @Override
    public List<SaleOrder> selectSaleOrderList(SaleOrder saleOrder)
    {
        return saleOrderMapper.selectSaleOrderList(saleOrder);
    }

    /**
     * 新增出售订单
     * 
     * @param saleOrder 出售订单
     * @return 结果
     */
    @Override
    public int insertSaleOrder(SaleOrder saleOrder)
    {
        return saleOrderMapper.insertSaleOrder(saleOrder);
    }

    /**
     * 修改出售订单
     * 
     * @param saleOrder 出售订单
     * @return 结果
     */
    @Override
    public int updateSaleOrder(SaleOrder saleOrder)
    {
        return saleOrderMapper.updateSaleOrder(saleOrder);
    }

    /**
     * 批量删除出售订单
     * 
     * @param saleOrderIds 需要删除的出售订单主键
     * @return 结果
     */
    @Override
    public int deleteSaleOrderBySaleOrderIds(Long[] saleOrderIds)
    {
        return saleOrderMapper.deleteSaleOrderBySaleOrderIds(saleOrderIds);
    }

    /**
     * 删除出售订单信息
     * 
     * @param saleOrderId 出售订单主键
     * @return 结果
     */
    @Override
    public int deleteSaleOrderBySaleOrderId(Long saleOrderId)
    {
        return saleOrderMapper.deleteSaleOrderBySaleOrderId(saleOrderId);
    }
}
