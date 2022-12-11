package com.ruoyi.database.service.impl;

import java.util.List;

import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.PurchaseOrderMapper;
import com.ruoyi.database.domain.PurchaseOrder;
import com.ruoyi.database.service.IPurchaseOrderService;

/**
 * 采购订单Service业务层处理
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService 
{
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;


    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 查询采购订单
     * 
     * @param purchaseOrderId 采购订单主键
     * @return 采购订单
     */
    @Override
    public PurchaseOrder selectPurchaseOrderByPurchaseOrderId(Long purchaseOrderId)
    {
        return purchaseOrderMapper.selectPurchaseOrderByPurchaseOrderId(purchaseOrderId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param purchaseOrder 采购订单
     * @return 采购订单
     */
    @Override
    public List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder)
    {
        return purchaseOrderMapper.selectPurchaseOrderList(purchaseOrder);
    }

    /**
     * 新增采购订单
     * 
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder)
    {
        purchaseOrder.setPurchaseOrderId(snowFlakeUtil.nextId());

        return purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);
    }

    /**
     * 修改采购订单
     * 
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    public int updatePurchaseOrder(PurchaseOrder purchaseOrder)
    {
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }

    /**
     * 批量删除采购订单
     * 
     * @param purchaseOrderIds 需要删除的采购订单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByPurchaseOrderIds(Long[] purchaseOrderIds)
    {
        return purchaseOrderMapper.deletePurchaseOrderByPurchaseOrderIds(purchaseOrderIds);
    }

    /**
     * 删除采购订单信息
     * 
     * @param purchaseOrderId 采购订单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByPurchaseOrderId(Long purchaseOrderId)
    {
        return purchaseOrderMapper.deletePurchaseOrderByPurchaseOrderId(purchaseOrderId);
    }
}
