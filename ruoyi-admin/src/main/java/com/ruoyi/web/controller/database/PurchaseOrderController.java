package com.ruoyi.web.controller.database;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.database.domain.PurchaseOrder;
import com.ruoyi.database.service.IPurchaseOrderService;
import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 采购订单Controller
 *
 * @author tinaliasd
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/purchaseOrder")
public class PurchaseOrderController extends BaseController
{
    @Autowired
    private IPurchaseOrderService purchaseOrderService;




    /**
     * 查询采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('database:purchaseOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseOrder purchaseOrder)
    {
        startPage();
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('database:purchaseOrder:export')")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchaseOrder purchaseOrder)
    {
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        ExcelUtil<PurchaseOrder> util = new ExcelUtil<PurchaseOrder>(PurchaseOrder.class);
        util.exportExcel(response, list, "采购订单数据");
    }

    /**
     * 获取采购订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:purchaseOrder:query')")
    @GetMapping(value = "/{purchaseOrderId}")
    public AjaxResult getInfo(@PathVariable("purchaseOrderId") Long purchaseOrderId)
    {
        return AjaxResult.success(purchaseOrderService.selectPurchaseOrderByPurchaseOrderId(purchaseOrderId));
    }

    /**
     * 新增采购订单
     */
    @PreAuthorize("@ss.hasPermi('database:purchaseOrder:add')")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.insertPurchaseOrder(purchaseOrder));
    }

    /**
     * 修改采购订单
     */
    @PreAuthorize("@ss.hasPermi('database:purchaseOrder:edit')")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.updatePurchaseOrder(purchaseOrder));
    }

    /**
     * 删除采购订单
     */
    @PreAuthorize("@ss.hasPermi('database:purchaseOrder:remove')")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{purchaseOrderIds}")
    public AjaxResult remove(@PathVariable Long[] purchaseOrderIds)
    {
        return toAjax(purchaseOrderService.deletePurchaseOrderByPurchaseOrderIds(purchaseOrderIds));
    }
}
