package com.ruoyi.database.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.database.domain.Depot;
import com.ruoyi.database.mapper.DepotManagerMapper;
import com.ruoyi.database.domain.DepotManager;
import com.ruoyi.database.service.IDepotManagerService;

/**
 * 仓库管理员管理Service业务层处理
 * 
 * @author tinaliasd
 * @date 2022-12-11
 */
@Service
public class DepotManagerServiceImpl implements IDepotManagerService 
{
    @Autowired
    private DepotManagerMapper depotManagerMapper;

    /**
     * 查询仓库管理员管理
     * 
     * @param depotManagerId 仓库管理员管理主键
     * @return 仓库管理员管理
     */
    @Override
    public DepotManager selectDepotManagerByDepotManagerId(Long depotManagerId)
    {
        return depotManagerMapper.selectDepotManagerByDepotManagerId(depotManagerId);
    }

    /**
     * 查询仓库管理员管理列表
     * 
     * @param depotManager 仓库管理员管理
     * @return 仓库管理员管理
     */
    @Override
    public List<DepotManager> selectDepotManagerList(DepotManager depotManager)
    {
        return depotManagerMapper.selectDepotManagerList(depotManager);
    }

    /**
     * 新增仓库管理员管理
     * 
     * @param depotManager 仓库管理员管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDepotManager(DepotManager depotManager)
    {
        depotManager.setCreateTime(DateUtils.getNowDate());
        int rows = depotManagerMapper.insertDepotManager(depotManager);
        insertDepot(depotManager);
        return rows;
    }

    /**
     * 修改仓库管理员管理
     * 
     * @param depotManager 仓库管理员管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDepotManager(DepotManager depotManager)
    {
        depotManager.setUpdateTime(DateUtils.getNowDate());
        depotManagerMapper.deleteDepotByDepotManagerId(depotManager.getDepotManagerId());
        insertDepot(depotManager);
        return depotManagerMapper.updateDepotManager(depotManager);
    }

    /**
     * 批量删除仓库管理员管理
     * 
     * @param depotManagerIds 需要删除的仓库管理员管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDepotManagerByDepotManagerIds(Long[] depotManagerIds)
    {
        depotManagerMapper.deleteDepotByDepotManagerIds(depotManagerIds);
        return depotManagerMapper.deleteDepotManagerByDepotManagerIds(depotManagerIds);
    }

    /**
     * 删除仓库管理员管理信息
     * 
     * @param depotManagerId 仓库管理员管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDepotManagerByDepotManagerId(Long depotManagerId)
    {
        depotManagerMapper.deleteDepotByDepotManagerId(depotManagerId);
        return depotManagerMapper.deleteDepotManagerByDepotManagerId(depotManagerId);
    }

    /**
     * 新增仓库管理信息
     * 
     * @param depotManager 仓库管理员管理对象
     */
    public void insertDepot(DepotManager depotManager)
    {
        List<Depot> depotList = depotManager.getDepotList();
        Long depotManagerId = depotManager.getDepotManagerId();
        if (StringUtils.isNotNull(depotList))
        {
            List<Depot> list = new ArrayList<Depot>();
            for (Depot depot : depotList)
            {
                depot.setDepotManagerId(depotManagerId);
                list.add(depot);
            }
            if (list.size() > 0)
            {
                depotManagerMapper.batchDepot(list);
            }
        }
    }
}
