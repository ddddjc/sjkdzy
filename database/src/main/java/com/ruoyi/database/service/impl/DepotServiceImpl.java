package com.ruoyi.database.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.DepotMapper;
import com.ruoyi.database.domain.Depot;
import com.ruoyi.database.service.IDepotService;

/**
 * 仓库管理Service业务层处理
 * 
 * @author dujiachen
 * @date 2022-12-05
 */
@Service
public class DepotServiceImpl implements IDepotService 
{
    @Autowired
    private DepotMapper depotMapper;



    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 查询仓库管理
     * 
     * @param depotId 仓库管理主键
     * @return 仓库管理
     */
    @Override
    public Depot selectDepotByDepotId(Long depotId)
    {
        return depotMapper.selectDepotByDepotId(depotId);
    }

    /**
     * 查询仓库管理列表
     * 
     * @param depot 仓库管理
     * @return 仓库管理
     */
    @Override
    public List<Depot> selectDepotList(Depot depot)
    {
        return depotMapper.selectDepotList(depot);
    }

    /**
     * 新增仓库管理
     * 
     * @param depot 仓库管理
     * @return 结果
     */
    @Override
    public int insertDepot(Depot depot)
    {
        depot.setDepotId(snowFlakeUtil.nextId());

        depot.setCreateTime(DateUtils.getNowDate());
        return depotMapper.insertDepot(depot);
    }

    /**
     * 修改仓库管理
     * 
     * @param depot 仓库管理
     * @return 结果
     */
    @Override
    public int updateDepot(Depot depot)
    {
        depot.setUpdateTime(DateUtils.getNowDate());
        return depotMapper.updateDepot(depot);
    }

    /**
     * 批量删除仓库管理
     * 
     * @param depotIds 需要删除的仓库管理主键
     * @return 结果
     */
    @Override
    public int deleteDepotByDepotIds(Long[] depotIds)
    {
        return depotMapper.deleteDepotByDepotIds(depotIds);
    }

    /**
     * 删除仓库管理信息
     * 
     * @param depotId 仓库管理主键
     * @return 结果
     */
    @Override
    public int deleteDepotByDepotId(Long depotId)
    {
        return depotMapper.deleteDepotByDepotId(depotId);
    }
}
