package com.ruoyi.web.controller.database;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.database.domain.ProductDepot;
import com.ruoyi.database.service.IProductDepotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库物品数量管理Controller
 * 
 * @author 张旭
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/productDepot")
public class ProductDepotController extends BaseController
{
    @Autowired
    private IProductDepotService productDepotService;




    /**
     * 查询仓库物品数量管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:productDepot:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductDepot productDepot)
    {
        startPage();
        List<ProductDepot> list = productDepotService.selectProductDepotList(productDepot);
        return getDataTable(list);
    }

    /**
     * 导出仓库物品数量管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:productDepot:export')")
    @Log(title = "仓库物品数量管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductDepot productDepot)
    {
        List<ProductDepot> list = productDepotService.selectProductDepotList(productDepot);
        ExcelUtil<ProductDepot> util = new ExcelUtil<ProductDepot>(ProductDepot.class);
        util.exportExcel(response, list, "仓库物品数量管理数据");
    }

    /**
     * 获取仓库物品数量管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:productDepot:query')")
    @GetMapping(value = "/{productDepotId}")
    public AjaxResult getInfo(@PathVariable("productDepotId") Long productDepotId)
    {
        return AjaxResult.success(productDepotService.selectProductDepotByProductDepotId(productDepotId));
    }

    /**
     * 新增仓库物品数量管理
     */
    @PreAuthorize("@ss.hasPermi('database:productDepot:add')")
    @Log(title = "仓库物品数量管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductDepot productDepot)
    {
        return toAjax(productDepotService.insertProductDepot(productDepot));
    }

    /**
     * 修改仓库物品数量管理
     */
    @PreAuthorize("@ss.hasPermi('database:productDepot:edit')")
    @Log(title = "仓库物品数量管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductDepot productDepot)
    {
        return toAjax(productDepotService.updateProductDepot(productDepot));
    }

    /**
     * 删除仓库物品数量管理
     */
    @PreAuthorize("@ss.hasPermi('database:productDepot:remove')")
    @Log(title = "仓库物品数量管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productDepotIds}")
    public AjaxResult remove(@PathVariable Long[] productDepotIds)
    {
        return toAjax(productDepotService.deleteProductDepotByProductDepotIds(productDepotIds));
    }
}
