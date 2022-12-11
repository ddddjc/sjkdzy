package com.ruoyi.database.mapper;

import java.util.List;
import com.ruoyi.database.domain.Provider;

/**
 * 供应者管理Mapper接口
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public interface ProviderMapper 
{
    /**
     * 查询供应者管理
     * 
     * @param providerId 供应者管理主键
     * @return 供应者管理
     */
    public Provider selectProviderByProviderId(Long providerId);

    /**
     * 查询供应者管理列表
     * 
     * @param provider 供应者管理
     * @return 供应者管理集合
     */
    public List<Provider> selectProviderList(Provider provider);

    /**
     * 新增供应者管理
     * 
     * @param provider 供应者管理
     * @return 结果
     */
    public int insertProvider(Provider provider);

    /**
     * 修改供应者管理
     * 
     * @param provider 供应者管理
     * @return 结果
     */
    public int updateProvider(Provider provider);

    /**
     * 删除供应者管理
     * 
     * @param providerId 供应者管理主键
     * @return 结果
     */
    public int deleteProviderByProviderId(Long providerId);

    /**
     * 批量删除供应者管理
     * 
     * @param providerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProviderByProviderIds(Long[] providerIds);
}
