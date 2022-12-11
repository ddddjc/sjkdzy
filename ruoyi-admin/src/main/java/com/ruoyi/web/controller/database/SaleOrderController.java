package com.ruoyi.web.controller.database;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.database.domain.SaleOrder;
import com.ruoyi.database.service.ISaleOrderService;
import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 出售订单Controller
 *
 * @author ruoyi
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/saleOrder")
public class SaleOrderController extends BaseController
{
    @Autowired
    private ISaleOrderService saleOrderService;




    /**
     * 查询出售订单列表
     */
    @PreAuthorize("@ss.hasPermi('database:saleOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleOrder saleOrder)
    {
        startPage();
        List<SaleOrder> list = saleOrderService.selectSaleOrderList(saleOrder);
        return getDataTable(list);
    }

    /**
     * 导出出售订单列表
     */
    @PreAuthorize("@ss.hasPermi('database:saleOrder:export')")
    @Log(title = "出售订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SaleOrder saleOrder)
    {
        List<SaleOrder> list = saleOrderService.selectSaleOrderList(saleOrder);
        ExcelUtil<SaleOrder> util = new ExcelUtil<SaleOrder>(SaleOrder.class);
        util.exportExcel(response, list, "出售订单数据");
    }

    /**
     * 获取出售订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:saleOrder:query')")
    @GetMapping(value = "/{saleOrderId}")
    public AjaxResult getInfo(@PathVariable("saleOrderId") Long saleOrderId)
    {
        return AjaxResult.success(saleOrderService.selectSaleOrderBySaleOrderId(saleOrderId));
    }

    /**
     * 新增出售订单
     */
    @PreAuthorize("@ss.hasPermi('database:saleOrder:add')")
    @Log(title = "出售订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SaleOrder saleOrder)
    {
        return toAjax(saleOrderService.insertSaleOrder(saleOrder));
    }

    /**
     * 修改出售订单
     */
    @PreAuthorize("@ss.hasPermi('database:saleOrder:edit')")
    @Log(title = "出售订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SaleOrder saleOrder)
    {
        return toAjax(saleOrderService.updateSaleOrder(saleOrder));
    }

    /**
     * 删除出售订单
     */
    @PreAuthorize("@ss.hasPermi('database:saleOrder:remove')")
    @Log(title = "出售订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{saleOrderIds}")
    public AjaxResult remove(@PathVariable Long[] saleOrderIds)
    {
        return toAjax(saleOrderService.deleteSaleOrderBySaleOrderIds(saleOrderIds));
    }
}
