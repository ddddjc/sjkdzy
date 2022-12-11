package com.ruoyi.database.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.ProviderMapper;
import com.ruoyi.database.domain.Provider;
import com.ruoyi.database.service.IProviderService;

/**
 * 供应者管理Service业务层处理
 * 
 * @author tinaliasd
 * @date 2022-12-11
 */
@Service
public class ProviderServiceImpl implements IProviderService 
{
    @Autowired
    private ProviderMapper providerMapper;

    /**
     * 查询供应者管理
     * 
     * @param providerId 供应者管理主键
     * @return 供应者管理
     */
    @Override
    public Provider selectProviderByProviderId(Long providerId)
    {
        return providerMapper.selectProviderByProviderId(providerId);
    }

    /**
     * 查询供应者管理列表
     * 
     * @param provider 供应者管理
     * @return 供应者管理
     */
    @Override
    public List<Provider> selectProviderList(Provider provider)
    {
        return providerMapper.selectProviderList(provider);
    }

    /**
     * 新增供应者管理
     * 
     * @param provider 供应者管理
     * @return 结果
     */
    @Override
    public int insertProvider(Provider provider)
    {
        provider.setCreateTime(DateUtils.getNowDate());
        return providerMapper.insertProvider(provider);
    }

    /**
     * 修改供应者管理
     * 
     * @param provider 供应者管理
     * @return 结果
     */
    @Override
    public int updateProvider(Provider provider)
    {
        provider.setUpdateTime(DateUtils.getNowDate());
        return providerMapper.updateProvider(provider);
    }

    /**
     * 批量删除供应者管理
     * 
     * @param providerIds 需要删除的供应者管理主键
     * @return 结果
     */
    @Override
    public int deleteProviderByProviderIds(Long[] providerIds)
    {
        return providerMapper.deleteProviderByProviderIds(providerIds);
    }

    /**
     * 删除供应者管理信息
     * 
     * @param providerId 供应者管理主键
     * @return 结果
     */
    @Override
    public int deleteProviderByProviderId(Long providerId)
    {
        return providerMapper.deleteProviderByProviderId(providerId);
    }
}
