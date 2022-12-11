package com.ruoyi.web.controller.database;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.database.domain.Product;
import com.ruoyi.database.service.IProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物品信息管理Controller
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/product")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;

    /**
     * 查询物品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出物品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:product:export')")
    @Log(title = "物品信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        util.exportExcel(response, list, "物品信息管理数据");
    }

    /**
     * 获取物品信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return AjaxResult.success(productService.selectProductByProductId(productId));
    }

    /**
     * 新增物品信息管理
     */
    @PreAuthorize("@ss.hasPermi('database:product:add')")
    @Log(title = "物品信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改物品信息管理
     */
    @PreAuthorize("@ss.hasPermi('database:product:edit')")
    @Log(title = "物品信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除物品信息管理
     */
    @PreAuthorize("@ss.hasPermi('database:product:remove')")
    @Log(title = "物品信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(productService.deleteProductByProductIds(productIds));
    }
}
