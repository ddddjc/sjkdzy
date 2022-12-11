package com.ruoyi.database.service;

import java.util.List;
import com.ruoyi.database.domain.Depot;

/**
 * 仓库管理Service接口
 * 
 * @author dujiachen
 * @date 2022-12-11
 */
public interface IDepotService 
{
    /**
     * 查询仓库管理
     * 
     * @param depotId 仓库管理主键
     * @return 仓库管理
     */
    public Depot selectDepotByDepotId(Long depotId);

    /**
     * 查询仓库管理列表
     * 
     * @param depot 仓库管理
     * @return 仓库管理集合
     */
    public List<Depot> selectDepotList(Depot depot);

    /**
     * 新增仓库管理
     * 
     * @param depot 仓库管理
     * @return 结果
     */
    public int insertDepot(Depot depot);

    /**
     * 修改仓库管理
     * 
     * @param depot 仓库管理
     * @return 结果
     */
    public int updateDepot(Depot depot);

    /**
     * 批量删除仓库管理
     * 
     * @param depotIds 需要删除的仓库管理主键集合
     * @return 结果
     */
    public int deleteDepotByDepotIds(Long[] depotIds);

    /**
     * 删除仓库管理信息
     * 
     * @param depotId 仓库管理主键
     * @return 结果
     */
    public int deleteDepotByDepotId(Long depotId);
}
