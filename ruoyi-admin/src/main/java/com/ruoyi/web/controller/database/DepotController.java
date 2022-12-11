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
import com.ruoyi.database.domain.Depot;
import com.ruoyi.database.service.IDepotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库管理Controller
 * 
 * @author dujiachen
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/database/depot")
public class DepotController extends BaseController
{
    @Autowired
    private IDepotService depotService;

    /**
     * 查询仓库管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:depot:list')")
    @GetMapping("/list")
    public TableDataInfo list(Depot depot)
    {
        startPage();
        List<Depot> list = depotService.selectDepotList(depot);
        return getDataTable(list);
    }

    /**
     * 导出仓库管理列表
     */
    @PreAuthorize("@ss.hasPermi('database:depot:export')")
    @Log(title = "仓库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Depot depot)
    {
        List<Depot> list = depotService.selectDepotList(depot);
        ExcelUtil<Depot> util = new ExcelUtil<Depot>(Depot.class);
        util.exportExcel(response, list, "仓库管理数据");
    }

    /**
     * 获取仓库管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('database:depot:query')")
    @GetMapping(value = "/{depotId}")
    public AjaxResult getInfo(@PathVariable("depotId") Long depotId)
    {
        return AjaxResult.success(depotService.selectDepotByDepotId(depotId));
    }

    /**
     * 新增仓库管理
     */
    @PreAuthorize("@ss.hasPermi('database:depot:add')")
    @Log(title = "仓库管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Depot depot)
    {
        return toAjax(depotService.insertDepot(depot));
    }

    /**
     * 修改仓库管理
     */
    @PreAuthorize("@ss.hasPermi('database:depot:edit')")
    @Log(title = "仓库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Depot depot)
    {
        return toAjax(depotService.updateDepot(depot));
    }

    /**
     * 删除仓库管理
     */
    @PreAuthorize("@ss.hasPermi('database:depot:remove')")
    @Log(title = "仓库管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{depotIds}")
    public AjaxResult remove(@PathVariable Long[] depotIds)
    {
        return toAjax(depotService.deleteDepotByDepotIds(depotIds));
    }
}
