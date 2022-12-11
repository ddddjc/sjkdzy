package com.ruoyi.web.controller.database;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.database.domain.Provider;
import com.ruoyi.database.service.IProviderService;
import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应者管理Controller
 *
 * @author tinaliasd
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/provider")
public class ProviderController extends BaseController
{
    @Autowired
    private IProviderService providerService;




    /**
     * 查询供应者管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:provider:list')")
    @GetMapping("/list")
    public TableDataInfo list(Provider provider)
    {
        startPage();
        List<Provider> list = providerService.selectProviderList(provider);
        return getDataTable(list);
    }

    /**
     * 导出供应者管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:provider:export')")
    @Log(title = "供应者管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Provider provider)
    {
        List<Provider> list = providerService.selectProviderList(provider);
        ExcelUtil<Provider> util = new ExcelUtil<Provider>(Provider.class);
        util.exportExcel(response, list, "供应者管理数据");
    }

    /**
     * 获取供应者管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:provider:query')")
    @GetMapping(value = "/{providerId}")
    public AjaxResult getInfo(@PathVariable("providerId") Long providerId)
    {
        return AjaxResult.success(providerService.selectProviderByProviderId(providerId));
    }

    /**
     * 新增供应者管理
     */
    @PreAuthorize("@ss.hasPermi('database:provider:add')")
    @Log(title = "供应者管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Provider provider)
    {
        return toAjax(providerService.insertProvider(provider));
    }

    /**
     * 修改供应者管理
     */
    @PreAuthorize("@ss.hasPermi('database:provider:edit')")
    @Log(title = "供应者管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Provider provider)
    {
        return toAjax(providerService.updateProvider(provider));
    }

    /**
     * 删除供应者管理
     */
    @PreAuthorize("@ss.hasPermi('database:provider:remove')")
    @Log(title = "供应者管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{providerIds}")
    public AjaxResult remove(@PathVariable Long[] providerIds)
    {
        return toAjax(providerService.deleteProviderByProviderIds(providerIds));
    }
}
