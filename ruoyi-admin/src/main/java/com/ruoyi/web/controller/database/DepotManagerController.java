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
import com.ruoyi.database.domain.DepotManager;
import com.ruoyi.database.service.IDepotManagerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库管理员管理Controller
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/manager")
public class DepotManagerController extends BaseController
{
    @Autowired
    private IDepotManagerService depotManagerService;

    /**
     * 查询仓库管理员管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(DepotManager depotManager)
    {
        startPage();
        List<DepotManager> list = depotManagerService.selectDepotManagerList(depotManager);
        return getDataTable(list);
    }

    /**
     * 导出仓库管理员管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:manager:export')")
    @Log(title = "仓库管理员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DepotManager depotManager)
    {
        List<DepotManager> list = depotManagerService.selectDepotManagerList(depotManager);
        ExcelUtil<DepotManager> util = new ExcelUtil<DepotManager>(DepotManager.class);
        util.exportExcel(response, list, "仓库管理员管理数据");
    }

    /**
     * 获取仓库管理员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:manager:query')")
    @GetMapping(value = "/{depotManagerId}")
    public AjaxResult getInfo(@PathVariable("depotManagerId") Long depotManagerId)
    {
        return AjaxResult.success(depotManagerService.selectDepotManagerByDepotManagerId(depotManagerId));
    }

    /**
     * 新增仓库管理员管理
     */
    @PreAuthorize("@ss.hasPermi('database:manager:add')")
    @Log(title = "仓库管理员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DepotManager depotManager)
    {
        return toAjax(depotManagerService.insertDepotManager(depotManager));
    }

    /**
     * 修改仓库管理员管理
     */
    @PreAuthorize("@ss.hasPermi('database:manager:edit')")
    @Log(title = "仓库管理员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DepotManager depotManager)
    {
        return toAjax(depotManagerService.updateDepotManager(depotManager));
    }

    /**
     * 删除仓库管理员管理
     */
    @PreAuthorize("@ss.hasPermi('database:manager:remove')")
    @Log(title = "仓库管理员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{depotManagerIds}")
    public AjaxResult remove(@PathVariable Long[] depotManagerIds)
    {
        return toAjax(depotManagerService.deleteDepotManagerByDepotManagerIds(depotManagerIds));
    }
}
