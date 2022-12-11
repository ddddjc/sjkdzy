package com.ruoyi.database.service;

import java.util.List;
import com.ruoyi.database.domain.DepotManager;

/**
 * 仓库管理员管理Service接口
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public interface IDepotManagerService 
{
    /**
     * 查询仓库管理员管理
     * 
     * @param depotManagerId 仓库管理员管理主键
     * @return 仓库管理员管理
     */
    public DepotManager selectDepotManagerByDepotManagerId(Long depotManagerId);

    /**
     * 查询仓库管理员管理列表
     * 
     * @param depotManager 仓库管理员管理
     * @return 仓库管理员管理集合
     */
    public List<DepotManager> selectDepotManagerList(DepotManager depotManager);

    /**
     * 新增仓库管理员管理
     * 
     * @param depotManager 仓库管理员管理
     * @return 结果
     */
    public int insertDepotManager(DepotManager depotManager);

    /**
     * 修改仓库管理员管理
     * 
     * @param depotManager 仓库管理员管理
     * @return 结果
     */
    public int updateDepotManager(DepotManager depotManager);

    /**
     * 批量删除仓库管理员管理
     * 
     * @param depotManagerIds 需要删除的仓库管理员管理主键集合
     * @return 结果
     */
    public int deleteDepotManagerByDepotManagerIds(Long[] depotManagerIds);

    /**
     * 删除仓库管理员管理信息
     * 
     * @param depotManagerId 仓库管理员管理主键
     * @return 结果
     */
    public int deleteDepotManagerByDepotManagerId(Long depotManagerId);
}
