package com.ruoyi.database.mapper;

import java.util.List;
import com.ruoyi.database.domain.Depot;

/**
 * 仓库管理Mapper接口
 * 
 * @author dujiachen
 * @date 2022-12-05
 */
public interface DepotMapper 
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
     * 删除仓库管理
     * 
     * @param depotId 仓库管理主键
     * @return 结果
     */
    public int deleteDepotByDepotId(Long depotId);

    /**
     * 批量删除仓库管理
     * 
     * @param depotIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepotByDepotIds(Long[] depotIds);
}
