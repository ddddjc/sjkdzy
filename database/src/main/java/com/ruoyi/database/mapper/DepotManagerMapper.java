package com.ruoyi.database.mapper;

import java.util.List;
import com.ruoyi.database.domain.DepotManager;
import com.ruoyi.database.domain.Depot;

/**
 * 仓库管理员管理Mapper接口
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public interface DepotManagerMapper 
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
     * 删除仓库管理员管理
     * 
     * @param depotManagerId 仓库管理员管理主键
     * @return 结果
     */
    public int deleteDepotManagerByDepotManagerId(Long depotManagerId);

    /**
     * 批量删除仓库管理员管理
     * 
     * @param depotManagerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepotManagerByDepotManagerIds(Long[] depotManagerIds);

    /**
     * 批量删除仓库管理
     * 
     * @param depotManagerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepotByDepotManagerIds(Long[] depotManagerIds);
    
    /**
     * 批量新增仓库管理
     * 
     * @param depotList 仓库管理列表
     * @return 结果
     */
    public int batchDepot(List<Depot> depotList);
    

    /**
     * 通过仓库管理员管理主键删除仓库管理信息
     * 
     * @param depotManagerId 仓库管理员管理ID
     * @return 结果
     */
    public int deleteDepotByDepotManagerId(Long depotManagerId);
}
